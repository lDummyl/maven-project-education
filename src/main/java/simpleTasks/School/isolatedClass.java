package simpleTasks.School;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class isolatedClass {
    public static void main(String[] args) {
        Map<Integer, List<Student>> allStudentsByGrade = new HashMap<>();

        Student student1 = new Student("vsd", 2);
        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        allStudentsByGrade.put(2, students);
        System.out.println("");
    }
}
