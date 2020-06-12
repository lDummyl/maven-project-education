package task2.NewOffice;

public class BadWorkException extends Exception {

    public BadWorkException() {
    }

    public BadWorkException(String message) {
        super(message);
    }

    public BadWorkException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadWorkException(Throwable cause) {
        super(cause);
    }

    public BadWorkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
