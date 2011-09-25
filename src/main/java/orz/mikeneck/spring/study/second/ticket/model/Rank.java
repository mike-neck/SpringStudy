package orz.mikeneck.spring.study.second.ticket.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/13
 * Time: 22:17
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Rank implements Serializable {

    private static final long serialVersionUID = 1L;

    private int rankId;

    private String name;

    private int price;

    private Event event;

    private Set<Ticket> tickets;

    @Id
    @Column(name = "rank_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getRankId() {
        return rankId;
    }

    public void setRankId(int rankId) {
        this.rankId = rankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name = "event_id")
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @OneToMany(mappedBy = "rank")
    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getRankId())
                .append(getName())
                .append(getPrice())
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Rank) {
            Rank rank = (Rank) object;
            return new EqualsBuilder()
                    .append(getRankId(), rank.getRankId())
                    .append(getName(), rank.getName())
                    .append(getPrice(), rank.getPrice())
                    .isEquals();
        }
        return false;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("rankId", getRankId())
                .append("name", getName())
                .append("event", getEvent())
                .toString();
    }
}
