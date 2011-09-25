package orz.mikeneck.spring.study.second.regist.dao;

import org.springframework.dao.DataAccessException;
import orz.mikeneck.spring.study.second.regist.model.Player;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/11
 * Time: 17:53
 * To change this template use File | Settings | File Templates.
 */
public interface PlayerDao {

    void insertPlayer(Player player) throws DataAccessException;

    List<Player> getPlayerList(int teamId) throws DataAccessException;

    Player getPlayerById(int playerId) throws DataAccessException;

    void deletePlayer(Player player) throws DataAccessException;

    void updatePlayer(Player player) throws DataAccessException;
}
