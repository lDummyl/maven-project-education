package customPackage.zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    public final String name;

    public Zoo(String name) {
        this.name = name;
    }

    List<Exhibition> exhibits = new ArrayList<>();
}