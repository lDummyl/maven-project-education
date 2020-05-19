package task3;

import java.util.ArrayList;
import java.util.List;

public class Answer {

    List<String> answersWhat = new ArrayList<>();
    List<String> answersWhere = new ArrayList<>();
    List<String> answersWhen = new ArrayList<>();
    List<String> answersWherefore = new ArrayList<>();
    List<String> answersWhy = new ArrayList<>();
    List<String> answersWho = new ArrayList<>();

    // TODO: 5/19/20 любопытный подход, но имеет недостатки. Можешь попробовать блоки инициализации.
    public static void main(String[] args) {
        Answer answer = new Answer();
        List<String> answersWhat = answer.getAnswersWhat();
        System.out.println(answersWhat.size());
        List<String> answersWhat1 = answer.getAnswersWhat();
        System.out.println(answersWhat1.size());
    }

    public List<String> getAnswersWhat() {
        answersWhat.add("Что могу сказать тебе я?.... Подумай....");
        answersWhat.add("Как что? Ты разве сам не знаешь? Задавай следующий вопрос!");
        answersWhat.add("Это хороший вопрос, но ответ на него ищи сам. Оракул не должен сбивать с пути!");
        return answersWhat;
    }

    public List<String> getanswersWhere() {
        answersWhere.add("Где не сможешь найти, там и не сможешь потерять.. Подумай....");
        answersWhere.add("Где бы ты ни был, этот вопрос всегда будет тебя мучить!");
        answersWhere.add("Там, где то, что ты ищешь, и есть твои мечты");
        return answersWhere;
    }

    public List<String> getanswersWhen() {
        answersWhen.add("Когда все пройдет...");
        answersWhen.add("Такие вопросы задают, когда не разобрались в себе!");
        answersWhen.add("Когда вернутся с неба звезды...");
        return answersWhen;
    }

    public List<String> getanswersWherefore() {
        answersWherefore.add("Затем мой друг, затем!");
        answersWherefore.add("Зачем такой напор? Все скоро решится!");
        answersWherefore.add("За древностью веков таится тайна жизни!");
        return answersWherefore;
    }

    public List<String> getanswersWhy() {
        answersWhy.add("Так как ты слишком много хочешь знать...");
        answersWhy.add("А разве не этот вопрос задают себе все?");
        answersWhy.add("Потому... как много в этом слове....");
        return answersWhy;
    }

    public List<String> getanswersWho() {
        answersWho.add("Это явление сложно объяснить.... или не явление....");
        answersWho.add("Тот, кто знал больше нас!");
        answersWho.add("Верный вопрос, но не сейчас!");
        return answersWho;
    }
}
