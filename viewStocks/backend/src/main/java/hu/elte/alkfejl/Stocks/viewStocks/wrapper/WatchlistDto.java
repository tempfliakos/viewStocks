package hu.elte.alkfejl.Stocks.viewStocks.wrapper;

import hu.elte.alkfejl.Stocks.viewStocks.model.User;
import hu.elte.alkfejl.Stocks.viewStocks.model.Watchlist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WatchlistDto {

    private Long id;

    private User owner;

    public WatchlistDto(Watchlist watchlist) {
        this.id = watchlist.getId();
        this.owner = watchlist.getOwner();
    }

}
