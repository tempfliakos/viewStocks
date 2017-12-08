package hu.elte.alkfejl.Stocks.viewStocks.exception;

public class WrongUserAndPasswordPairException extends Throwable {

    public WrongUserAndPasswordPairException() {
        super();
    }

    public WrongUserAndPasswordPairException(String message) {
        super(message);
    }
}
