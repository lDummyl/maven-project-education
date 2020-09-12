package task1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private Name name;
    private BirthDate birthDate;

    @Override
    public String toString() {
        return name + ", " + birthDate;
    }

}
