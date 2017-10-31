package hu.elte.alkfejl.stocks.viewstocks.model.watching;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Watchers {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int ID;
    private int userID;
    private int watchlistID;
    private String ticker;

    public Watchers() {
    }

    public Watchers(int userID, int watchlistID, String ticker) {
        this.userID = userID;
        this.watchlistID = watchlistID;
        this.ticker = ticker;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getWatchlistID() {
        return watchlistID;
    }

    public void setWatchlistID(int watchlistID) {
        this.watchlistID = watchlistID;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
}
