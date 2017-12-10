package hu.elte.alkfejl.Stocks.viewStocks.service;

import hu.elte.alkfejl.Stocks.viewStocks.model.Position;
import hu.elte.alkfejl.Stocks.viewStocks.wrapper.StockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        List<String> tickerList = new ArrayList<>(positions.keySet());
        String[] tickers = new String[tickerList.size()];
        tickerList.toArray(tickers);
        Map<String, Stock> stocks = YahooFinance.get(tickers);

        Map<String, StockDto> stockDtoMap = new HashMap<>();
        for (Map.Entry<String, Stock> s : stocks.entrySet()) {
            stockDtoMap.put(s.getKey(), new StockDto(s.getValue()));
        }

        return stockDtoMap;
    }

}
