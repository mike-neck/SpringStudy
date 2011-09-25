package orz.mikeneck.spring.study.second.ticket.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/13
 * Time: 22:17
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    private int eventId;

    private String name;

    private Date date;

    private Set<Ticket> tickets;

    private Set<Rank> ranks;

    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @OneToMany(mappedBy = "event")
    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @OneToMany(mappedBy = "event")
    public Set<Rank> getRanks() {
        return ranks;
    }

    public void setRanks(Set<Rank> ranks) {
        this.ranks = ranks;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getEventId())
                .append(getName())
                .append(getDate())
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Event) {
            Event event = (Event) object;
            return new EqualsBuilder()
                    .append(getEventId(), event.getEventId())
                    .append(getName(), event.getName())
                    .append(getDate(), event.getDate())
                    .isEquals();
        }
        return false;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("eventId", getEventId())
                .append("name", getName())
                .append("date", getDate())
                .toString();
    }
}
