package hu.elte.alkfejl.Stocks.viewStocks.exception;

public class UserAlreadyExistException extends Throwable {

    public UserAlreadyExistException() {
        super();
    }

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
