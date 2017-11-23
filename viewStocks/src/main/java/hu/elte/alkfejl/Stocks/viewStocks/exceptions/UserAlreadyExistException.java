package hu.elte.alkfejl.Stocks.viewStocks.exceptions;

public class UserAlreadyExistException extends Throwable {

   public UserAlreadyExistException() {
        super();
    }

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
