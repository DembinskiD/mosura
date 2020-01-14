package pl.mosura.Exceptions;

public class RpiDeviceNotFoundException extends RuntimeException {

    public RpiDeviceNotFoundException(long id) {
        super("Cannot find device " + id);
    }
}
