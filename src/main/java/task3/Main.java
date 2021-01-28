package task3;

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

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        Oracle oracle = new Oracle();
        QuestionReader reader = new QuestionReader();
        FileOutputStream outputStream = new FileOutputStream("D:\\test.txt");
        StringWriter writer = new StringWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        while (!reader.question.equals("exit")) {
            String answer = oracle.answer(reader.question);
            Conversation conversation = new Conversation(reader.question, answer);
            objectMapper.writeValue(writer, conversation);
        }


    }
}
