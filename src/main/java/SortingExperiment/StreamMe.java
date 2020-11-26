package SortingExperiment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMe {


    /*public static void main(String[] args) {
        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Barsik"));
        cats.add(new Cat("Murzik"));
        List<String> catNames = cats.stream().map(Cat::getName).collect(Collectors.toList());
        System.out.println(cats);
        System.out.println(catNames);
    }*/
}

@Data
@AllArgsConstructor
class Cat{
    String name;
}