package customPackage.animals;

import com.sun.xml.internal.bind.v2.TODO;

public abstract class Child {
    public final String name;
    public Gender gender;
    public boolean isAlive = true;

    public abstract Animal growUp();

    public Child(String name, Gender gender) {
        this.name = name;
        this.gender = gender;

        // TODO: Add parents, sounds, health_status
    }
}