package task3;

public class Question {
    String questionText;
    SpecialQuest specialQuest;

    public Question(String questionText) {
        this.questionText = questionText;
        this.specialQuest = new SpecialQuest(questionText);
    }

}
