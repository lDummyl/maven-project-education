package task2;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String age;
    // TODO: 10/25/19  Переведи
    //  все твои скиллы в интерфейсы, как ты понимаешь что интерфейсы так ж могут расширять один или более интерфейсов..
    private List <Skills> skills = new ArrayList();

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void addSkils (Skills skill){
        skills.add(skill);
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public List<Skills> getSkills() {
        return skills;
    }
}
