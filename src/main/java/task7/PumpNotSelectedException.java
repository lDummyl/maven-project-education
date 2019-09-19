package task7;

import lombok.NonNull;


// TODO: 9/19/19 слишком походит на NPE. лучше переименовать
public class PumpNotSelectedException extends RuntimeException {

    public PumpNotSelectedException() {
        super();
    }

    @NonNull
    public PumpNotSelectedException(String message) {
        super(message);
    }
}
