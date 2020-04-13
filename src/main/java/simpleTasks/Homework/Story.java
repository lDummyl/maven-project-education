package simpleTasks.Homework;

public class Story {
    String storyName;
    int pagesQuantity;
    String context;
    boolean isRead;

    // TODO: 4/12/20 стоит содержание истории сделать чтобы читать его, а не блабалаб.

    public Story(int pagesQuantity,  String storyName, String context) {
        this.storyName = storyName;
        this.pagesQuantity = pagesQuantity;
        this.context = context;
    }
}
