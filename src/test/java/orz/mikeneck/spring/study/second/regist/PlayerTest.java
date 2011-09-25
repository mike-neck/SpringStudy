package orz.mikeneck.spring.study.second.regist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import orz.mikeneck.spring.study.second.regist.dao.PlayerDao;
import orz.mikeneck.spring.study.second.regist.dao.TeamDao;
import orz.mikeneck.spring.study.second.regist.model.Player;
import orz.mikeneck.spring.study.second.regist.model.Team;
import orz.mikeneck.spring.study.util.PrepareTable;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/11
 * Time: 19:34
 * To change this template use File | Settings | File Templates.
 */
public class PlayerTest {

    private static final String CONTEXT_XML = "src/main/resources/second/regist/registMember.xml";

    private static final int TEAM_SIZE = 8;

    private PrepareTable playerTable;

    private PrepareTable teamTable;

    private ApplicationContext applicationContext;

    private TeamDao teamDao;

    private PlayerDao playerDao;

    @Test
    public void testSetUpProperly() {
        assertThat(playerTable, is(notNullValue()));
        assertThat(teamTable, is(notNullValue()));
        assertThat(applicationContext, is(notNullValue()));
        assertThat(teamDao, is(notNullValue()));
        assertThat(playerDao, is(notNullValue()));
    }

    @Test
    public void testInsertPlayer() {
        Player player = new Player();
        player.setName("test");
        player.setTeam(teamDao.getTeam(1));

        playerDao.insertPlayer(player);

        assertThat(player.getId(), is(notNullValue()));
        assertThat(player.getId(), is(not(0)));
        assertThat(player.getId(), is(1));
    }

    @Test
    public void testGetPlayerList() {
        createTestPlayer();

        List<Player> playerList = playerDao.getPlayerList(3);
        int number = 3;
        for (Player player : playerList) {
            assertThat(player.getTeam(), is(teamDao.getTeam(3)));
            assertThat(player.getId() % TEAM_SIZE, is(3));
        }
    }

    @Test
    public void testGetPlayerById() {
        createTestPlayer();

        for (int i = 1; i <= 40; i += 1) {
            Player player = playerDao.getPlayerById(i);
            assertThat(player.getId(), is(i));
            assertThat(player.getName(), is("name_" + i));
            assertThat(player.getTeam(), is(teamDao.getTeam(extractTeamId(i))));
        }
    }

    @Test
    public void testDeletePlayer() {
        createTestPlayer();

        Player player = playerDao.getPlayerById(1);
        playerDao.deletePlayer(player);

        assertThat(playerDao.getPlayerById(1), is(nullValue()));
        List<Player> playerList = playerDao.getPlayerList(1);
        assertFalse(playerList.contains(player));
    }

    @Test
    public void testUpdatePlayer() {
        createTestPlayer();

        Player player = playerDao.getPlayerById(1);
        player.setName("hoge");
        Team team = teamDao.getTeam(3);
        player.setTeam(team);

        playerDao.updatePlayer(player);

        List<Player> playerList = playerDao.getPlayerList(1);
        assertFalse(playerList.contains(player));

        playerList = playerDao.getPlayerList(3);
        assertTrue(playerList.contains(player));
    }

    private void createTestPlayer() {
        for (int i = 1; i <= 40; i += 1) {
            Player player = new Player();
            player.setName("name_" + i);
            int teamId = extractTeamId(i);
            player.setTeam(teamDao.getTeam(teamId));

            playerDao.insertPlayer(player);
        }
    }

    private int extractTeamId(int number) {
        return (number % TEAM_SIZE == 0)? TEAM_SIZE : number % TEAM_SIZE;
    }

    @Before
    public void setUp() throws Exception {
        teamTable = new CreateTeamData();
        playerTable = new CreatePlayerTable();
        teamTable.prepare();
        playerTable.prepare();

        applicationContext = new FileSystemXmlApplicationContext(CONTEXT_XML);
        teamDao = (TeamDao) applicationContext.getBean("teamDao");
        playerDao = (PlayerDao) applicationContext.getBean("playerDao");
    }

    @After
    public void tearDown() throws Exception {
        teamTable.cleanup();
        playerTable.cleanup();
    }
}
