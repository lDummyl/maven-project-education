package simpleTasks.School;

public class School {

    int stateNum;
    String address;
    GrageLevel grageLevel;

    public School(GrageLevel grageLevel) {
        this.grageLevel = grageLevel;
    }

    public static void main(String[] args) {
        Director director = new Director();
        Student student1 = new Student();
        Student student2 = new Student();
        Teacher teacher1 = new Teacher();
        Teacher teacher2 = new Teacher();
        School school = new School();
        ClassRoom classroom = new ClassRoom();
        Laboratory laboratory = new Laboratory();


        school.comeToSchool(director);
        school.comeToSchool(student1);
        school.comeToSchool(student2);
        school.comeToSchool(teacher1);
        school.comeToSchool(teacher2);

        director.goToDirectorsOffice();
        student1.goToClass();
        teacher1.goToClass();
        student2.goToLaboratory();
        teacher2.goToLaboratory();

        director.doPaperWork();
        teacher1.writeSmthOnBlackBoard();
        student1.openTextBook();
        teacher2.prepareReagentsForLab();
        student2.recallTheory();

        teacher1.askQuestion(student1);
        student1.answerQuestion(teacher1);
        teacher1.praiseStudent(student1);
        student2.askQuestion(teacher2);
        teacher2.answerQuestion(student2);
        student2.sayThanks(teacher2);

        student2.playWithReagents();
        teacher2.scoldStudent(student2);  //to scold - ругать.вроде.хз
        student2.goToDirectorsOffice();
        director.scoldStudent(student2);
        student2.backToWork();
        director.backToWork();

    }

    private void comeToSchool(Person person) {
    }

    private enum GrageLevel {
        ELEMENTARY, MID, HIGH;
    }
}
