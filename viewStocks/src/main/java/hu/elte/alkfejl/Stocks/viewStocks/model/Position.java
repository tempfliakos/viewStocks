package hu.elte.alkfejl.Stocks.viewStocks.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "POSITION")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @OneToMany(mappedBy = "position")
    private Set<Transaction> transactions;

    @ManyToOne
    private Portfolio portfolio;

    @Column(name = "TICKER")
    private String ticker;

    private double numOfShares;

    //calculate from transaction costs
    private double cost;


    public Position() {
    }

    public Position(Set<Transaction> transactions, Portfolio portfolio, String ticker, double numOfShares, double cost) {
        this.transactions = transactions;
        this.portfolio = portfolio;
        this.ticker = ticker;
        this.numOfShares = numOfShares;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getNumOfShares() {
        return numOfShares;
    }

    public void setNumOfShares(double numOfShares) {
        this.numOfShares = numOfShares;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

