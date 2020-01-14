package pl.mosura.Exceptions;

public class CityNotFoundException extends RuntimeException {
    public CityNotFoundException(long id) {
        super("Not found city " + id);
    }
}
