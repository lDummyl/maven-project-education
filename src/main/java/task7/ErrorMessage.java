package task7;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    NOT_FOUND(999001, "Sorry man cant found");

    private int index;
    private String message;

    ErrorMessage(int index, String message) {
        this.index = index;
        this.message = message;
    }
}
