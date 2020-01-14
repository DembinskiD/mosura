package pl.mosura.Exceptions;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(long id) {
        super("Not found country " + id);
    }
}
