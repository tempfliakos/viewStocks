package hu.elte.alkfejl.Stocks.viewStocks.controller;

import hu.elte.alkfejl.Stocks.viewStocks.model.Transaction;
import hu.elte.alkfejl.Stocks.viewStocks.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Transaction add(@RequestBody Transaction transaction) {
        return transactionService.add(transaction);
    }

    @RequestMapping(value = "/addMultiple", method = RequestMethod.POST)
    public List<Transaction> addAll(@RequestBody Transaction[] transactions) {
        List<Transaction> transactionList = Arrays.asList(transactions);
        return transactionService.addAll(transactionList);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody Transaction transaction) {
        transactionService.delete(transaction);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Transaction update(@RequestBody Transaction transaction) {
        return transactionService.update(transaction);
    }

    @RequestMapping(value = "/updateMultiple", method = RequestMethod.POST)
    public List<Transaction> updateAll(@RequestBody Transaction[] transactions) {
        List<Transaction> transactionList = Arrays.asList(transactions);
        return transactionService.updateAll(transactionList);
    }
}
