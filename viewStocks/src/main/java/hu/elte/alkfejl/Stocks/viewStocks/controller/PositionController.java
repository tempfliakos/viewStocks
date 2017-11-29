package hu.elte.alkfejl.Stocks.viewStocks.controller;

import hu.elte.alkfejl.Stocks.viewStocks.model.Portfolio;
import hu.elte.alkfejl.Stocks.viewStocks.model.Position;
import hu.elte.alkfejl.Stocks.viewStocks.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody Position position) {
        positionService.add(position);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody Position position) {
        positionService.delete(position);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody Position position) {
        positionService.update(position);
        }

    @RequestMapping(value = "/getPortfolioPositions", method = RequestMethod.GET)
    public List<Position> getPortfolioPositions(@RequestBody Portfolio portfolio){
        return positionService.getPortfolioPositions(portfolio);
    }
}
