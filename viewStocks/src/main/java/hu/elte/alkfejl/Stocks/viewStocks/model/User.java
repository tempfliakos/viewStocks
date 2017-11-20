package hu.elte.alkfejl.Stocks.viewStocks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(nullable = false, name = "EMAIL", length = 30, unique = true)
    private String email;

    @Column(nullable = false, name = "PASSWORD", length = 15)
    private String password;

    @OneToMany(mappedBy = "owner")
    private Set<Portfolio> portfolios;

    @OneToMany(mappedBy = "owner")
    private Set<Watchlist> watchlists;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


}
