package orz.mikeneck.spring.study.second.regist.dao;

import org.springframework.dao.DataAccessException;
import orz.mikeneck.spring.study.second.regist.model.Team;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/11
 * Time: 18:24
 * To change this template use File | Settings | File Templates.
 */
public interface TeamDao {

    public List<Team> getTeamList() throws DataAccessException;

    public Team getTeam(int teamId) throws DataAccessException;
}
