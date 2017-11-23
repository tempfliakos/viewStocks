package hu.elte.alkfejl.Stocks.viewStocks.repository;

import hu.elte.alkfejl.Stocks.viewStocks.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
