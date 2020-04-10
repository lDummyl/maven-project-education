package simpleTasks.Homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class Child extends Person {
    Task taskInNotebook;

    public String askHelp(Checker checker) throws Exception{
        if (checker.getClass() == Father.class){
           return "Ask mother";
        }
        if (checker.getClass() == Mother.class){
            return "Try harder. You should do your best";
        }
       throw new Exception("Don't know you mr " +  checker.getClass().getName()); // TODO: 4/10/20 делай эксепшены более информативными
    }

    public Task chooseMostSimpleTask(ArrayList<Task> tasksCollection) {   //находим миним номер задачи, потому что обычно сложность задач идет по возрастающей

        Task mostSimpleTask = tasksCollection.get(0);
        for (Task task : tasksCollection) {
            if(task.taskNumber < mostSimpleTask.taskNumber){
                mostSimpleTask = task;
            }
        }
        return mostSimpleTask;
    }

    public void writeTaskInNotebook(Task task){
        if(taskInNotebook == null){
            taskInNotebook = task;
        }
        else{
            System.out.println("We've already had " + taskInNotebook.getClass().getSimpleName() + " in the notebook");
        }
    }
}

