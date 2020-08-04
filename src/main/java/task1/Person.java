package task1;

public class Person {

    Name name;
    BirthDate birthDate;

    // TODO: 8/4/20 да у каждого без исключения есть имя  и дата рождения, но человек может и не иметь скиллов их имеет работник,
    //  так что создай такой абстрактный класс
    Skills skills;

    public Person(String name, int day, int month, int year) {
        birthDate = new BirthDate(day, month, year);
        initName(name);
    }



    public Person(Name name, BirthDate birthDate, Skills skills) {
        this.name = name;
        this.birthDate = birthDate;
        this.skills = skills;
    }

    public int getSkills() {
        return skills.getLevelOfSkills();
    }

    public Person() {

    }

    private void initName(String name) {
        String[] buffer = name.split("\\s+");
        this.name = new Name(buffer[0], buffer[1]);
    }

    public boolean isOlderThan(Person person) {
        return this.birthDate.earlyThan(person.birthDate);
    }

    @Override
    public String toString() {
        return name + " " + birthDate + " skills: " + skills;
    }
}
