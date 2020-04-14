package simpleTasks.School;

import java.util.List;
import java.util.Map;

public class Director extends Person {

    Map<Integer, List<Student>> allStudentsByGrade;

    public void doPaperWork() {
    }
    public void expelStudent(Student student) {
        for (List<Student> value : allStudentsByGrade.values()) {
            value.removeIf(student::equals);
        }
    }
}
