package hu.elte.alkfejl.Stocks.viewStocks.controller;

import hu.elte.alkfejl.Stocks.viewStocks.model.Portfolio;
import hu.elte.alkfejl.Stocks.viewStocks.model.Transaction;
import hu.elte.alkfejl.Stocks.viewStocks.service.PortfolioService;
import hu.elte.alkfejl.Stocks.viewStocks.wrapper.PortfolioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Portfolio findById(@RequestParam Long portfolioId) {
        return portfolioService.findById(portfolioId);
    }

    @RequestMapping(value = "/getOwnedPortfolios", method = RequestMethod.GET)
    public List<PortfolioDto> getOwnedPortfolios(@RequestParam Long userId) {
        return portfolioService.getOwnedPortfolios(userId);
    }

}
