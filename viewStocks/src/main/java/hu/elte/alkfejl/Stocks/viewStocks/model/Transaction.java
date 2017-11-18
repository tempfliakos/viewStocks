package hu.elte.alkfejl.Stocks.viewStocks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TRANSACTION")
public class Transaction { //TODO: annotations

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

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

}
