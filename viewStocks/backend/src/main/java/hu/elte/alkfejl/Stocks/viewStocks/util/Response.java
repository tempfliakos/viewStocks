package hu.elte.alkfejl.Stocks.viewStocks.util;

public class Response<T> {

    private String error;
    private T data;

    private Response(String error, T data) {
        this.error = error;
        this.data = data;
    }

    @SuppressWarnings("unchecked")
    public static <T> Response<T> ok(T data){
        return new Response(null,data);
    }

    @SuppressWarnings("unchecked")
    public static <T> Response<T> error(String message){
        return new Response(message,null);
    }
}
