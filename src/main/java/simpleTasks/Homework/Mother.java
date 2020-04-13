package simpleTasks.Homework;

import java.util.List;

public class Mother extends Person implements Checker {
    private Task chosenTask;

    public int chooseTask(Task task) {
        return task.taskNumber;
    }

    @Override
    public void checkTask(int chosenTask) {

    }

    public void readStory(String chosenStory, List<Story> listOfStories) {  // поиск истории в коллекции по названию
        Story storySearch = listOfStories.get(0);

        for (Story listOfStory : listOfStories) {
            if(listOfStory.storyName.equals(chosenStory)){
                System.out.println("Listen to the story... " + listOfStory.context); //содержание истории
            }
        }
    }

}
