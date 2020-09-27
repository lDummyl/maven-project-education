package CollectionWork;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TreeSet;

public class Generator {
    public TreeSet<Wanderer> treePersonGenerator(int collectionSize) {
        LocalDateTime from = LocalDateTime.now();
        TreeSet<Wanderer> peopleTree = new TreeSet<>();

        while (peopleTree.size() <= collectionSize) {

            peopleTree.add(new Wanderer()); //После 22977 объекты перестали добавляться
            //System.out.println(peopleTree.size());
        }
        LocalDateTime to = LocalDateTime.now();
        Duration between = Duration.between(from, to);
        System.out.println("Время генерации дерева- "+between+" "+collectionSize);
        return peopleTree;
    }

    public ArrayList<Wanderer> arrayPersonGenerator(int collectionSize) {
        LocalDateTime from = LocalDateTime.now();
        ArrayList<Wanderer> peopleList = new ArrayList<>();

        while (peopleList.size() < collectionSize) {

            peopleList.add(new Wanderer());
            //System.out.println(peopleList.size());

        }
        LocalDateTime to = LocalDateTime.now();
        Duration between = Duration.between(from, to);
        System.out.println("Время генерации не уникального лист- "+between+" "+collectionSize);
        return peopleList;
    }

    public ArrayList<Wanderer> uniArrayPersonGenerator(int collectionSize) {
        LocalDateTime from = LocalDateTime.now();
        ArrayList<Wanderer> uniPeopleList = new ArrayList<>();
        boolean addeble = true;
        while (uniPeopleList.size() < collectionSize) {
            Wanderer wan = new Wanderer();
            for (Wanderer w : uniPeopleList) {
                if (wan.equals(w)) {
                    addeble = false;
                }
            }

            if (addeble == true) {
                uniPeopleList.add(wan);
            }
        }
        LocalDateTime to = LocalDateTime.now();
        Duration between = Duration.between(from, to);
        System.out.println("Время генерации уникального листа- "+between+" "+collectionSize);
        return uniPeopleList;
    }

}
