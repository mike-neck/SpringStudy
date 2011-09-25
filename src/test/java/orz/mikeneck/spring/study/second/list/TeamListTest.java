package orz.mikeneck.spring.study.second.list;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import orz.mikeneck.spring.study.second.list.dao.TeamDao;
import orz.mikeneck.spring.study.second.list.model.Team;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertTrue;


/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/11
 * Time: 15:32
 * To change this template use File | Settings | File Templates.
 */
public class TeamListTest {

    private CreateListData environment;

    private static final String CONTEXT_XML = "src/main/resources/second/list/listTeam.xml";

    @Test
    public void testFileExists() {
        File file = new File(CONTEXT_XML);
        assertTrue(file.exists());
    }

    @Test
    public void testGetList() {
        ApplicationContext context =
                new FileSystemXmlApplicationContext(CONTEXT_XML);
        TeamDao dao = (TeamDao) context.getBean("listDao");

        List<Team> list = dao.getTeamList();
        assertThat(list.size(), is(8));

        Team team = new Team();
        team.setId(1);
        team.setName("東北海道");
        assertTrue(list.contains(team));

        team = new Team();
        team.setId(13);
        team.setName("東京");
        assertFalse(list.contains(team));
    }

    @Before
    public void setUp() throws Exception {
        environment = new CreateListData();
        environment.createData();
    }

    @After
    public void tearDown() throws Exception {
        environment.removeData();
    }
}
