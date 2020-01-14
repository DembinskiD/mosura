package pl.mosura.Exceptions;

public class CountyNotFoundException extends RuntimeException {
    public CountyNotFoundException(long id) {
        super("Not found county " + id);
    }
}
