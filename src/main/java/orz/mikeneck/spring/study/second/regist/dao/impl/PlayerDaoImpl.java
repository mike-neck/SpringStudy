package orz.mikeneck.spring.study.second.regist.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import orz.mikeneck.spring.study.second.regist.dao.PlayerDao;
import orz.mikeneck.spring.study.second.regist.model.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/11
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */
public class PlayerDaoImpl extends JdbcDaoSupport implements PlayerDao {

    private SimpleJdbcInsert insert;

    private MappingSqlQuery<Player> playerListQuery;

    private MappingSqlQuery<Player> playerQuery;

    private SqlUpdate deletePlayer;

    private SqlUpdate updatePlayer;

    @Override
    protected void initDao() throws Exception {
        this.insert = new SimpleJdbcInsert(getDataSource())
                .withTableName("player")
                .usingGeneratedKeyColumns("player_id");
        this.playerListQuery = new PlayerListQuery(getDataSource());
        this.playerQuery = new PlayerQuery(getDataSource());
        this.deletePlayer = new DeletePlayer(getDataSource());
        this.updatePlayer = new UpdatePlayer(getDataSource());
    }

    @Override
    public void insertPlayer(Player player) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", player.getName());
        params.put("team_id", player.getTeam().getId());

        Number newId = insert.executeAndReturnKey(params);
        player.setId(newId.intValue());
    }

    @Override
    public List<Player> getPlayerList(int teamId) throws DataAccessException {
        return playerListQuery.execute(teamId);
    }

    @Override
    public Player getPlayerById(int playerId) throws DataAccessException {
        return playerQuery.findObject(playerId);
    }

    @Override
    public void deletePlayer(Player player) throws DataAccessException {
        deletePlayer.update(player.getId());
    }

    @Override
    public void updatePlayer(Player player) throws DataAccessException {
        updatePlayer.update(player.getName(), player.getTeam().getId(), player.getId());
    }
}
