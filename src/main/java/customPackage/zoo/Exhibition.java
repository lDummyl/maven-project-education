package customPackage.zoo;

import customPackage.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class Exhibition {
    public final String name;

    List<Animal> animals = new ArrayList<>();

    public Exhibition(String name) {
        this.name = name;
    }
}