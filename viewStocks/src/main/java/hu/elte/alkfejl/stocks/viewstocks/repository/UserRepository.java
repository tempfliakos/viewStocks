package hu.elte.alkfejl.Stocks.viewStocks.repository;

import hu.elte.alkfejl.Stocks.viewStocks.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
