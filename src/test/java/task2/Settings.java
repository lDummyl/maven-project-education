package task2;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Settings {

    static Collection<String> manNames = Arrays.asList("Oleg", "Ivan", "Boris", "Igor", "Fedor", "Pyotr", "Sergey",
            "Kolya", "Ignat", "Yaroslav", "Vitaliy");
    static Collection<String> womenNames = Arrays.asList("Masha", "Olga", "Zina", "Tanya", "Alevtina", "Janna",
            "Mariya", "Anna", "Inna", "Valeriya", "Svetlana");
    Random random = new Random();
    private List<String> allNames = new ArrayList<>();
    private ArrayList<Object> labourMarket = new ArrayList<>();

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


    // TODO: 9/9/19 вот и пришла пора узнать побольше про дженерики, зачем они, хотя в данной реализации все через рефлекшн, делается полезное, но например логируем мы понимая что раз мы extends Employee то метод getName нам вполне доступен.

    public  <T extends Employee> void addEmployee(Class<T> type, int qtyToAdd) {

        int lastIndex = allNames.size() - 1;
        List<T> candidates = Stream.generate(() -> generate(type, allNames.get(random.nextInt(lastIndex))))
                .peek((i)-> System.out.println(String.format("Created %s of name: %s", i.getClass(), i.getName())))
                .limit(qtyToAdd)
                .collect(Collectors.toList());
        labourMarket.addAll(candidates);
    }

    public static void main(String[] args) {
        Settings settings = new Settings();
        settings.addEmployee(Secretary.class, 10);
        settings.addEmployee(Lawyer.class, 3);
        System.out.println(settings.labourMarket);
    }

    // TODO: 9/9/19 Вот это все очень черная магия, рефлекншн апи. Освоишь ее и вероятность того что тебе придется делать обезъянью работу будучи java разработчиком упадет почти до 0(вкупе с дженериками и ссылками на методы). Но как любая черная магия имеет свои опастности, отдельна тема в общем
    //  можно по разному сделать это, можно идти черес сеттер, но если его нет и не добавиьть(либа ридонли, например) то только так, странно что имя параметра конструктора не удалось достать точнее вместо "name" подсобывают "arg0" но я выкрутился добавис проверку через геттер. Многая магия в спринге на этом основана, так что развлекайся.

    @SneakyThrows
    private <T extends Employee> T generate(Class<T> tClass, String name) {
        for (Constructor<?> declaredConstructor : tClass.getDeclaredConstructors()) {
            if (declaredConstructor.getParameterCount() == 1) {
                Parameter parameter = declaredConstructor.getParameters()[0];
                if (parameter.getType() == String.class) {
                    T instance = (T) declaredConstructor.newInstance(name);
                    if (instance.getName().equals(name)) {
                        return instance;
                    }
                }
            }
        }
        throw new RuntimeException("Class" + tClass + "can't be created! No Constructor of kind: (String name) provided");
    }



    public ArrayList<Object> getLabourMarket() {
        return labourMarket;
    }
}
