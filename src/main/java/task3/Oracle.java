package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Oracle {

	private final String GREETING = "<greeting>";
	private final String EXCEPTION = "<exception>";
	private final String SLEEP = "<sleep>";
	private final String STICK_KICK = "<stick kick>";
	private final String RUDE = "<rude>";
	private final String LONG_QUESTION = "<long question>";
	private final String SHORT_QUESTION = "<short question>";
	private final int shortQuestion = 10;
	private final int longQuestion = 20;
	private Map<String, String> systemMap = new HashMap<>();
	private Map<String, String> questionAnswer = new HashMap<>();
	private LocalDateTime timeWakeUp = LocalDateTime.of(1, Month.JANUARY, 1, 0, 0, 0);
	private Conversation conversation = new Conversation();
	private Random random = new Random();

	public Oracle() {
		systemMap.put(GREETING, "I am, great and powerful oracle, listen to you");
		systemMap.put(EXCEPTION, "I do't understand what you asked. Try again");
		systemMap.put(SLEEP, "zZz");
		systemMap.put(STICK_KICK, "Pom!");
		systemMap.put(RUDE, "oooh, stupid people, dont touch me!");
		systemMap.put(LONG_QUESTION, "Be concise");
		systemMap.put(SHORT_QUESTION, "Be more eloquent");

		questionAnswer.put("what", "what you need to know");
		questionAnswer.put("when", "on time");
		questionAnswer.put("where", "somewhere");
	}

	public void addressToOracle() {
		reproduce(GREETING, systemMap);

		InputStreamReader streamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(streamReader);

		String preparedQuestions;
		boolean isExit = false;
		while (!isExit) {
			try {
				preparedQuestions = bufferedReader.readLine();
			} catch (IOException exc) {
				preparedQuestions = "";
				reproduce(EXCEPTION, systemMap);
			}
			preparedQuestions = preparedQuestions.toLowerCase().trim();
			if (preparedQuestions.equals("e")) {
				isExit = true;
			} else {
                parsingQuestion(preparedQuestions);
			}
		}
		conversation.createReport();
	}

	public void addressToOracle(String... preparedQuestions) {
		reproduce(GREETING, systemMap);
        boolean answerIsGiven;
		for (String preparedQuestion : preparedQuestions) {
		    answerIsGiven = false;
		    while (!answerIsGiven) {
                answerIsGiven = parsingQuestion(preparedQuestion);
            }
		}
		conversation.createReport();
	}

    private Boolean parsingQuestion(String preparedQuestions) {
        if (checkSleep()) {
            return false;
        }

        String question = preparedQuestions.toLowerCase().trim();
		if (!question.equals("")) {
            boolean wantToAnswer = makeDecision() && checkQuestionLength(question);
            if (wantToAnswer) {
                reproduce(question, questionAnswer);
            }
		}
		return true;
	}

	private Boolean makeDecision() {
		boolean wantToAnswer = false;
		int variant = random.nextInt(4);
		if (variant == 0) {
			reproduce(RUDE, systemMap);
		} else if (variant == 1) {
			wantToAnswer = true;
		} else if (variant == 2) {
			reproduce(STICK_KICK, systemMap);
		} else if (variant == 3) {
			sleep();
		}
		return wantToAnswer;
	}

	private Boolean checkSleep() {
		boolean isSleep =  false;
		LocalDateTime now = LocalDateTime.now();
		if (now.isBefore(timeWakeUp)) {
			isSleep = true;
			Duration duration = Duration.between(now, timeWakeUp);
			output("left to sleep (sec): " + (duration.toMillis() / 1000));
		}
		return isSleep;
	}

	private void sleep() {
		timeWakeUp = LocalDateTime.now().plusSeconds(random.nextInt(50) + 10);
		reproduce(SLEEP, systemMap);
	}

	private Boolean checkQuestionLength(String questionFromUser) {
		String check = "";
		if (questionFromUser.length() >= longQuestion) {
			check = LONG_QUESTION;
		} else if (questionFromUser.length() <= shortQuestion) {
			check = SHORT_QUESTION;
		}
		if (!check.equals("")) {
			reproduce(check, systemMap);
			return false;
		}
		return true;
	}

	private void reproduce(String question, Map<String, String> map) {
		String answer = "";
		int countQuestions = 0;
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (question.contains(entry.getKey())) {
				answer = entry.getValue();
				countQuestions++;
			}
		}
		if (countQuestions > 1) {
			answer = "You ask too many questions";
		} else if (answer.equals("")) {
			answer = "I do't hear the question in your speeches";
		}
		conversation.addConversation(question, answer);
		output(answer);
	}

	private void output(String answer) {
		System.out.println(answer);
	}

	public String getReportString() {
		return conversation.getStringJSON();
	}
}
