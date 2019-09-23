package task7;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class PumpNotSelectedException extends RuntimeException {

    private String message;
    private ErrorMessage errorMessage;

    public PumpNotSelectedException() {
        super();
    }

    @NonNull
    public PumpNotSelectedException(String message) {
        super(message);
        this.message = message;
    }

    public PumpNotSelectedException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
        this.message = errorMessage.getMessage();
    }
}
