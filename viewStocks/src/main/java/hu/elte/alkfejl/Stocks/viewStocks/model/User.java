package hu.elte.alkfejl.Stocks.viewStocks.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(nullable = false, name = "EMAIL", unique = true)
    private String email;

    @JsonIgnore
    @Column(nullable = false, name = "PASSWORD")
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private Set<Portfolio> portfolios;

    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private Set<Watchlist> watchlists;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
