package hu.elte.alkfejl.Stocks.viewStocks.controller;

import hu.elte.alkfejl.Stocks.viewStocks.model.Portfolio;
import hu.elte.alkfejl.Stocks.viewStocks.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody Portfolio portfolio) {
        portfolioService.add(portfolio);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody Portfolio portfolio) {
        portfolioService.delete(portfolio);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(@RequestBody Portfolio portfolio) {
        portfolioService.update(portfolio);
    }

}
