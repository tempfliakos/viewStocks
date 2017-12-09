package hu.elte.alkfejl.Stocks.viewStocks.service;

import hu.elte.alkfejl.Stocks.viewStocks.exception.PortfolioDoesNotExistException;
import hu.elte.alkfejl.Stocks.viewStocks.model.Portfolio;
import hu.elte.alkfejl.Stocks.viewStocks.model.Position;
import hu.elte.alkfejl.Stocks.viewStocks.model.Transaction;
import hu.elte.alkfejl.Stocks.viewStocks.model.TransactionType;
import hu.elte.alkfejl.Stocks.viewStocks.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Date;
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
        try {
            Portfolio portfolio = portfolioService.findById(transaction.getPortfolio().getId());
            if (portfolio == null) throw new PortfolioDoesNotExistException();
            Map<String, Position> positions = portfolio.getPositions();

            transaction.setCostBasis(transaction.getNumberOfShares() * transaction.getPricePerAmount() - transaction.getCommission());
            Position position = calculatePositionWithNewTransaction(portfolio, positions, transaction);

            positionService.add(position);
            return transactionRepository.save(transaction);
        } catch (PortfolioDoesNotExistException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Transaction> addAll(List<Transaction> transactionList) {
        try {
            Portfolio portfolio = portfolioService.findById(transactionList.get(0).getPortfolio().getId());
            if (portfolio == null) throw new PortfolioDoesNotExistException();
            Map<String, Position> positions = portfolio.getPositions();

            List<Position> newPositionList = new ArrayList<>();
            for (Transaction t : transactionList) {
                t.setCostBasis(t.getNumberOfShares() * t.getPricePerAmount() - t.getCommission());
                newPositionList.add(calculatePositionWithNewTransaction(portfolio, positions, t));
            }

            positionService.addAll(newPositionList);
            return transactionRepository.save(transactionList);
        } catch (PortfolioDoesNotExistException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void delete(Transaction transaction) {
        Portfolio portfolio = portfolioService.findById(transaction.getPortfolio().getId());
        Map<String, Position> positions = portfolio.getPositions();

        transaction.setCostBasis(transaction.getNumberOfShares() * transaction.getPricePerAmount() - transaction.getCommission());
        Position position = calculatePositionWithRemovedTransaction(positions, transaction);

        positionService.add(position);
        transactionRepository.delete(transaction);
    }

    public Transaction update(Transaction newTransaction) {
        Portfolio portfolio = portfolioService.findById(newTransaction.getPortfolio().getId());
        Map<String, Position> positions = portfolio.getPositions();

        Transaction oldTransaction = transactionRepository.findOne(newTransaction.getId());
        newTransaction.setCostBasis(newTransaction.getNumberOfShares() * newTransaction.getPricePerAmount() - newTransaction.getCommission());

        Position position = calculatePositionWithExistingTransaction(positions, oldTransaction, newTransaction);

        positionService.add(position);
        return transactionRepository.save(newTransaction);
    }

    public List<Transaction> updateAll(List<Transaction> newTransactionList) {
        Portfolio portfolio = portfolioService.findById(newTransactionList.get(0).getPortfolio().getId());
        Map<String, Position> positions = portfolio.getPositions();

        List<Position> newPositionList = new ArrayList<>();
        for (Transaction newTransaction : newTransactionList) {
            Transaction oldTransaction = transactionRepository.findOne(newTransaction.getId());
            newTransaction.setCostBasis(newTransaction.getNumberOfShares() * newTransaction.getPricePerAmount() - newTransaction.getCommission());
            newPositionList.add(calculatePositionWithExistingTransaction(positions, oldTransaction, newTransaction));
        }

        positionService.addAll(newPositionList);
        return transactionRepository.save(newTransactionList);
    }

    public List<Transaction> getPortfolioTransactions(Portfolio portfolio) {
        return transactionRepository.findByPortfolio(portfolio);
    }

    /* service helper */

    private Position calculatePositionWithNewTransaction(Portfolio portfolio, Map<String, Position> positions, Transaction transaction) {
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

    private Position calculatePositionWithRemovedTransaction(Map<String, Position> positions, Transaction transaction) {
        Position position = positionService.findById(positions.get(transaction.getTicker()).getId());

        position.setCost(position.getCost() - transaction.getCostBasis());
        position.setNumOfShares(position.getNumOfShares() - transaction.getNumberOfShares());

        return position;
    }

    private Position calculatePositionWithExistingTransaction(Map<String, Position> positions, Transaction oldTransaction, Transaction newTransaction) {
        Position position = positions.get(oldTransaction.getTicker());

        position.setCost(position.getCost() - oldTransaction.getCostBasis() + newTransaction.getCostBasis());
        position.setNumOfShares(position.getNumOfShares() - oldTransaction.getNumberOfShares() + newTransaction.getNumberOfShares());

        return position;
    }
}
