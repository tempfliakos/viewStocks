package hu.elte.alkfejl.Stocks.viewStocks.service;

import hu.elte.alkfejl.Stocks.viewStocks.model.Position;
import hu.elte.alkfejl.Stocks.viewStocks.wrapper.StockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
public class FinanceApiService {

    @Autowired
    private PortfolioService portfolioService;

    public StockDto getQuote(Position position) throws IOException {
        Stock stock = YahooFinance.get(position.getTicker());
        return new StockDto(stock);
    }

    public Map<String, StockDto> getQuotes(Long portfolioId) throws IOException {
        Map<String, Position> positions = portfolioService.findById(portfolioId).getPositions();
        Map<String, StockDto> stockDtoMap = new HashMap<>();

        for (Map.Entry<String, Position> pe : positions.entrySet()) {
            Stock s = YahooFinance.get(pe.getKey());
            stockDtoMap.put(pe.getKey(), new StockDto(s));
        }

        return stockDtoMap;
    }

}
