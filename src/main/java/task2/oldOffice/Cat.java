package task2.oldOffice;

import org.w3c.dom.ls.LSOutput;

public class Cat extends Animal {
    String name;

    private Cat(String name,int age) {
        super(age);
        this.name = name;
    }

    public Cat() {
        super();
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Cat barsik = new Cat("Barsik", 4);
        Cat cat = new Cat();
        System.out.println(barsik);
        System.out.println(cat);
    }
}