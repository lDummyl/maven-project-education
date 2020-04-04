package simpleTasks.Cosmetics;

import java.util.HashSet;
import java.util.Set;

public class GlamorousPerson extends Person {
    public GlamorousPerson(String name) {
        super(name);
    }

    Set<Cosmetics> allCosmetics = new HashSet<>();


    public void applyCosmetics(Cosmetics cosmetics){
        allCosmetics.add(cosmetics);
    }
}
