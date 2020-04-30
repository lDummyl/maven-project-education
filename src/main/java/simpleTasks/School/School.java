package simpleTasks.School;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class School {

    int stateNum;
    String address;
    GrageLevel grageLevel;
    List<Teacher> teacherList;
    List<ClassRoom> classRooms = new ArrayList<>();
    Map<Integer, List<Student>> allStudentsByGrade = new HashMap<>();

    private Director director;

    public School(GrageLevel grageLevel) {
        this.grageLevel = grageLevel;
    }

    public static void main(String[] args) {

        School school11 = new School(GrageLevel.MID);
        School school2 = new School(GrageLevel.ELEMENTARY);
        school11.stateNum = 11;
        school11.address = "Street Petrovka, 2";
        school2.stateNum = 2;
        school2.address = "Street Razumovka, 10";

        List<SchoolDiscipline> listDiscipl = new ArrayList<>();
        listDiscipl.add(SchoolDiscipline.LANGUAGE);
        listDiscipl.add(SchoolDiscipline.CHEMISTRY);

        Director director = new Director();
        Student student1 = new Student("Petya", 2);
        Student student2 = new Student("Styopa",2);
        Student student3 = new Student("Kolja", 2);
        Student student4 = new Student("Fedya", 2);

        director.acceptStudents(student1, student2, student3, student4);

        Teacher teacher1 = new Teacher(Arrays.asList(SchoolDiscipline.LANGUAGE, SchoolDiscipline.BIOLOGY), "Maria Petrovna");
        teacher1.favourite.add(student4);
        teacher1.favourite.add(student3);
        Teacher teacher2 = new Teacher(Arrays.asList(SchoolDiscipline.CHEMISTRY, SchoolDiscipline.PHYSICS), "Anna Olegovna");
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacher1);
        teacherList.add(teacher2);
        school11.teacherList = teacherList;
        school11.director = director;
//        кроме этого мы сообщаем и директору и учителю в какой школе они трудятся
        director.school = school11;
        teacher1.school = school11;


        List<FaimousScientistPortrait> portretsOnWalls = new ArrayList<>();
        portretsOnWalls.add(new FaimousScientistPortrait(new Scientist("Pavlov", SchoolDiscipline.BIOLOGY)));
        ClassRoom classroom = new ClassRoom(portretsOnWalls, (short) 15);
        school11.classRooms.add(classroom);

        school11.startSchoolDay();
        school11.director.checkStudentsMarks();
//        Laboratory laboratory = new Laboratory();


//        school11.comeToSchool(director);
//        school11.comeToSchool(student1);
//        school11.comeToSchool(student2);
//        school11.comeToSchool(teacher1);
//        school11.comeToSchool(teacher2);

        director.goToDirectorsOffice();
        student1.goToClass();
        teacher1.goToClass();
        student2.goToLaboratory();
        //      teacher2.goToLaboratory();

        director.doPaperWork();
        // teacher1.writeSmthOnBlackBoard();
        student1.openTextBook();
        // teacher2.prepareReagentsForLab();
        student2.recallTheory();

        // teacher1.askQuestion(student1);
        // student1.answerQuestion(teacher1);
        // teacher1.praiseStudent(student1);
        //     student2.askQuestion(teacher2);
        //     teacher2.answerQuestion(student2);
        //     student2.sayThanks(teacher2);
//
        //     student2.playWithReagents();
        //     teacher2.scoldStudent(student2);  //to scold - ругать.вроде.хз
        //     student2.goToDirectorsOffice();
        //     director.scoldStudent(student2);
        //     student2.backToWork();
        //     director.backToWork();
//
    }


    private void startSchoolDay() {
        SchoolDiscipline schoolDiscipline = SchoolDiscipline.BIOLOGY;
        Teacher teacher1 = null;
        ClassRoom classRoom1 = null;

        for (Teacher teacher : teacherList) {
            teacher.introduce();
        }
        for (Teacher teacher : teacherList) {
            if (teacher.canTeach.contains(schoolDiscipline)) {
                teacher1 = teacher;
            }
        }
        for (ClassRoom classRoom : classRooms) {
            for (FaimousScientistPortrait portrait : classRoom.portretsOnWalls) {
                if (portrait.scientist.schoolDiscipline.equals(schoolDiscipline)) {
                    classRoom1 = classRoom;
                }
                ;
            }
        }
        startLesson(teacher1, schoolDiscipline, classRoom1, 2);
    }

    private void startLesson(Teacher teacher, SchoolDiscipline schoolDiscipline, ClassRoom classRoom, int grade) {
        teacher.introduce();
        System.out.println(" Today we will study " + schoolDiscipline);
        System.out.println(classRoom.roomNumber);
        System.out.println("teacher doing lesson");
        List<Student> students = teacher.school.allStudentsByGrade.get(grade);
        for (Student student : students) {
            if (teacher.favourite.contains(student)){
                // TODO: 4/30/20 значит в журнал получает 5 ку
            }else{
                // TODO: 4/30/20 получает другую оценку
            }
        }

    }


    private void comeToSchool(Person person) {
    }

    private enum GrageLevel {
        ELEMENTARY, MID, HIGH;
    }
}
