package pl.mosura.Exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(long id) {
        super("Cannot find rpiusers " + id);
    }
}
