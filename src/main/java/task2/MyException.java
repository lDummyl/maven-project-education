package task2;

public class MyException extends RuntimeException {
    Object expectedVal;
    Object deFactoVal;

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Object expectedVal, Object deFactoVal) {
        super(message);
        this.expectedVal = expectedVal;
        this.deFactoVal = deFactoVal;
    }
}
