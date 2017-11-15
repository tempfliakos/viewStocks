package hu.elte.alkfejl.Stocks.viewStocks.model;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRANSACTION")
public class Transaction { //TODO: annotations

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "POSITION_ID")
    private Position position;

    @Column(name = "TICKER")
    private String ticker;

    @Column(name = "TRANSACTION_TYPE")
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(name = "DATE")
    @Type(type="date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date date;

    @Column(name = "NUMBER_OF_SHARES")
    private int numberOfShares;

    @Column(name = "PRICE_PER_AMOUNT")
    private double pricePerAmount;

    @Column(name = "COST_BASIS")
    private double costBasis;

    @Column(name = "COMMISSION")
    private double commission;

    @Column(name = "DEDUCT_FROM_CASH")
    private boolean deductFromCash;

    public Transaction() {
    }

    public Transaction(Position position, String ticker, TransactionType type, Date date, int numberOfShares, double pricePerAmount, double costBasis, double commission, boolean deductFromCash) {
        this.position = position;
        this.ticker = ticker;
        this.type = type;
        this.date = date;
        this.numberOfShares = numberOfShares;
        this.pricePerAmount = pricePerAmount;
        this.costBasis = costBasis;
        this.commission = commission;
        this.deductFromCash = deductFromCash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public double getPricePerAmount() {
        return pricePerAmount;
    }

    public void setPricePerAmount(double pricePerAmount) {
        this.pricePerAmount = pricePerAmount;
    }

    public double getCostBasis() {
        return costBasis;
    }

    public void setCostBasis(double costBasis) {
        this.costBasis = costBasis;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public boolean isDeductFromCash() {
        return deductFromCash;
    }

    public void setDeductFromCash(boolean deductFromCash) {
        this.deductFromCash = deductFromCash;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
