package hu.elte.alkfejl.stocks.viewstocks.model.stocks;

import com.sun.istack.internal.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int ID;
    private int userID;
    private int portfolio_ID;
    private String ticker;
    private String type;
    private Date date;
    private int numberOfShares;
    private int costBasis;
    private int commission;
    @Nullable
    private boolean deductFromCash;

    public Transactions() {
    }

    public Transactions(int userID, int portfolio_ID, String ticker, String type, Date date, int numberOfShares,
                        int costBasis, int commission, boolean deductFromCash) {
        this.userID = userID;
        this.portfolio_ID = portfolio_ID;
        this.ticker = ticker;
        this.type = type;
        this.date = date;
        this.numberOfShares = numberOfShares;
        this.costBasis = costBasis;
        this.commission = commission;
        this.deductFromCash = deductFromCash;
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

    public int getPortfolio_ID() {
        return portfolio_ID;
    }

    public void setPortfolio_ID(int portfolio_ID) {
        this.portfolio_ID = portfolio_ID;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public int getCostBasis() {
        return costBasis;
    }

    public void setCostBasis(int costBasis) {
        this.costBasis = costBasis;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public boolean getDeductFromCash() {
        return deductFromCash;
    }

    public void  setDeductFromCash(boolean deductFromCash) {
        this.deductFromCash = deductFromCash;
    }
}
