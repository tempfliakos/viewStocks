package hu.elte.alkfejl.Stocks.viewStocks.service;

import hu.elte.alkfejl.Stocks.viewStocks.model.Portfolio;
import hu.elte.alkfejl.Stocks.viewStocks.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
@SessionScope
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    public Portfolio add(Portfolio portfolio) {
       return portfolioRepository.save(portfolio);
    }

    public void delete(Portfolio portfolio) {
        portfolioRepository.delete(portfolio);
    }

    public Portfolio update(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    public Portfolio getById(Long portfolioId) {
        return portfolioRepository.findOne(portfolioId);
    }

    public List<Portfolio> getOwnedPortfolios(Long userId) {
        return portfolioRepository.findByOwnerId(userId);
    }
}
