package task3.model;

import lombok.Data;

import java.util.Random;

@Data
public class Answer {
    private final Random random = new Random();

    public void getRandomAnswer() {
        String[] answers = {"Жизнь – нелегкое занятие, а труднее всего первые сто лет",
                "Самые лучшие в мире вещи невозможно увидеть или потрогать руками. Их можно только почувствовать",
                "Жизнь – это череда маленьких шагов",
                "Тот, кто не верит в чудеса, никогда его и не получит",
                "Жизнь – это путешествие, а не дом"};
        // TODO: 9/18/20 никто не гвоорил что ответы рандомне, они как раз связаны с вопросом, может быть несоклько вариантов но вопрос как, что и тд сужает их
        System.out.println(answers[random.nextInt(5)]);
    }

    public void getShortAnswer() {
        System.out.println("Будь красноречивее...");
    }

    public void getLongAnswer() {
        System.out.println("Будь лаконичнее...");
    }

    public void getEmptyAnswer() {
        System.out.println("Не слышу вопроса в речах твоих...");
    }

    public void getManyQuestionsAnswer() {
        System.out.println("Ты задаёшь слишком много вопросов...");
    }

    public void getAngryAnswer() {
        String[] answers = {"Хватит задавать глупые вопросы!",
                "Не нашёл вопроса поумнее?",
                "Не отвлекай меня всякой ерундой!"};
        System.out.println(answers[random.nextInt(3)]);
    }
}
