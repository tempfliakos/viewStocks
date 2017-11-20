package hu.elte.alkfejl.Stocks.viewStocks.controller;

import hu.elte.alkfejl.Stocks.viewStocks.model.Portfolio;
import hu.elte.alkfejl.Stocks.viewStocks.model.Position;
import hu.elte.alkfejl.Stocks.viewStocks.model.User;
import hu.elte.alkfejl.Stocks.viewStocks.service.PortfolioService;
import hu.elte.alkfejl.Stocks.viewStocks.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Response<Object> add(@RequestParam(value = "owner")User owner,
                                @RequestParam(value = "positions") Set<Position> positions,
                                @RequestParam(value = "startingCash") double startingCash,
                                @RequestParam(value = "remainingCash") double remainingCash,
                                @RequestParam(value = "lastValue") double lastValue) {
        Optional<Portfolio> optionalPortfolio = portfolioService.add(owner,positions,startingCash,remainingCash,lastValue);
        if (optionalPortfolio.isPresent()) {
            Portfolio portfolio = optionalPortfolio.get();

            return Response.ok(portfolio);
        }
        return Response.error("Can't add this portfolio!");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Response<Object> delete(@RequestParam(value = "owner")User owner,
                                @RequestParam(value = "positions") Set<Position> positions,
                                @RequestParam(value = "startingCash") double startingCash,
                                @RequestParam(value = "remainingCash") double remainingCash,
                                @RequestParam(value = "lastValue") double lastValue) {
        Optional<Portfolio> optionalPortfolio = portfolioService.delete(owner,positions,startingCash,remainingCash,lastValue);
        if (!optionalPortfolio.isPresent()) {
            return Response.ok("Delete successfull!");
        }
        return Response.error("Can't delete this portfolio!");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Response<Object> update(@RequestParam(value = "owner")User owner,
                                   @RequestParam(value = "positions") Set<Position> positions,
                                   @RequestParam(value = "startingCash") double startingCash,
                                   @RequestParam(value = "remainingCash") double remainingCash,
                                   @RequestParam(value = "lastValue") double lastValue) {
        Optional<Portfolio> optionalPortfolio = portfolioService.update(owner,positions,startingCash,remainingCash,lastValue);
        if (optionalPortfolio.isPresent()) {
            return Response.ok("Update successfull!");
        }
        return Response.error("Can't update this portfolio!");
    }

}
