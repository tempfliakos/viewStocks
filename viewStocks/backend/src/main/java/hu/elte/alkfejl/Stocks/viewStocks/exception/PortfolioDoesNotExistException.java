package hu.elte.alkfejl.Stocks.viewStocks.exception;

public class PortfolioDoesNotExistException extends Throwable {

    public PortfolioDoesNotExistException() {
        super();
    }

    public PortfolioDoesNotExistException(String message) {
        super(message);
    }
}
