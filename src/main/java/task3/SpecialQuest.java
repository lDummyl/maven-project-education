package task3;

import java.util.ArrayList;

public class SpecialQuest {
    public static final String[] specialQuests = {"Кто", "Что", "где", "Когда", "Почему", "Зачем", "Куда", "Сколько", "Чей", "Как"};
    ArrayList<String> specialQuest;

    public SpecialQuest(String specialQuest) {
        this.specialQuest = specialQuestCheck(specialQuest);
    }

    public ArrayList<String> getSpecialQuest() {
        return specialQuest;
    }

    public ArrayList<String> specialQuestCheck(String quest) {
        ArrayList<String> questions = new ArrayList<>();

        for (String s : specialQuests) {
            if (quest.contains(s)) {
                questions.add(s);
            }
        }
        return questions;
    }

}
