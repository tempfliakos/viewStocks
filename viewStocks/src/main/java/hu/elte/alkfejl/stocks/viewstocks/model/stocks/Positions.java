package hu.elte.alkfejl.stocks.viewstocks.model.stocks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Positions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int ID;
    private int userID;
    private int portfolioID;
    private int ticker;
    private int size;
    private int cost;

    public Positions() {
    }

    public Positions(int userID, int portfolioID, int ticker, int size, int cost) {
        this.userID = userID;
        this.portfolioID = portfolioID;
        this.ticker = ticker;
        this.size = size;
        this.cost = cost;
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

    public int getPortfolioID() {
        return portfolioID;
    }

    public void setPortfolioID(int portfolioID) {
        this.portfolioID = portfolioID;
    }

    public int getTicker() {
        return ticker;
    }

    public void setTicker(int ticker) {
        this.ticker = ticker;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
