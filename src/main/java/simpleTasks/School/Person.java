package simpleTasks.School;

public abstract class Person {
    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
    // TODO: 4/15/20 поля, поля где?

    public void goToDirectorsOffice() {
    }

    public void goToClass(){};

    public void goToLaboratory() {
    }

    public void askQuestion(Person person) {
    }

    public void askQuestion() { // если вопрос адресован не конкретному человеку
    }
    
    public void answerQuestion(Person person) {
    }

    public void sayThanks(Person person) {
    }

    public void scoldStudent(Student student2) {
    }

    public void backToWork() {
    }

    public void introduce(){
        System.out.println("My name is" + name);
    }
}
