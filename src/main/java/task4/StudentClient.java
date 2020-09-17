package task4;

import java.io.*;
import java.net.Socket;

public class StudentClient {

    /*
    Если говорить о SRP, то студент (клиент), по идее, не должен заниматься созданием соединения с оракулом (сервером),
    и мы для этого создаем отдельный объект СтудентКлиент. Но мне совершенно непонятно, как они правильно должны взаимодействовать?
    Нужно студенту передавать объект СтудентКлиента, чтобы он отправил сообщение или СтудентКлиенту передать объект Студент
    и на нем вызвать метод генерации вопросов? Я думаю, что об этом можно поговорить на занятии. Плюс по тестированию
    методов с вероятностью и методов по отправке/приему сообщений при помощи соккетов. Так же вопрос, через соккет можно
    передавать только String (ну или вообще текст) или можно передавать объект? Это я все написал, чтобы на занятии не забыть вопросы.
     */

    private Socket studentSocket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;


    public void setUpNetworking(String address, int port) throws IOException {
        studentSocket = new Socket(address, port);
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(studentSocket.getOutputStream()));
        bufferedReader = new BufferedReader(new InputStreamReader(studentSocket.getInputStream()));
        System.out.println("Connection established...");
    }

    public void sendQuestions(){

    }




}
