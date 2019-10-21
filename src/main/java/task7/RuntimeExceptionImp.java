package task7;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class RuntimeExceptionImp extends RuntimeException {

    private String message;
    private ErrorMessage errorMessage;

    public RuntimeExceptionImp() {
        super();
    }

    @NonNull
    public RuntimeExceptionImp(String message) {
        super(message);
        this.message = message;
    }

    public RuntimeExceptionImp(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
        this.message = errorMessage.getMessage();
    }
}
