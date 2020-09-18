package task3;

/*

 Создать консольное приложение: великий и могущественный оракул,
 который отвечает на вопрос исходя из ряда правил.
 Если вопрос слишком длинный, говорит будь лаконичней,
 слишком короткий - будь красноречивее
 проверяет на наличие вопроса что, где, когда, и т.д...
 если их больше одного - ты задаешь слишком много вопросов
 если ни одного, то не слышу вопроса в твоих речах
 на каждый из этих вопросов, если он один дается заготовленный мудрый ответ
 оракул может рандомно нахамить или стукнуть палкой
 может устать и сделать перерыв на 10 сек до минуты,
 сообщая тебе сколько еще ждать в ответ на вопросы.

 создать отчет о вопросах ответах виде JSON файла, используя
 Jackson Object mapper и положить его в ресурсы

Algorithm
  - create JSON list array with answers
 - Main routine
 		- read from JSON file into list array
 		- endless loop that check for input
 Upon new entry, we count question marks and full stops (regular expression)
 If counter is great than 1, then requester is verbose and asked to be more concise
 If no question marks are found, then system's response is "What's your question?"
 If counter is equal to 1, then system's response is randomly picked from JSON file:
    list array
    	sleep timer 10 sec
    	button strike

*/

public class Main {
	public static void main(String[] args) {


	}
}
