package hu.elte.alkfejl.Stocks.viewStocks.controller;

import hu.elte.alkfejl.Stocks.viewStocks.model.Portfolio;
import hu.elte.alkfejl.Stocks.viewStocks.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Portfolio add(@RequestBody Portfolio portfolio) {
        return portfolioService.add(portfolio);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody Portfolio portfolio) {
        portfolioService.delete(portfolio);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Portfolio update(@RequestBody Portfolio portfolio) {
        return portfolioService.update(portfolio);
    }

    @RequestMapping(value = "/getUserPortfoios", method = RequestMethod.GET)
    public List<Portfolio> getUserPortfolios(@PathVariable Long userId) {
        return portfolioService.getUserPortfolios(userId);
    }

}
