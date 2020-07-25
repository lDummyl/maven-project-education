package task3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class GreatOracleTest {
    GreatOracle greatOracle = new GreatOracle(10, 50, 1);
    GreatOracle greatOracle2 = new GreatOracle(10, 50, 2);

    @Test
    public void learning(){
        greatOracle.learning(Academy.learnOracle1(11));
        assertEquals("Погугли.", greatOracle.wisdom.get("что"));
    }

    @Test
    public void questionLengthMeasurement(){
        String validLength = "строка нужной длины";
        assertEquals("строка нужной длины", greatOracle.validLengthQuestion(validLength));
    }

    @Test
    public void getAnswerNotQuestion() {
        greatOracle.learning(Academy.learnOracle1(11));
        String s = "отсутствие вопроса в строке";
        List<String> answer1 = new ArrayList<>();
        answer1.add("Не слышу вопроса в твоих речах.");
        assertEquals(answer1, greatOracle.getAnswer(s));
    }

    @Test
    public void getAnswerOverQuestion() {
        greatOracle.learning(Academy.learnOracle1(11));
        String ss = "!!как!,почему зачем,,,";
        List<String> answer2 = new ArrayList<>();
        answer2.add("Ты задаешь слишком много вопросов.");
        assertEquals(answer2, greatOracle.getAnswer(ss));
    }

    @Test
    public void getAnswerOneQuestion(){
        greatOracle.learning(Academy.learnOracle1(11));
        String sss = "что";
        List<String> answer3 = new ArrayList<>();
        answer3.add("Погугли.");
        assertEquals(answer3, greatOracle.getAnswer(sss));
    }

    @Test
    public void getAnswerTwoQuestion(){
        greatOracle2.learning(Academy.learnOracle1(11));
        String s = "что когда";
        List<String> answer = new ArrayList<>();
        answer.add("Погугли.");
        answer.add("После дождечка в четверг.");
        assertEquals(answer, greatOracle2.getAnswer(s));
    }
    // TODO: 7/25/20 вот теперь как проверить удар палкой и время ожидания. Вопрос не праздный,
    //  например, ты пишель сервис авторизации, задача забанить на 10 минут при переборе попыток,
    //  дальше нужно протетстировать что по прошествии 10 минут бан снят, что в течение 10 минут он не снят.
    //  Что он не продлевается от новых попыток. Вот 3 сценария, которые очень помогвют
    //  выстараивать этот функционал через TDD. Тут по-проще, но с чего то надо начинать. Насчет вероятности
    //  всегда помни вероятность смерти человека в следующие 20 секунд ~0% в следующие 200 лет ~100%.

}