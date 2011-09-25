package orz.mikeneck.spring.study.second.regist.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import orz.mikeneck.spring.study.second.regist.dao.TeamDao;
import orz.mikeneck.spring.study.second.regist.model.Team;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/11
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */
public class TeamDaoImpl extends NamedParameterJdbcDaoSupport implements TeamDao {

    private static final String SELECT_BY_ID = "SELECT team_id, name FROM team WHERE team_id = :teamId";

    public static final String TEAM_ID = "team_id";

    public static final String NAME = "name";

    @Override
    public List<Team> getTeamList() throws DataAccessException {
        RowMapper<Team> teams = new TeamRowMapper();

        return getJdbcTemplate().query("SELECT team_id, name FROM team", teams);
    }

    @Override
    public Team getTeam(int teamId) throws DataAccessException {
        SqlParameterSource parameterSource = new MapSqlParameterSource("teamId", teamId);

        return getNamedParameterJdbcTemplate()
                .query(SELECT_BY_ID, parameterSource, new TeamResultSetExtractor());
    }

    protected class TeamRowMapper implements RowMapper<Team> {

        @Override
        public Team mapRow(ResultSet result, int row) throws SQLException {
            Team team = new Team();
            team.setId(result.getInt(TEAM_ID));
            team.setName(result.getString(NAME));

            return team;
        }
    }

    protected class TeamResultSetExtractor implements ResultSetExtractor<Team> {

        @Override
        public Team extractData(ResultSet result) throws SQLException, DataAccessException {
            if (result.next()) {
                Team team = new Team();
                team.setId(result.getInt(TEAM_ID));
                team.setName(result.getString(NAME));
                return team;
            }
            return null;
        }
    }
}
