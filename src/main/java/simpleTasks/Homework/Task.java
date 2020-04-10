package simpleTasks.Homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Task {
    int taskNumber;
    String taskText;
    boolean isDone;
    ArrayList<Task> tasksCollection = new ArrayList<>();

    public Task(int taskNumber, String taskText) {
        this.taskNumber = taskNumber;
        this.taskText = taskText;
    }

    public void attemptDoTask(){
        int times = 5;
        if(isDone){
            times = 0;
        }
        for (int i = 0; i < times; i++) {
            System.out.println("Annoying sound of child crying");

        }
    }

}
