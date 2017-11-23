package hu.elte.alkfejl.Stocks.viewStocks.repository;

import hu.elte.alkfejl.Stocks.viewStocks.model.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long> {

}
