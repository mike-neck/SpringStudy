package orz.mikeneck.spring.study.second.ticket.dao;

import orz.mikeneck.spring.study.second.ticket.model.Event;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mike
 * Date: 11/09/19
 * Time: 16:01
 * To change this template use File | Settings | File Templates.
 */
public interface EventDao {

    List<Event> getEventList(Date start, Date end);
}
