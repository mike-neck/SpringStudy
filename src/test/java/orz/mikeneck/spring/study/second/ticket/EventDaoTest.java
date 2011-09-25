package orz.mikeneck.spring.study.second.ticket;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import orz.mikeneck.spring.study.second.ticket.dao.EventDao;
import orz.mikeneck.spring.study.second.ticket.model.Event;
import orz.mikeneck.spring.study.util.PrepareTable;
import orz.mikeneck.spring.study.util.ticket.PrepareEvent;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: mike
 * Date: 11/09/19
 * Time: 17:03
 * To change this template use File | Settings | File Templates.
 */
public class EventDaoTest {

    private PrepareTable prepareEvent;

    private ApplicationContext context;

    @Test
    public void testGetEventList() {
        EventDao eventDao = (EventDao) context.getBean("eventDao");
        Date start = createDate(Calendar.SEPTEMBER, 30, 10, 0, 0);
        Date end = createDate(Calendar.OCTOBER, 1, 10, 0, 0);

        List<Event> list = eventDao.getEventList(start, end);
        assertThat(list.size(), is(3));
    }

    private Date createDate(int month, int date, int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2011);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DATE, date);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        return calendar.getTime();
    }

    @Before
    public void setUp() throws Exception {
        prepareEvent = new PrepareEvent();
        prepareEvent.prepare();
        context = new FileSystemXmlApplicationContext("src/main/resources/second/ticket/ticketContext.xml");
    }

    @After
    public void tearDown() throws Exception {
        prepareEvent.cleanup();
    }
}
