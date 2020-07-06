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

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import task3.JSONProbe.Human;
import task3.JSONProbe.Place;

public class Main {
	public static void main(String[] args) throws JsonProcessingException {
//	    String str = "Разбить строку на слова";
//	    String[] word = str.split("\\s");
//        for (String s : word) {
//            System.out.println(s);
//        }

//        String inner = "Каждый охотник желает знать";
//        String innerApproved = inner.toLowerCase();
//        String goal = "каждый";
//        System.out.println(innerApproved.contains(goal));

        Place place = new Place();
        place.setName("World");

        Human human = new Human();
        human.setMessage("Hi");
        human.setPlace(place);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(human);
        System.out.println("json "+jsonString);

        //Human newHuman = mapper.readValues(jsonString, Human.class); //Не работает
        Human newHuman = JSON.parseObject(jsonString, Human.class); //Работает
        newHuman.say();

	}
}
