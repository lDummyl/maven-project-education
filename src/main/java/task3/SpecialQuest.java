package task3;

public class SpecialQuest {
    public static final String[] specialQuests = {"Кто", "Что", "где", "Когда", "Почему", "Зачем", "Куда", "Сколько", "Чей", "Как"};
    String specialQuest;

    public SpecialQuest(String specialQuest) {
        this.specialQuest = specialQuestCheck(specialQuest);
    }

    public SpecialQuest() {
    }

    public String getSpecialQuest() {
        return specialQuest;
    }

    public String specialQuestCheck(String quest) {
        for (String s : specialQuests) {
            if (quest.contains(s)) {
                return s;
            }
        }
        return null;
    }

}
