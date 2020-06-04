package task1;

import java.util.Random;

public class Person {
    public Person(Name name, Age age) {
        this.name = name;
        this.age = age;
    }

    public Name name;
    public Age age;

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }

    public boolean isOlderThan(Person oldest) {
//		oldest 1900 this 1990
        // TODO: 5/18/20 if не нужен в таком случае сработает так return !oldest.age.year < age.year или так return oldest.age.year >= age.year

        return oldest.age.year >= age.year;
    }

    public boolean interview (Person person)
    {
        Random random = new Random();
        int x = random.nextInt(100);
        if (x > 50) {
            return true;
        }
        else
            return false;
    }

    //пыталась сделать метод Hr, который мог бы работать не только с секретарями, но и с любыми другими должностями. Компилятор ругается на несоответствие
    // классов Person и Secretary. Так сделать просто нельзя или я что-то делаю не так?

   /* public List<Person> passInterview(List <Person> people)
    {
        List <Person> list = new ArrayList<>();
        for (Person person : people) {
            if (person.interview(person))
            {
                list.add(person);
            }
            else if (!person.interview(person))
            {}
        }
        return list;
    }

    */


}
