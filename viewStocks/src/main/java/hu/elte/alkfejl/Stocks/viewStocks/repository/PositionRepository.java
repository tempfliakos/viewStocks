package hu.elte.alkfejl.Stocks.viewStocks.repository;

import hu.elte.alkfejl.Stocks.viewStocks.model.Position;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PositionRepository extends CrudRepository<Position, Long> {
    Optional<Position> findById(Long id);
}
