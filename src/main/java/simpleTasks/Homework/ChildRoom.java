package simpleTasks.Homework;

import java.util.HashSet;
import java.util.Set;

public class ChildRoom {
    private final Child child;
    private final Mother mother;
    private final Father father;

    public ChildRoom(Child child, Mother mother, Father father) {
        this.child = child;
        this.mother = mother;
        this.father = father;
    }


    // TODO: 4/10/20 помни коментарии это хорошо, но хороший коментарий отвечает на вопрос почему, а не что.
    public static void main(String[] args) throws Exception {
        Child child = new Child();
        Father father = new Father();
        Mother mother = new Mother();
        ChildRoom childRoom = new ChildRoom(child, mother, father);
        childRoom.timeToMakeHomework();
        childRoom.timeForFairyTale();
        childRoom.timeToSleep();
    }

    private void timeToSleep() {

    }

    private void timeForFairyTale() {

    }

    private void timeToMakeHomework() throws Exception {

        Task task = new Task(0, "");
        Task task0 = new Task(29,"Find multiplication of two numbers: ");
        Task task1 = new Task(26,"Find xxxxxxxxxxxxxxxxxx: ");
        Task task2 = new Task(27,"Find xxxxxxxxxxxxxxxxxx: ");
        Task task3 = new Task(28,"Find xxxxxxxxxxxxxxxxxx: ");
        // TODO: 4/10/20 создай коллекцию помести задачи в нее
      //  int numberOfTask = mother.chooseTask(task); // помести коллекцию сюда и сделай выбор одной задачи, по индексу сложности например.
        task.tasksCollection.add(task0);
        task.tasksCollection.add(task1);
        task.tasksCollection.add(task2);
        task.tasksCollection.add(task3);

        Task chosenTask = child.chooseMostSimpleTask(task.tasksCollection);
        child.writeTaskInNotebook(chosenTask);
        child.askHelp(father);
        System.out.println("Is this task done? " + task.isDone);
        task.attemptDoTask();
       // mother.checkTask();

    }


}
