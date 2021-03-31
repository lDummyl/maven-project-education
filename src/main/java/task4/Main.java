package task4;

/*
	Создать эмулятор страждущего до ответов оракула
	чтобы его протестировать и сформировать внушительный
	отчет не менее чем на 1000 строк
*/


import com.fasterxml.jackson.databind.ObjectMapper;
import task3.Conversation;
import task3.OracleConsole;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        QuestionFactory questionFactory = new QuestionFactory();
        OracleConsole console = new OracleConsole();
        ObjectMapper objectMapper = new ObjectMapper();
        File JsonFormatFile = new File("C:\\Users\\Krugl\\IdeaProjects\\maven-project-education\\conversation.json");
        List <String> questionsList = new ArrayList<>();
        for (int i=0; i<40; i++) {
            String question = questionFactory.getQuestion();
            questionsList.add(question);
        }
        List<Conversation> list = console.getConversations(questionsList);
        objectMapper.writeValue(JsonFormatFile, list);

    }
}
