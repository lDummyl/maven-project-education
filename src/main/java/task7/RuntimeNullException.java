package task7;

import lombok.NonNull;

public class RuntimeNullException extends RuntimeException {

    public RuntimeNullException() {
        super();
    }

    @NonNull
    public RuntimeNullException(String message) {
        super(message);
    }
}
