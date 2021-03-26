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

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        OracleConsole console = new OracleConsole();
        ObjectMapper objectMapper = new ObjectMapper();
        File JsonFormatFile = new File("C:\\Users\\Krugl\\IdeaProjects\\maven-project-education\\conversation.json");
        List<Conversation> list = console.getConversationFromConsole();
            objectMapper.writeValue(JsonFormatFile, list);
    }
}

