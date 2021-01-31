package task1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AdultPerson extends Person{
    public AdultPerson(String name, BirthDate localBirthDate) {
        super(name, localBirthDate);
    }

    public AdultPerson(Name name, BirthDate birthDate) {
        super(name, birthDate);
    }

}
