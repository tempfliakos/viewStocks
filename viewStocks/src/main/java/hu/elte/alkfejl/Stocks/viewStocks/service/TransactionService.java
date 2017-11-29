package hu.elte.alkfejl.Stocks.viewStocks.service;

import hu.elte.alkfejl.Stocks.viewStocks.model.Portfolio;
import hu.elte.alkfejl.Stocks.viewStocks.model.Position;
import hu.elte.alkfejl.Stocks.viewStocks.model.Transaction;
import hu.elte.alkfejl.Stocks.viewStocks.repository.PortfolioRepository;
import hu.elte.alkfejl.Stocks.viewStocks.repository.PositionRepository;
import hu.elte.alkfejl.Stocks.viewStocks.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Map;

@Service
@SessionScope
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private PositionService positionService;

    public Transaction add(Transaction transaction) {
        Portfolio portfolio = portfolioService.getById(transaction.getPortfolio().getId());
        Map<String, Position> positions = portfolio.getPositions();
        Position position = positions.get(transaction.getTicker());

        if(position != null){
            position.setCost(position.getCost() + transaction.getCostBasis());
            position.setNumOfShares(position.getNumOfShares() + transaction.getNumberOfShares());
        } else {
            position = new Position();
            position.setPortfolio(portfolio);
            position.setTicker(transaction.getTicker());
            position.setNumOfShares(transaction.getNumberOfShares());
            position.setCost(transaction.getCostBasis());
        }

        positionService.add(position);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> addAll(List<Transaction> transactionList){
        return transactionRepository.save(transactionList);
    }

    public void delete(Transaction transaction) {
        transactionRepository.delete(transaction);
    }

    public Transaction update(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> updateAll(List<Transaction> transactionList){
        return transactionRepository.save(transactionList);
    }

    public List<Transaction> getPortfolioTransactions(Portfolio portfolio){
        return transactionRepository.findByPortfolio(portfolio);
    }
}
