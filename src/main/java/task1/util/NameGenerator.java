package task1.util;

import task1.model.Name;

import java.util.Arrays;
import java.util.List;

public class NameGenerator implements Generator<Name> {

    @Override
    public List<Name> generate() {
        return Arrays.asList(new Name("Dmitry", "Sheykin"), new Name("Alexey", "Alexeev"),
                new Name("Ivan", "Ivanov"), new Name("Sergey", "Sergeev"), new Name("Kirill", "Kirillov"),
                new Name("Vyacheslav", "Vyacheslaev"), new Name("Ignat", "Ignatov"), new Name("Semen", "Semenov"),
                new Name("Oleg", "Olegov"), new Name("Artem", "Artemov"));
    }

}