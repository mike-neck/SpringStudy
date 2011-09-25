package orz.mikeneck.spring.study.second.list.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import orz.mikeneck.spring.study.second.list.dao.TeamDao;
import orz.mikeneck.spring.study.second.list.exception.TeamNotFoundException;
import orz.mikeneck.spring.study.second.list.model.Team;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/11
 * Time: 14:21
 * To change this template use File | Settings | File Templates.
 */
public class TeamDaoImpl extends JdbcDaoSupport implements TeamDao {

    private static String SELECT = "SELECT team_id, name FROM team";

    @Override
    public List<Team> getTeamList() throws DataAccessException {
        RowMapper<Team> mapper = new TeamRowMapper();
        return getJdbcTemplate().query(SELECT, mapper);
    }

    protected class TeamRowMapper implements RowMapper<Team> {

        private List<Team> teams = new ArrayList<Team>();

        public List<Team> getResults() {
            return teams;
        }

        @Override
        public Team mapRow(ResultSet result, int row) throws SQLException {
            Team team = new Team();
            team.setId(result.getInt("team_id"));
            team.setName(result.getString("name"));
            return team;
        }
    }
}
