package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Oracle {

	private final int shortQuestion = 10;
	private final int longQuestion = 20;
	private final String nameThreadSleep = "oracleSleep";
	private final ThreadSleep threadSleep = new ThreadSleep(nameThreadSleep);
	private Conversation conversation = new Conversation();
	private Random random = new Random();

	public Oracle() {
		//questions.add(new What());
		//questions.add(new Where());
		//questions.add(new When());
		// TODO: 8/19/19 не плохо, но я бы не стал делать классы на вопросы, достаточно словаря, но можно и так, тогда я бы вынес всеже общую логику
		// не понял на счет общей логики, что под этим подразумевается?
	}

    // TODO: 8/21/19 приходится копипастить как видишь, не смертельно, но ввод и вывод это то что должно быть отделено начисято в любоим приложении и меняться как насадки на кухонном блендере, по щелчку
	public void addressToOracle(String... preparedQuestions) {
		conversation.greeting();
		for (String preparedQuestion : preparedQuestions) {
			String question = preparedQuestion.toLowerCase().trim();
			if (question.equals("e")) {
			} else if (!question.equals("")) {
				parsingQuestion(question);
			}
		}
	}

	public void addressToOracle() {
		conversation.greeting();

		InputStreamReader streamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(streamReader);

		String question;
		boolean isExit = false; // булевы лучше называть isRunning, isDone, и тд так проще понять чем в случае с существительным
		while (!isExit) {
			try {
				question = bufferedReader.readLine();
			} catch (IOException exc) {
				question = "";
				conversation.exception();
			}

			question = question.toLowerCase().trim();
			if (question.equals("e")) {
				isExit = true;
			} else if (!question.equals("")) {
				parsingQuestion(question);
			}
		}
	}

	// TODO: 8/19/19 я бы сделал отдельный метод checkQuestionLength
	// TODO: 8/19/19 Самое важное пока ты в начале, не мешай ввод вывод и логику. Если Оракул отвечает один раз то он должен это елать в одном и только в одном месте.
	// TODO: 8/19/19 если ты заглядывал в следующие задачи, то обратил внимание, что мы будем работать с отчетами, поэтому куда важней классов Вопросов, они не обязательны, завести класс Conversation в которм, ну ты понял что будет инкапулировать он в себе.

	private void parsingQuestion(String questionFromUser) {
		boolean wantToAnswer = makeDecision() && checkQuestionLength(questionFromUser);
		if (wantToAnswer) {
			conversation.giveAnswerOnQuestion(questionFromUser);
		}
	}

	private Boolean makeDecision() {
		// еще не довел до конца
		if (!checkSleep()) {
			return false;
		}

		boolean wantToAnswer = false;
		int variant = random.nextInt(3);
		if (variant == 0) {
			sleep(); // может устать и сделать перерыв на 10 сек до минуты
		} else if (variant == 1) {
			wantToAnswer = true;
		} else if (variant == 2) {
			conversation.say("oooh, stupid people, dont touch me!"); // нахамить
		} else if (variant == 3) {
			conversation.action("stick kick"); // стукнуть палкой
		}
		return wantToAnswer;
	}

	private Boolean checkSleep() {
		// не реализовал. уперся в проблему в классе ThreadSleep
		return random.nextBoolean();
	}

	private void sleep() {
		threadSleep.start();
	}

	private Boolean checkQuestionLength(String questionFromUser) {
		String answerCheck = "";
		if (questionFromUser.length() >= longQuestion) {
			answerCheck = "Be concise";
		} else if (questionFromUser.length() <= shortQuestion) {
			answerCheck = "Be more eloquent";
		}

		if (!answerCheck.equals("")) {
			conversation.say(answerCheck);
			return false;
		}
		return true;
	}
}
