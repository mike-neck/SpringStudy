package orz.mikeneck.spring.study.second.ticket.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/13
 * Time: 22:18
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;

    private int reservationId;

    private Timestamp timestamp;

    private Ticket ticket;

    private Account account;

    @Id
    @Column(name = "reservation_id")
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    @Column(name = "reservation_time_stamp")
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @OneToOne
    @JoinColumn(name = "reservation_id")
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getReservationId())
                .append(getTimestamp())
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Reservation) {
            Reservation reservation = (Reservation) object;
            return new EqualsBuilder()
                    .append(getReservationId(), reservation.getReservationId())
                    .append(getTimestamp(), reservation.getTimestamp())
                    .isEquals();
        }
        return false;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("reservationId", getReservationId())
                .append("account", getAccount())
                .toString();
    }
}
