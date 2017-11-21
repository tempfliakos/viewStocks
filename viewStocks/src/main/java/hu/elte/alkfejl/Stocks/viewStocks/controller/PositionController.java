package hu.elte.alkfejl.Stocks.viewStocks.controller;

import hu.elte.alkfejl.Stocks.viewStocks.model.Portfolio;
import hu.elte.alkfejl.Stocks.viewStocks.model.Position;
import hu.elte.alkfejl.Stocks.viewStocks.model.Transaction;
import hu.elte.alkfejl.Stocks.viewStocks.service.PositionService;
import hu.elte.alkfejl.Stocks.viewStocks.util.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    private Position position;

    @RequestMapping(name = "/add", method = RequestMethod.POST)
    public Response<Object> add(@RequestParam(value = "transactions") Set<Transaction> transactions,
                                @RequestParam(value = "portfolio") Portfolio portfolio,
                                @RequestParam(value = "ticker") String ticker,
                                @RequestParam(value = "numOfShares") double numOfShares,
                                @RequestParam(value = "cost") double cost) {
        Optional<Position> optionalPosition = positionService.add(transactions,portfolio,ticker,numOfShares,cost);
        if(optionalPosition.isPresent()) {
            position = optionalPosition.get();
            return Response.ok(position);
        }
        return Response.error("Can't add this position!");
    }

    @RequestMapping(name = "/delete", method = RequestMethod.POST)
    public Response<Object> delete(@RequestParam(value = "transactions") Set<Transaction> transactions,
                                   @RequestParam(value = "portfolio") Portfolio portfolio,
                                   @RequestParam(value = "ticker") String ticker,
                                   @RequestParam(value = "numOfShares") double numOfShares,
                                   @RequestParam(value = "cost") double cost) {
        positionService.delete(transactions,portfolio,ticker,numOfShares,cost);
        return Response.ok("Delete was successfull!");
    }

    @RequestMapping(name = "/update", method = RequestMethod.POST)
    public Response<Object> update(@RequestParam(value = "transactions") Set<Transaction> transactions,
                                   @RequestParam(value = "portfolio") Portfolio portfolio,
                                   @RequestParam(value = "ticker") String ticker,
                                   @RequestParam(value = "numOfShares") double numOfShares,
                                   @RequestParam(value = "cost") double cost) {
        Optional<Position> optionalPosition = positionService.update(transactions,portfolio,ticker,numOfShares,cost);
        if(optionalPosition.isPresent()) {
            position = optionalPosition.get();
            return Response.ok(position);
        }
        return Response.error("Can't modify this position!");
    }
}
