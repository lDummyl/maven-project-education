package simpleTasks.Homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Task {
    int taskNumber;
    String taskText;
    boolean isDone;
   //перенесла отсюда коллекцию Task в ChildRoom // TODO: 4/10/20 от так лучше не делать. В яблоке еще яблоки это странно.

    public Task(int taskNumber, String taskText) {
        this.taskNumber = taskNumber;
        this.taskText = taskText;
    }


}
