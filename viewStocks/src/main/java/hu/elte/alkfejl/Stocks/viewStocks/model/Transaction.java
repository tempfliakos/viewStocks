package hu.elte.alkfejl.Stocks.viewStocks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TRANSACTIONS")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "POSITION_ID")
    private Position position;

    @Column(name = "TICKER", nullable = false)
    private String ticker;

    @Column(name = "TRANSACTION_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(name = "DATE", nullable = false)
    @Type(type = "date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date date;

    @Column(name = "NUMBER_OF_SHARES", nullable = false)
    private int numberOfShares;

    @Column(name = "PRICE_PER_AMOUNT", nullable = false)
    private double pricePerAmount;

    @Column(name = "COMMISSION")
    private double commission;

    @Column(name = "COST_BASIS")
    @Formula("NUMBER_OF_SHARES * PRICE_PER_AMOUNT - COMMISION")
    private double costBasis;

    @Column(name = "DEDUCT_FROM_CASH", nullable = false)
    private boolean deductFromCash;

}
