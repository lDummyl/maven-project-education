package task7;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    NOT_FOUND(999001, "Sorry man cant found"),
    LIST_SIZES_MISMATCH(999002, "List sizes mismatch"),
    ZERO_VALUE(999003, "Zero value");

    private int index;
    private String message;

    ErrorMessage(int index, String message) {
        this.index = index;
        this.message = message;
    }
}
