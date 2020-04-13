package simpleTasks.Homework;

import java.util.*;

public class Child extends Person {
    Task taskInNotebook;
    Father father;
    Mother mother;

    public Child(Father father, Mother mother) {
        this.father = father;
        this.mother = mother;
    }

    public void askHelp(Checker checker){
        if (checker.getClass() == Father.class){
            System.out.println("Ask mother" );
            askHelp(mother);
//            askHelp(new Mother());
        }
        if (checker.getClass() == Mother.class){
            System.out.println("Try harder. You should do your best");
        }
       // TODO: 4/10/20 делай эксепшены более информативными
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

    public void attemptDoTask(Task task) { // TODO: 4/11/20 и это тоже странно, задача сама себя не делает. Хочешь придумать ей поведение, она может распечататься или сравнится с другой посложности, раз, два.
        int times = 5;
        if(task.isDone){
            times = -1;
            System.out.println("The task is done. Time for fairy tale");
        }
        if (!task.isDone) {
            for (int i = 0; i < times; i++) {
                System.out.println("Annoying sound of child crying");
            }
        }
    }

    public String chooseFavoriteStory(List<Story> listOfStories) {
        // TODO: 4/12/20  как то жиденько, медот говорит что мы что-то вбираем, а мы просто имя достаем. Либо выбор так же как с задачей, либо метод другое имя должен иметь.
        Story longestStory = listOfStories.get(0);
        for (Story listOfStory : listOfStories) {  // выбор самой длинной сказки
            if(listOfStory.pagesQuantity > longestStory.pagesQuantity){
                longestStory = listOfStory;
            }
        }

        return longestStory.storyName;
    }
}

