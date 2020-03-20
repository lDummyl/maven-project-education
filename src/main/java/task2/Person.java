package task2;

public abstract class Person {
    String name;
    int age;
    String sex;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
      //  this.sex = sex;
    }

    void goToBathroom(){
        System.out.println("Good job");
    }
}
