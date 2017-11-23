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

    public void add(Portfolio portfolio) {
       portfolioRepository.save(portfolio);
    }

    public void delete(Portfolio portfolio) {
        portfolioRepository.delete(portfolio);
    }

    public void update(Portfolio portfolio) {
        portfolioRepository.save(portfolio);
    }
}
