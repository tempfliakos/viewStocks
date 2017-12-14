package hu.elte.alkfejl.Stocks.viewStocks.controller;

import hu.elte.alkfejl.Stocks.viewStocks.model.Position;
import hu.elte.alkfejl.Stocks.viewStocks.service.FinanceApiService;
import hu.elte.alkfejl.Stocks.viewStocks.wrapper.StockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class FinanceApiController {

    @Autowired
    private FinanceApiService financeApiService;

    @RequestMapping(value = "/getQuote", method = RequestMethod.GET)
    public StockDto getQuote(@RequestBody Position position) throws IOException {
        return financeApiService.getQuote(position);
    }

    @RequestMapping("/getQuotesForPortfolio")
    public Map<String, StockDto> getQuotes(@RequestParam Long portfolioId) throws IOException {
        return financeApiService.getQuotes(portfolioId);
    }

}
