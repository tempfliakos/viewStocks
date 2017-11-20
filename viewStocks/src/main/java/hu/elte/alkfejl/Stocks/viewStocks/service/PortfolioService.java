package hu.elte.alkfejl.Stocks.viewStocks.service;

import hu.elte.alkfejl.Stocks.viewStocks.model.Portfolio;
import hu.elte.alkfejl.Stocks.viewStocks.model.Position;
import hu.elte.alkfejl.Stocks.viewStocks.model.User;
import hu.elte.alkfejl.Stocks.viewStocks.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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

    public Optional<Portfolio> add(User owner, Set<Position> positions, double startingCash, double remainingCash, double lastValue) {
        Optional<Portfolio> optionalPortfolio = portfolioRepository.findById(id);   //TODO: id-t megszerezni valahonnan
        if(!optionalPortfolio.isPresent()) {
            portfolio = optionalPortfolio.get();
            portfolioRepository.save(portfolio);
            return Optional.of(portfolio);
        }
        return Optional.empty();
    }

    public Optional<Portfolio> delete(User owner, Set<Position> positions, double startingCash, double remainingCash, double lastValue) {
    }

    public Optional<Portfolio> update(User owner, Set<Position> positions, double startingCash, double remainingCash, double lastValue) {
    }
}
