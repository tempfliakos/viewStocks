package hu.elte.alkfejl.Stocks.viewStocks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "WATCHER")
public class Watcher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "WATCHLIST_ID")
    private Watchlist watchlist;

    @Column(name = "TICKER")
    private String ticker;

}
