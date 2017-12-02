package hu.elte.alkfejl.Stocks.viewStocks.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "WATCHLISTS")
public class Watchlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private User owner;

//    @ManyToMany
//    @Column(name = "SHARED")
//    private Set<User> sharedWith;

    @OneToMany(mappedBy = "watchlist")
    private Set<Watcher> watchers;

    public Watchlist() {
    }

    public Watchlist(User owner, Set<Watcher> watchers) {
        this.owner = owner;
        this.watchers = watchers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Watcher> getWatchers() {
        return watchers;
    }

    public void setWatchers(Set<Watcher> watchers) {
        this.watchers = watchers;
    }
}
