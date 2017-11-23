package hu.elte.alkfejl.Stocks.viewStocks.controller;

import hu.elte.alkfejl.Stocks.viewStocks.model.Transaction;
import hu.elte.alkfejl.Stocks.viewStocks.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody Transaction transaction) {
        transactionService.add(transaction);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody Transaction transaction) {
        transactionService.delete(transaction);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(@RequestBody Transaction transaction) {
        transactionService.update(transaction);
    }
}
