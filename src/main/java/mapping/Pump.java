package mapping;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class Pump {
    Optional<Integer> a;
    Optional<Integer> b;

    public Pump(Optional<Integer> a, Optional<Integer> b) {
        this.a = a;
        this.b = b;
    }
}
