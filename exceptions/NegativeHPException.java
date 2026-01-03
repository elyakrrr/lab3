package exceptions;

public class NegativeHPException extends RuntimeException {
    public NegativeHPException(String message) {
        super(message);
    }
}