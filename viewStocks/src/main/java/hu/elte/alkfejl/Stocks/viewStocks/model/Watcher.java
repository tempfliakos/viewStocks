package hu.elte.alkfejl.Stocks.viewStocks.model;

import javax.persistence.*;

@Entity
public class Watcher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private int ID;

    @Column(name = "USER")
    private int userID;

    @Column(name = "WATCHLIST")
    private int watchlistID;

    @Column(name = "TICKER")
    private String ticker;

    public Watcher() {
    }

    public Watcher(int userID, int watchlistID, String ticker) {
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
