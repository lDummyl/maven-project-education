package task2;

public abstract class Person {
    String name;
    int age;

    //  String sex;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
      //  this.sex = sex;
    }

    public abstract void tellWhatYouDoForALiving();

    void goToBathroom() {
        System.out.println("Good job");
    }

  //  public String getName() {
  //      return name;
  //  }
//
  //  public void setName(String name) {
  //      this.name = name;
  //  }
//
  //  public int getAge() {
  //      return age;
  //  }
//
  //  public void setAge(int age) {
  //      this.age = age;
  //  }
}
