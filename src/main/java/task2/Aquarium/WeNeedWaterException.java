package task2.Aquarium;

public class WeNeedWaterException extends Exception {

    public WeNeedWaterException() {
    }

    public WeNeedWaterException(String message) {
        super(message);
    }

    public WeNeedWaterException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeNeedWaterException(Throwable cause) {
        super(cause);
    }

    public WeNeedWaterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
