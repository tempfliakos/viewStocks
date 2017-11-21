package hu.elte.alkfejl.Stocks.viewStocks.service;

import hu.elte.alkfejl.Stocks.viewStocks.model.Portfolio;
import hu.elte.alkfejl.Stocks.viewStocks.model.Position;
import hu.elte.alkfejl.Stocks.viewStocks.model.User;
import hu.elte.alkfejl.Stocks.viewStocks.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Optional;
import java.util.Set;

@Service
@SessionScope
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;
    private Portfolio portfolio;
    private long id;

    public Optional<Portfolio> add(User owner, Set<Position> positions, double startingCash, double remainingCash, double lastValue) {
        Optional<Portfolio> optionalPortfolio = portfolioRepository.findById(id);   //TODO: id-t megszerezni valahonnan, mindig az utolsó id-t eltároljuk és lesz egy publikus getLastId metódus
        if(optionalPortfolio.isPresent()) {
            portfolio = new Portfolio();
            portfolio.setOwner(owner);
            portfolio.setPositions(positions);
            portfolio.setStartingCash(startingCash);
            portfolio.setRemainingCash(remainingCash);
            portfolio.setLastValue(lastValue);
            portfolioRepository.save(portfolio);
            return Optional.of(portfolio);
        }
        return Optional.empty();
    }

    public void delete(User owner, Set<Position> positions, double startingCash, double remainingCash, double lastValue) {
        portfolioRepository.delete(id);
    }

    public Optional<Portfolio> update(User owner, Set<Position> positions, double startingCash, double remainingCash, double lastValue) {
        Optional<Portfolio> optionalPortfolio = portfolioRepository.findById(id);
        if(optionalPortfolio.isPresent()) {
            portfolio = optionalPortfolio.get();
            portfolio.setOwner(owner);
            portfolio.setPositions(positions);
            portfolio.setStartingCash(startingCash);
            portfolio.setRemainingCash(remainingCash);
            portfolio.setLastValue(lastValue);
            portfolioRepository.save(portfolio);
            return Optional.of(portfolio);
        }
        return Optional.empty();
    }
}
