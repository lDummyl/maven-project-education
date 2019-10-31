package task2;


public class Person {
    private String name;
    private int age;
    private boolean sex;
    // TODO: 10/25/19  Переведи
    //  все твои скиллы в интерфейсы, как ты понимаешь что интерфейсы так ж могут расширять один или более интерфейсов..


    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex.equalsIgnoreCase("female");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        if (sex){
            return "Female";
        }else {
            return "Male";
        }

    }
}
