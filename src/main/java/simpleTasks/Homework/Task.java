package simpleTasks.Homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Task {
    int taskNumber;
    String taskText;
    boolean isDone;
    ArrayList<Task> tasksCollection = new ArrayList<>(); // TODO: 4/10/20 от так лучше не делать. В яблоке еще яблоки это странно.

    public Task(int taskNumber, String taskText) {
        this.taskNumber = taskNumber;
        this.taskText = taskText;
    }

    public void attemptDoTask(){ // TODO: 4/11/20 и это тоже странно, задача сама себя не делает. Хочешь придумать ей поведение, она может распечататься или сравнится с другой посложности, раз, два.
        int times = 5;
        if(isDone){
            times = 0;
        }
        for (int i = 0; i < times; i++) {
            System.out.println("Annoying sound of child crying");

        }
    }

}
