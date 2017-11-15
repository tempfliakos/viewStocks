package hu.elte.alkfejl.Stocks.viewStocks.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "WATCHLIST")
public class Watchlist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long ID;

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

    public Watchlist(User owner, Set<User> sharedWith) {
        this.owner = owner;
//        this.sharedWith = sharedWith;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

//    public Set<User> getSharedWith() {
//        return sharedWith;
//    }
//
//    public void setSharedWith(Set<User> sharedWith) {
//        this.sharedWith = sharedWith;
//    }

    public Set<Watcher> getWatchers() {
        return watchers;
    }

    public void setWatchers(Set<Watcher> watchers) {
        this.watchers = watchers;
    }
}
