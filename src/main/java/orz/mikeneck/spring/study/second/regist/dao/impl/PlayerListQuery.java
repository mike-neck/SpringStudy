package orz.mikeneck.spring.study.second.regist.dao.impl;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import orz.mikeneck.spring.study.second.regist.model.Team;
import orz.mikeneck.spring.study.second.regist.model.Player;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/12
 * Time: 20:31
 * To change this template use File | Settings | File Templates.
 */
public class PlayerListQuery extends MappingSqlQuery<Player> {

    private static final String SQL =
            "SELECT"
            + " player_id   AS playerId,"
            + " player.name AS playerName,"
            + " team.team_id     AS teamId,"
            + " team.name   AS teamName"
            + " FROM player LEFT JOIN team"
            + " ON (player.team_id = team.team_id)"
            + " WHERE team.team_id = ?";

    public PlayerListQuery(DataSource dataSource) {
        super(dataSource, SQL);
        super.declareParameter(new SqlParameter("team_id", Types.INTEGER));
        compile();
    }

    @Override
    protected Player mapRow(ResultSet result, int row) throws SQLException {
        Player player = new Player();
        player.setId(result.getInt("playerId"));
        player.setName(result.getString("playerName"));
        Team team = new Team();
        team.setId(result.getInt("teamId"));
        player.setName(result.getString("teamName"));
        player.setTeam(team);

        return player;
    }
}
