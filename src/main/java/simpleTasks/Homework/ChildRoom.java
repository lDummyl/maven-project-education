package simpleTasks.Homework;

import java.util.ArrayList;
import java.util.Comparator;

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
        Story story = new Story(2,"Name1", "Text1");
        Story story2 = new Story(11,"Name2", "Text2");
        Story story3 = new Story(5, "Name3", "Text3");
        StoryBook storyBook = new StoryBook();
        storyBook.listOfStories.add(story);
        storyBook.listOfStories.add(story2);
        storyBook.listOfStories.add(story3);

        String chosenStoryName = child.chooseFavoriteStory(storyBook.listOfStories);
        System.out.println("Story name: " + chosenStoryName);
        mother.readStory(chosenStoryName, storyBook.listOfStories);
        //doTaskDone(); допилить
        System.out.println("The story was told" + story.isRead);
    }

    private void timeToMakeHomework() throws Exception {

        Task task = new Task(0, "");
        Task task0 = new Task(29, "Find multiplication of two numbers: ");
        Task task1 = new Task(26, "Find xxxxxxxxxxxxxxxxxx: ");
        Task task2 = new Task(27, "Find xxxxxxxxxxxxxxxxxx: ");
        Task task3 = new Task(28, "Find xxxxxxxxxxxxxxxxxx: ");
        // TODO: 4/10/20 создай коллекцию помести задачи в нее
        //  int numberOfTask = mother.chooseTask(task); // помести коллекцию сюда и сделай выбор одной задачи, по индексу сложности например.
        ArrayList<Task> tasksCollection = new ArrayList<>();
        tasksCollection.add(task0);
        tasksCollection.add(task1);
        tasksCollection.add(task2);
        tasksCollection.add(task3);

        Task chosenTask = child.chooseMostSimpleTask(tasksCollection);
        child.writeTaskInNotebook(chosenTask);
        child.askHelp(father);
        System.out.println("Is this task done? " + chosenTask.isDone);
        child.attemptDoTask(chosenTask);
        doTaskDone(chosenTask);
        System.out.println("Is this task done now?" + chosenTask.isDone);
        child.attemptDoTask(chosenTask);
    }

    private static void doTaskDone(Task task) {
        task.isDone = true;
    }
    private static void doStoryRead(Story story) {
        story.isRead = true;
    }
}
