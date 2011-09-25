package orz.mikeneck.spring.study.second.ticket.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/13
 * Time: 22:18
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    private int ticketId;

    private Reservation reservation;

    private Rank rank;

    private Event event;

    @OneToOne(mappedBy = "ticket")
    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @ManyToOne
    @JoinColumn(name = "rank_id")
    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @ManyToOne
    @JoinColumn(name = "event_id")
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getTicketId()).toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Ticket) {
            Ticket ticket = (Ticket) object;
            return new EqualsBuilder()
                    .append(getTicketId(), ticket.getTicketId())
                    .isEquals();
        }
        return false;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ticketId", getTicketId())
                .append("rank", getRank())
                .append("event", getEvent())
                .toString();
    }
}
