package simpleTasks.School;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class Director extends Person {


    public School school;

    public void doPaperWork() {
    }
    public void expelStudent(Student student) {
        Map<Integer, List<Student>> allStudentsByGrade = school.allStudentsByGrade;
        List<Student> students = allStudentsByGrade.get(student.grade);
        students.remove(student);
    }

    public void checkStudentsMarks() {
        for (List<Student> studentsOfSomeGrade : school.allStudentsByGrade.values()) {
            for (Student student : studentsOfSomeGrade) {
                // TODO: 4/30/20 если у него плохие отметки то исключаем его из списка учащихся
            }
        }
    }

    public void acceptStudents(Student ... students) {
        //чтобы он мог зачислить студентов
        for (Student student : students) {
            if(school.allStudentsByGrade.get(student.grade) == null){
                // TODO: 4/30/20 то что?
            }else {
                // TODO: 4/30/20  то что?
            }

        }
    }
}
