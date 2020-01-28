package task1;

public class Universe {
    public static void main(String[] args){
        Animal animal = new Animal();
        Cat cat = new Cat();
        Animal cat2 = new Cat();
       // Object object;

        toCall(animal);
        toCall(cat);
        toCall(cat2);

    }

    static void toCall(Object object){
     //   object.say();
        //object.toString();
        System.out.println(object.toString());
    }
}


class Animal {
    void say(){
        System.out.println("____");
    }

    @Override
    public String toString() {
        return "Animal{ }";
    }
}

class Cat extends Animal{
    void say(){
        System.out.println("Meow!");
    }

    @Override
    public String toString() {
        return "Cat{}";
    }
}
