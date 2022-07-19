package custom_exceptions;

public class InvalidDomainException extends RuntimeException {

    public InvalidDomainException(String domain) {
        super("This domain " + domain  + " is invalid. Domain must be specified as user domain or admin domain");
    }
}
