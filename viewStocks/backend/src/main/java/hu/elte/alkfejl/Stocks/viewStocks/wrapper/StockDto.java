package hu.elte.alkfejl.Stocks.viewStocks.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yahoofinance.Stock;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {

    private String ticker;
    private Double currentPrice;

    public StockDto(Stock stock) {
        this.ticker = stock.getSymbol();
        this.currentPrice = stock.getQuote().getPrice().doubleValue();
    }
    
}
