package simpleTasks.School;

public class Scientist extends Person{
    SchoolDiscipline schoolDiscipline;

    public Scientist(String name, SchoolDiscipline schoolDiscipline) {
        super(name);
        this.schoolDiscipline = schoolDiscipline;
    }
}
