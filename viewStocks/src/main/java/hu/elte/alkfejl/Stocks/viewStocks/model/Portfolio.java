package hu.elte.alkfejl.Stocks.viewStocks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PORTFOLIOS")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID", nullable = false)
    private User owner;

//    TODO: private Set<User> sharedWith;

    @OneToMany(mappedBy = "portfolio")
    private Map<String, Position> positions;

    @OneToMany(mappedBy = "portfolio")
    private Set<Transaction> transactions;

    @Column(name = "STARTING_CASH")
    private double startingCash;

    @Column(name = "REMAINING_CASH")
    private double remainingCash;

    @Column(name = "LAST_VALUE")
    private double lastValue;

}
