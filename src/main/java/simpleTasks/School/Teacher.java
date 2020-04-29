package simpleTasks.School;

import java.util.List;

public class Teacher extends Person{

    final List<SchoolDiscipline> canTeach;

    public Teacher(List<SchoolDiscipline> canTeach, String name) {
        this.name = name;
        this.canTeach = canTeach;
    }

    @Override
    public void introduce(){
        System.out.println("My name is " + name + " I will teach you " + canTeach);
    }

    public void writeSmthOnBlackBoard() {
    }

    public void prepareReagentsForLab() {
    }

    public void praiseStudent(Student student1) {
    }
}
