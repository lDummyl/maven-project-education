package task1;

public class Cat {

    String name;
    int age;
    static int qtyCatsInWorld;


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

    public void sayName() {
        System.out.println(this.name);
    }
}


class Universe {


    public static void main(String[] args) {
        Cat barsik = new Cat("Barsik", 1);
        barsik.sayName();
        System.out.println(Cat.qtyCatsInWorld);
//        Cat.sayName();
        Cat.sayMeaow();

    }

}