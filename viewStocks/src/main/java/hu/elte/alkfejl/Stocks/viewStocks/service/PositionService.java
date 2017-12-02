package hu.elte.alkfejl.Stocks.viewStocks.service;

import hu.elte.alkfejl.Stocks.viewStocks.model.Portfolio;
import hu.elte.alkfejl.Stocks.viewStocks.model.Position;
import hu.elte.alkfejl.Stocks.viewStocks.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
@SessionScope
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public void add(Position position) {
        positionRepository.save(position);
    }

    public void delete(Position position) {
        positionRepository.delete(position);
    }

    public void update(Position position) {
        positionRepository.save(position);
    }

    public List<Position> getPortfolioPositions(Portfolio portfolio) {
        return positionRepository.findByPortfolio(portfolio);
    }

    public Position findById(Long positionId) {
        return positionRepository.findOne(positionId);
    }
}
