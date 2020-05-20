package task1;

import java.util.Random;

public class Cat {

    private String name;
    private int age;
    static int qtyCatsInWorld;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2) {
            this.name = name;
        }
        else
        {
            System.out.println("Слишком короткое имя");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
        else
        {
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
    public void action ()
    {
        Random random = new Random();
        int x = random.nextInt(5);
        if (x==0) {
            System.out.println(this.name + " играет с мышкой");
        }
        else if (x==1)
        {
            System.out.println(this.name + " смотрит в окно");
        }
        else if (x==2)
        {
            System.out.println(this.name + " ест");
        }
        else if (x==3)
        {
            System.out.println(this.name + " спит");
        }
        else if (x==4)
        {
            System.out.println(this.name + " гуляет по балкону");
        }
    }


    public static void sleep()
    {
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
        krosh.setName("K");
        krosh.setAge(-5);
        barsik.sayName();
        System.out.println(krosh.getName());
        System.out.println(krosh.getAge());
        System.out.println(Cat.qtyCatsInWorld);
//        Cat.sayName();
        Cat.sayMeaow();
        krosh.action();
        Cat.sleep();


    }

}