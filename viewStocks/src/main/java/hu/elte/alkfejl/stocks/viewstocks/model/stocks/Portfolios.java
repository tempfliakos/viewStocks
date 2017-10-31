package hu.elte.alkfejl.stocks.viewstocks.model.stocks;

import hu.elte.alkfejl.stocks.viewstocks.model.users.Users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Portfolios {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int ID;
    private int owner;
    private Set<Users> sharedWith;
    private int startingCash;
    private int remainingCash;
    private int lastValue;

    public Portfolios() {
    }

    public Portfolios(int owner, Set<Users> sharedWith, int startingCash, int remainingCash, int lastValue) {
        this.owner = owner;
        this.sharedWith = sharedWith;
        this.startingCash = startingCash;
        this.remainingCash = remainingCash;
        this.lastValue = lastValue;
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

    public Set<Users> getSharedWith() {
        return sharedWith;
    }

    public void setSharedWith(Set<Users> sharedWith) {
        this.sharedWith = sharedWith;
    }

    public int getStartingCash() {
        return startingCash;
    }

    public void setStartingCash(int startingCash) {
        this.startingCash = startingCash;
    }

    public int getRemainingCash() {
        return remainingCash;
    }

    public void setRemainingCash(int remainingCash) {
        this.remainingCash = remainingCash;
    }

    public int getLastValue() {
        return lastValue;
    }

    public void setLastValue(int lastValue) {
        this.lastValue = lastValue;
    }
}
