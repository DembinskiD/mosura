package pl.mosura.Exceptions;

public class DeviceNotFoundException extends RuntimeException {
    public DeviceNotFoundException(long id) {
        super("Cannot find device with id " + id);
    }
}
