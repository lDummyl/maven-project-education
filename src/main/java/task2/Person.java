package task2;


public class Person {
    private String name;
    private int age;
    private Gender gender;
    // TODO: 10/25/19  Переведи
    //  все твои скиллы в интерфейсы, как ты понимаешь что интерфейсы так ж могут расширять один или более интерфейсов..


    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
}
