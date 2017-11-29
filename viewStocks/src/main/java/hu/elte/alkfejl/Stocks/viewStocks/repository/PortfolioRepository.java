package hu.elte.alkfejl.Stocks.viewStocks.repository;

import hu.elte.alkfejl.Stocks.viewStocks.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findByOwnerId(Long userId);
}
