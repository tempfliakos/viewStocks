package hu.elte.alkfejl.Stocks.viewStocks.service;

import hu.elte.alkfejl.Stocks.viewStocks.model.Transaction;
import hu.elte.alkfejl.Stocks.viewStocks.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public void add(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void delete(Transaction transaction) {
        transactionRepository.delete(transaction);
    }

    public void update(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
