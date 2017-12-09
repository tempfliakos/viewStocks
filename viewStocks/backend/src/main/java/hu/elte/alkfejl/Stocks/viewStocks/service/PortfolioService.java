package hu.elte.alkfejl.Stocks.viewStocks.service;

import hu.elte.alkfejl.Stocks.viewStocks.model.Portfolio;
import hu.elte.alkfejl.Stocks.viewStocks.model.Transaction;
import hu.elte.alkfejl.Stocks.viewStocks.repository.PortfolioRepository;
import hu.elte.alkfejl.Stocks.viewStocks.wrapper.PortfolioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
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

    public Portfolio update(Portfolio portfolio, Transaction transaction, String ticker) {
        if(portfolio.getTransactions().remove(transaction)) {
            transaction.setTicker(ticker);
            portfolio.getTransactions().add(transaction);
        }
        return portfolioRepository.save(portfolio);
    }

    public Portfolio findById(Long portfolioId) {
        return portfolioRepository.findOne(portfolioId);
    }

    public List<PortfolioDto> getOwnedPortfolios(Long userId) {
        List<Portfolio> portfolioList = portfolioRepository.findByOwnerId(userId);
        List<PortfolioDto> portfolioDtoList = new ArrayList<>();

        for (Portfolio p : portfolioList) {
            portfolioDtoList.add(new PortfolioDto(p));
        }

        return portfolioDtoList;
    }
}
