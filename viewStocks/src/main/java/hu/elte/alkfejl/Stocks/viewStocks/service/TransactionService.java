package hu.elte.alkfejl.Stocks.viewStocks.service;

import hu.elte.alkfejl.Stocks.viewStocks.model.Portfolio;
import hu.elte.alkfejl.Stocks.viewStocks.model.Position;
import hu.elte.alkfejl.Stocks.viewStocks.model.Transaction;
import hu.elte.alkfejl.Stocks.viewStocks.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
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
        Portfolio portfolio = portfolioService.findById(transaction.getPortfolio().getId());
        Map<String, Position> positions = portfolio.getPositions();

        transaction.setCostBasis(
                transaction.getNumberOfShares() * transaction.getPricePerAmount() - transaction.getCommission()
        );
        Position position = createNewPosition(portfolio, positions, transaction);

        positionService.add(position);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> addAll(List<Transaction> transactionList) {
        Portfolio portfolio = portfolioService.findById(transactionList.get(0).getPortfolio().getId());
        Map<String, Position> currentPositions = portfolio.getPositions();

        List<Position> newPositionList = new ArrayList<>();
        for (Transaction t : transactionList) {
            t.setCostBasis(t.getNumberOfShares() * t.getPricePerAmount() - t.getCommission());
            newPositionList.add(createNewPosition(portfolio, currentPositions, t));
        }

        positionService.addAll(newPositionList);
        return transactionRepository.save(transactionList);
    }

    private Position createNewPosition(Portfolio portfolio, Map<String, Position> positions, Transaction transaction) {
        Position position = positions.get(transaction.getTicker());

        if (position != null) {
            position = positionService.findById(position.getId());
            position.setCost(position.getCost() + transaction.getCostBasis());
            position.setNumOfShares(position.getNumOfShares() + transaction.getNumberOfShares());
        } else {
            position = new Position();
            position.setPortfolio(portfolio);
            position.setTicker(transaction.getTicker());
            position.setNumOfShares(transaction.getNumberOfShares());
            position.setCost(transaction.getCostBasis());
        }

        return position;
    }

    public void delete(Transaction transaction) {
        transactionRepository.delete(transaction);
    }

    public Transaction update(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> updateAll(List<Transaction> transactionList) {
        return transactionRepository.save(transactionList);
    }

    public List<Transaction> getPortfolioTransactions(Portfolio portfolio) {
        return transactionRepository.findByPortfolio(portfolio);
    }
}
