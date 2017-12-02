package hu.elte.alkfejl.Stocks.viewStocks.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRANSACTIONS")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PORTFOLIO_ID")
    private Portfolio portfolio;

    @Column(name = "TICKER", nullable = false)
    private String ticker;

    @Column(name = "TRANSACTION_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(name = "DATE", nullable = false)
    @Type(type = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column(name = "NUMBER_OF_SHARES", nullable = false)
    private Integer numberOfShares;

    @Column(name = "PRICE_PER_AMOUNT", nullable = false)
    private Double pricePerAmount;

    @Column(name = "COMMISSION")
    private Double commission = 0.0;

    @Column(name = "COST_BASIS")
    private Double costBasis;

    public Transaction() {
    }

    public Transaction(Portfolio portfolio, String ticker, TransactionType type, Date date, Integer numberOfShares, Double pricePerAmount, Double commission, Double costBasis) {
        this.portfolio = portfolio;
        this.ticker = ticker;
        this.type = type;
        this.date = date;
        this.numberOfShares = numberOfShares;
        this.pricePerAmount = pricePerAmount;
        this.commission = commission;
        this.costBasis = costBasis;
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

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(Integer numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public Double getPricePerAmount() {
        return pricePerAmount;
    }

    public void setPricePerAmount(Double pricePerAmount) {
        this.pricePerAmount = pricePerAmount;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Double getCostBasis() {
        return costBasis;
    }

    public void setCostBasis(Double costBasis) {
        this.costBasis = costBasis;
    }
}
