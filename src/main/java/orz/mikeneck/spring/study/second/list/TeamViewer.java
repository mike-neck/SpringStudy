package orz.mikeneck.spring.study.second.list;

import orz.mikeneck.spring.study.second.list.dao.TeamDao;
import orz.mikeneck.spring.study.second.list.model.Team;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/11
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 */
public class TeamViewer implements Viewer {

    public TeamDao getTeamDao() {
        return teamDao;
    }

    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    private TeamDao teamDao;

    @Override
    public void show() {
        List<Team> list = teamDao.getTeamList();
        for (Team team : list) {
            System.out.println("id => " + team.getId() + " / name => " + team.getName());
        }
    }
}
