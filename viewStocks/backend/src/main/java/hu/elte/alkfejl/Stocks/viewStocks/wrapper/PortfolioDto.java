package hu.elte.alkfejl.Stocks.viewStocks.wrapper;

import hu.elte.alkfejl.Stocks.viewStocks.model.Portfolio;
import hu.elte.alkfejl.Stocks.viewStocks.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioDto {

    private Long id;

    private String name;

    private User owner;

    private Double lastValue;

    public PortfolioDto(Portfolio portfolio) {
        this.id = portfolio.getId();
        this.name = portfolio.getName();
        this.owner = portfolio.getOwner();
        this.lastValue = portfolio.getLastValue();
    }

}
