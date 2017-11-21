package hu.elte.alkfejl.Stocks.viewStocks.service;

import hu.elte.alkfejl.Stocks.viewStocks.model.Portfolio;
import hu.elte.alkfejl.Stocks.viewStocks.model.Position;
import hu.elte.alkfejl.Stocks.viewStocks.model.Transaction;
import hu.elte.alkfejl.Stocks.viewStocks.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;

public class PositionService {

    @Autowired
    private PositionRepository positionRepository;
    private Position position;

    public Optional<Position> add(Set<Transaction> transactions, Portfolio portfolio, String ticker, double numOfShares, double cost) {
        Optional<Position> optionalPosition = positionRepository.findById(id);   //TODO: id-t megszerezni valahonnan, mindig az utolsó id-t eltároljuk és lesz egy publikus getLastId metódus
        if(positionRepository.isPresent()) {
            position = new Position();
            position.setTransactions(transactions);
            position.setPortfolio(portfolio);
            position.setTicker(ticker);
            position.setNumOfShares(numOfShares);
            position.setCost(cost);
            positiionRepository.save(position);
            return Optional.of(position);
        }
        return Optional.empty();
    }

    public Optional<Position> delete(Set<Transaction> transactions, Portfolio portfolio, String ticker, double numOfShares, double cost) {
        positionRepository.delete(id);
    }

    public Optional<Position> update(Set<Transaction> transactions, Portfolio portfolio, String ticker, double numOfShares, double cost) {
        Optional<Position> optionalPosition = positionRepository.findById(id);
        if(positionRepository.isPresent()) {
            position = optionalPosition.get();
            position.setTransactions(transactions);
            position.setPortfolio(portfolio);
            position.setTicker(ticker);
            position.setNumOfShares(numOfShares);
            position.setCost(cost);
            positiionRepository.save(position);
            return Optional.of(position);
        }
        return Optional.empty();
    }
}
