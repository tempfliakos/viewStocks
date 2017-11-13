package hu.elte.alkfejl.Stocks.viewStocks.model;

import hu.elte.alkfejl.Stocks.viewStocks.model.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Watchlist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private int ID;

    @Column(name = "OWNER")
    private User owner;

    @ManyToMany
    @Column(name = "SHARED")
    private Set<User> sharedWith;

    public Watchlist() {
    }

    public Watchlist(User owner, Set<User> sharedWith) {
        this.owner = owner;
        this.sharedWith = sharedWith;
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

    public Set<User> getSharedWith() {
        return sharedWith;
    }

    public void setSharedWith(Set<User> sharedWith) {
        this.sharedWith = sharedWith;
    }
}
