package simpleTasks.Homework;

public class Mother extends Person implements Checker{
    public int chooseTask(Task task) {
        return task.taskNumber;
    }
}
