package simpleTasks.Homework;

public class ChildRoom {
    public static void main(String[] args) throws Exception {
        Child child = new Child();
        Task task = new Task(25,"Find multiplication of two numbers: ");
        Notebook notebook = new Notebook();
        Pen pen = new Pen();
        MathBook mathBook = new MathBook();
        Father father = new Father();
        Mother mother = new Mother();

        int numberOfTask = mother.chooseTask(task); // читает текст задачи и говорит номер задачи
        child.openMathBook(numberOfTask);
        child.askHelp(father);  // просит помощь от родителей, в зависимости от mother/father разные ответы

    }
}
