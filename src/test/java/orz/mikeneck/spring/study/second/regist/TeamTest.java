package orz.mikeneck.spring.study.second.regist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import orz.mikeneck.spring.study.second.regist.dao.TeamDao;
import orz.mikeneck.spring.study.second.regist.model.Team;
import orz.mikeneck.spring.study.util.PrepareTable;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/11
 * Time: 20:09
 * To change this template use File | Settings | File Templates.
 */
public class TeamTest {

    private PrepareTable teamTable;

    @Test
    public void testGetTeam() throws Exception {
        ApplicationContext context =
                new FileSystemXmlApplicationContext("src/main/resources/second/regist/registMember.xml");
        TeamDao teamDao = (TeamDao) context.getBean("teamDao");
        Team team = teamDao.getTeam(1);
        assertThat(team.getId(), is(1));
        assertThat(team.getName(), is("東北海道"));

        team = teamDao.getTeam(20);
        assertNull(team);
    }

    @Before
    public void setUp() throws Exception {
        teamTable = new CreateTeamData();
        teamTable.prepare();
    }

    @After
    public void tearDown() throws Exception {
        teamTable.cleanup();
    }
}
