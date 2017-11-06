package hu.elte.alkfejl.stocks.viewstocks.model.watching;

import hu.elte.alkfejl.stocks.viewstocks.model.users.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Watchlists {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int ID;
    private int owner;
    private Set<User> sharedWith;

    public Watchlists() {
    }

    public Watchlists(int owner, Set<User> sharedWith) {
        this.owner = owner;
        this.sharedWith = sharedWith;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public Set<User> getSharedWith() {
        return sharedWith;
    }

    public void setSharedWith(Set<User> sharedWith) {
        this.sharedWith = sharedWith;
    }
}
