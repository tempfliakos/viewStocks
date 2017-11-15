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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID", nullable = false)
    private User owner;

//    TODO: private Set<User> sharedWith;

    @OneToMany(mappedBy = "portfolio")
    private Set<Position> positions;

    @Column(name = "STARTING_CASH")
    private double startingCash;

    @Column(name = "REMAINING_CASH")
    private double remainingCash;

    @Column(name = "LAST_VALUE")
    private double lastValue;

    public Portfolio() {}

    public Portfolio(User owner, Set<Position> positions, double startingCash, double remainingCash, double lastValue) {
        this.owner = owner;
        this.positions = positions;
        this.startingCash = startingCash;
        this.remainingCash = remainingCash;
        this.lastValue = lastValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }
}
