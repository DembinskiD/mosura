package pl.mosura.Exceptions;

public class RpiNotFoundException extends RuntimeException {
    public RpiNotFoundException(long id) {
        super("Cannot find RPI " + id);
    }
}
