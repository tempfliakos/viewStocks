package hu.elte.alkfejl.Stocks.viewStocks.model;

import javax.persistence.*;

@Entity
@Table(name = "WATCHERS")
public class Watcher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "WATCHLIST_ID")
    private Watchlist watchlist;

    @Column(name = "TICKER")
    private String ticker;

    public Watcher() {
    }

    public Watcher(Watchlist watchlist, String ticker) {
        this.watchlist = watchlist;
        this.ticker = ticker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Watchlist getWatchlist() {
        return watchlist;
    }

    public void setWatchlist(Watchlist watchlist) {
        this.watchlist = watchlist;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
}
