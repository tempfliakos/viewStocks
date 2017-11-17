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

}
