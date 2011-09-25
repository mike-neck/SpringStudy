package orz.mikeneck.spring.study.second.list.dao;

import org.springframework.dao.DataAccessException;
import orz.mikeneck.spring.study.second.list.exception.TeamNotFoundException;
import orz.mikeneck.spring.study.second.list.model.Team;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/11
 * Time: 14:25
 * To change this template use File | Settings | File Templates.
 */
public interface TeamDao {

    public List<Team> getTeamList() throws DataAccessException;
}
