package orz.mikeneck.spring.study.second.ticket.dao.impl;

import orz.mikeneck.spring.study.second.ticket.dao.EventDao;
import orz.mikeneck.spring.study.second.ticket.model.Event;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/14
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 */
public class EventDaoImpl implements EventDao {

    private EntityManagerFactory factory;

    private static final String QUERY = " FROM Event AS event"
            + " WHERE event.date >= :startDate"
            + " AND event.date <= :endDate";

    @PersistenceUnit
    public void setFactory(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Event> getEventList(Date start, Date end) {
        EntityManager entityManager = factory.createEntityManager();
        return entityManager.createQuery(QUERY, Event.class)
                .setParameter("startDate", start)
                .setParameter("endDate", end)
                .getResultList();
    }
}
