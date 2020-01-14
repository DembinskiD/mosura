package pl.mosura.Exceptions;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(long id) {
        super("Not found address " + id);
    }
}
