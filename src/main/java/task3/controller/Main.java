package task3.controller;

/*

 Создать косольное приложение: великий и могущественный оракул,
 который отвечает на вопрос исходя из ряда правил
 Если вопрос сликом длинный, говорит будь лаконичней
 слишком короткий будь красноречивее
 проверяет на наличие вопроса что, где, когда, и тд...
 если их больше одного, ты задаешь слишком много вопросов
 если ни одного, то не еслышу вопроса в твоих речах
 на каждый из этих вопросов, если он один дается заготовленный мудрый ответ
 оракул может рандомно нахамить или стукнуть палкой
 может устать и сделать перерыв на 10 сек до минуты,
 сообщая тебе сколько еще ждать в ответ на вопросы.

 создать отчет о вопросах ответах виде Josn фаила используя
 Jackson Object mapper и положить его в ресурсы

*/

public class Main {
    public static void main(String[] args) {
        QuestionUI questionUI = new QuestionUI();
        questionUI.run();
    }
}