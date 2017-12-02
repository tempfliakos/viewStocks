package hu.elte.alkfejl.Stocks.viewStocks.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "POSITIONS")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PORTFOLIO_ID")
    private Portfolio portfolio;

    @Column(name = "TICKER")
    private String ticker;

    @Column(name = "NUM_OF_SHARES")
    private Integer numOfShares;

    @Column(name = "COST")
    private Double cost;

    public Position() {
    }

    public Position(Portfolio portfolio, String ticker, Integer numOfShares, Double cost) {
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

    public Integer getNumOfShares() {
        return numOfShares;
    }

    public void setNumOfShares(Integer numOfShares) {
        this.numOfShares = numOfShares;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
