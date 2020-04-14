package simpleTasks.School;

import java.util.List;

public class Teacher extends Person{

    List<SchoolDiscipline> canTeach;

    public Teacher(List<SchoolDiscipline> canTeach) {
        this.canTeach = canTeach;
    }

    public void writeSmthOnBlackBoard() {
    }

    public void prepareReagentsForLab() {
    }

    public void praiseStudent(Student student1) {
    }
}
