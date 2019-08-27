package task2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Settings {

    static Collection<String> manNames = Arrays.asList("Oleg", "Ivan", "Boris", "Igor", "Fedor", "Pyotr", "Sergey",
            "Kolya", "Ignat", "Yaroslav", "Vitaliy");
    static Collection<String> womenNames = Arrays.asList("Masha", "Olga", "Zina", "Tanya", "Alevtina", "Janna",
            "Mariya", "Anna", "Inna", "Valeriya", "Svetlana");
    private List<String> allNames = new ArrayList<>();
    private ArrayList<Object> labourMarket = new ArrayList<>();
    Random random = new Random();

    public Settings() {
        allNames.addAll(manNames);
        allNames.addAll(womenNames);
    }

    // хотел сделать универсальный метод для упрощения тестирования. пока не получается
    public <T extends Object> void addCandidates(Class<T> clazz, int countAdd) {
        int lastIndex = allNames.size() - 1;
        //List<T> candidates = Stream.generate(() ->
        //        clazz.getDeclaredConstructor(String.class).newInstance(allNames.get(random.nextInt(lastIndex))))
        //        .limit(countAdd)
        //        .collect(Collectors.toList());
        //labourMarket.addAll(candidates);
//        NewInstanceWithReflection object = (NewInstanceWithReflection)Class.forName("NewInstanceWithReflection").newInstance();
//        Constructor constructor = NewInstanceWithReflection.class.getDeclaredConstructor( new Class[] {String.class});
//        NewInstanceWithReflection object1 = (NewInstanceWithReflection)constructor.newInstance(new Object[]{"StackOverFlow"});
    }

    public void addSecretary(int countAdd) {
        int lastIndex = allNames.size() - 1;
        List<Secretary> candidates = Stream.generate(() -> new Secretary(allNames.get(random.nextInt(lastIndex))))
                .limit(countAdd)
                .collect(Collectors.toList());
        labourMarket.addAll(candidates);
    }

    public void addSecurityOfficer(int countAdd) {
        int lastIndex = allNames.size() - 1;
        List<SecurityOfficer> candidates = Stream.generate(() -> new SecurityOfficer(allNames.get(random.nextInt(lastIndex))))
                .limit(countAdd)
                .collect(Collectors.toList());
        labourMarket.addAll(candidates);
    }

    public void addLawyer(int countAdd) {
        int lastIndex = allNames.size() - 1;
        List<Lawyer> candidates = Stream.generate(() -> new Lawyer(allNames.get(random.nextInt(lastIndex))))
                .limit(countAdd)
                .collect(Collectors.toList());
        labourMarket.addAll(candidates);
    }

    public void addAccountant(int countAdd) {
        int lastIndex = allNames.size() - 1;
        List<Accountant> candidates = Stream.generate(() -> new Accountant(allNames.get(random.nextInt(lastIndex))))
                .limit(countAdd)
                .collect(Collectors.toList());
        labourMarket.addAll(candidates);
    }

    public void addSluggard(int countAdd) {
        int lastIndex = allNames.size() - 1;
        List<Sluggard> candidates = Stream.generate(() -> new Sluggard(allNames.get(random.nextInt(lastIndex))))
                .limit(countAdd)
                .collect(Collectors.toList());
        labourMarket.addAll(candidates);
    }

    public ArrayList<Object> getLabourMarket() {
        return labourMarket;
    }
}
