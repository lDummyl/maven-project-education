package task1;

import java.util.ArrayList;
import java.util.Random;

public class Cat {

    private String name;
    private int age;
    public int preferredActionIndex = -1;
    static int qtyCatsInWorld;
    static ArrayList<String> listOfActions = new ArrayList<>();

    static {
        listOfActions.add("играет с мышкой");
        listOfActions.add("смотрит в окно");
        listOfActions.add("ест");
        listOfActions.add("спит");
        listOfActions.add("гуляет по балкону");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2) {
            this.name = name;
        } else {
            System.out.println("Слишком короткое имя");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Возраст не может быть отрицательным числом");
        }
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        qtyCatsInWorld++;
    }

    public static void sayMeaow() {
        for (int i = 0; i < qtyCatsInWorld; i++) {
            System.out.println("Meaow");
        }
    }

    // TODO: 5/20/20 а если все возможные действия в коллекцию предварительно при инициализации? И потом по рандому без else if?
    public void action() {
        String action;
        if (preferredActionIndex >= 0 && preferredActionIndex < listOfActions.size()){
            action = listOfActions.get(preferredActionIndex);
        }else {
            Random random = new Random();
            int x = random.nextInt(listOfActions.size());
            action = listOfActions.get(x);
        }
        System.out.println(this.name + " " + action);

    }


    public static void sleep() {
        System.out.println("Коты спят");
    }

    public void sayName() {
        System.out.println(this.name);
    }
}


class Universe {


    public static void main(String[] args) {

        Cat barsik = new Cat("Barsik", 1);
        Cat krosh = new Cat("Krosh", 4);
        Cat murka = new Cat("A", -1);

        murka.preferredActionIndex= 2;

        murka.action();
//
//        krosh.setName("K");
//        krosh.setAge(-5);
//        barsik.sayName();
//        System.out.println(krosh.getName());
//        System.out.println(krosh.getAge());
//        System.out.println(Cat.qtyCatsInWorld);
////        Cat.sayName();
//        Cat.sayMeaow();
//        krosh.action();
//        Cat.sleep();
//

    }


    public static void mainPass(Passport passport) {
        System.out.println(passport);
    }

    //dto
    private static class Passport {
        int num;
        String ser;
    }
}