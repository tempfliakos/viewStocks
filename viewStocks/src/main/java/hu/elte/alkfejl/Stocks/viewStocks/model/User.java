package hu.elte.alkfejl.Stocks.viewStocks.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(nullable = false, name = "NAME", unique = true)
    private String name;

    @JsonIgnore
    @Column(nullable = false, name = "PASSWORD")
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private Set<Portfolio> portfolios;

    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private Set<Watchlist> watchlists;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public User(String name, String password, Set<Portfolio> portfolios, Set<Watchlist> watchlists) {
        this.name = name;
        this.password = password;
        this.portfolios = portfolios;
        this.watchlists = watchlists;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Portfolio> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(Set<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }

    public Set<Watchlist> getWatchlists() {
        return watchlists;
    }

    public void setWatchlists(Set<Watchlist> watchlists) {
        this.watchlists = watchlists;
    }
}
