package at.bal;

public class NotizException extends Exception {
    public NotizException(String message) {
        super(message);
    }

    public NotizException(String message, Throwable cause) {
        super(message, cause);
    }
}
