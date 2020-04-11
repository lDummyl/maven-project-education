package simpleTasks.Homework;

public class Mother extends Person implements Checker {
    private Task chosenTask;

    public int chooseTask(Task task) {
        return task.taskNumber;
    }

    @Override
    public void checkTask(int chosenTask) {

    }

    public String readStory(String chosenStory) {
        return chosenStory + " Bla-bla-bla";
    }

}
