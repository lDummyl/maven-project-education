package task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Grouper {
    public static void main(String[] args) {
        Kitten kitten = new Kitten();
        Kitten kitten1 = new Kitten();
        Kitten kitten2 = new Kitten();
        Class<?> aClass = kitten.getClass();
        HashMap<Class <?>, List> map = new HashMap<>();
        ArrayList<Object> list = new ArrayList<>();
        list.add(kitten);
        list.add(kitten1);
        list.add(kitten2);
        map.put(Kitten.class, list);
    }
}

class Kitten {

}