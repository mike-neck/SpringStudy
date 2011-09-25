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
 * Time: 22:19
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "account")
public class Account implements Serializable {

    private final static long serialVersionUID = 1L;

    private int accountId;

    private String name;

    private Set<Reservation> reservations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "account")
    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getAccountId() {
        return this.accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getAccountId()).append(getName()).toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Account) {
            Account user = (Account) object;
            return new EqualsBuilder()
                    .append(user.getAccountId(), getAccountId())
                    .append(user.getName(), getName())
                    .isEquals();
        }
        return false;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("accountId", getAccountId())
                .append("name", getName())
                .toString();
    }
}
