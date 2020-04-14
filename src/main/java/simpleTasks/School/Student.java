package simpleTasks.School;


public class Student extends Person {

    Diary diary;
    Schoolbag schoolbag;

    public void openTextBook() {
      SchoolBook schoolbook = schoolbag.findBookForDiscipline(SchoolDiscipline.CHEMISTRY);
    }

    public void recallTheory() {
    }

    public void playWithReagents() {
    }
}
