package hu.elte.alkfejl.Stocks.viewStocks.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PORTFOLIO")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private int ID;

    @JoinColumn(name = "USER_ID", nullable = false)
    private User owner;

//    TODO: private Set<User> sharedWith;

    @OneToMany(mappedBy = "portfolio")
    private List<Transaction> transactions;

    @Column(name = "STARTING_CASH")
    private double startingCash;

    @Column(name = "REMAINING_CASH")
    private double remainingCash;

    @Column(name = "LAST_VALUE")
    private double lastValue;

    public Portfolio() {
    }

    public Portfolio(User owner, double startingCash, double remainingCash) {
        this.owner = owner;
        this.startingCash = startingCash;
        this.remainingCash = remainingCash;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public double getStartingCash() {
        return startingCash;
    }

    public void setStartingCash(double startingCash) {
        this.startingCash = startingCash;
    }

    public double getRemainingCash() {
        return remainingCash;
    }

    public void setRemainingCash(double remainingCash) {
        this.remainingCash = remainingCash;
    }

    public double getLastValue() {
        return lastValue;
    }

    public void setLastValue(double lastValue) {
        this.lastValue = lastValue;
    }
}
