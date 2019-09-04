package task3;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.logging.Logger;

public class Oracle {

	private final int pollPeriod;
	private Logger log = Logger.getLogger(Oracle.class.getName());

	public static final String GREETING = "<greeting>";
	public static final String EXCEPTION = "<exception>";
	public static final String SLEEP = "<sleep>";
	public static final String STICK_KICK = "<stick kick>";
	public static final String RUDE = "<rude>";
	public static final String LONG_QUESTION = "<long question>";
	public static final String SHORT_QUESTION = "<short question>";
	private final int shortQuestion = 10;
	private final int longQuestion = 80;
	private Map<String, String> systemMap = new HashMap<>();
	private Map<String, String> questionAnswer = new HashMap<>();
	private LocalDateTime timeWakeUp = LocalDateTime.of(1, Month.JANUARY, 1, 0, 0, 0);
	private List<Communication> historyConversation = new ArrayList<>();
	private Converter converter = new Converter("conversation.json");
	private Duration duration;
	private Random random = new Random();

	public Oracle() {
		this.pollPeriod = 3000;
		setMaps();

	}

	public Oracle(int pollPeriod, Duration duration) {
		this.pollPeriod = pollPeriod;
		this.duration = duration;
	    setMaps();
	}

	private void setMaps() {
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
		reproduce(GREETING, GREETING, systemMap);

		InputStreamReader streamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(streamReader);

		String preparedQuestions;
		boolean isExit = false;
		while (!isExit) {
			try {
				preparedQuestions = bufferedReader.readLine();
			} catch (IOException exc) {
				preparedQuestions = "";
				reproduce(EXCEPTION, EXCEPTION, systemMap);
			}
			preparedQuestions = preparedQuestions.toLowerCase().trim();
			if (preparedQuestions.equals("e")) {
				isExit = true;
			} else {
                parsingQuestion(preparedQuestions);
			}
		}
		createReport();
	}

	public void addressToOracle(String... preparedQuestions) {
		reproduce(GREETING, GREETING, systemMap);
        boolean answerIsGiven;
		for (String preparedQuestion : preparedQuestions) {
		    answerIsGiven = false;
		    while (!answerIsGiven) {
                answerIsGiven = parsingQuestion(preparedQuestion);
            }
		}
		createReport();
	}

	public void addressToOracle(List<String> preparedQuestions) {
        reproduce(GREETING, GREETING, systemMap);
        boolean answerIsGiven;
        for (String preparedQuestion : preparedQuestions) {
            answerIsGiven = false;
            while (!answerIsGiven) {
                answerIsGiven = parsingQuestion(preparedQuestion);
            }
        }
        createReport();
    }

	@SneakyThrows
    private Boolean parsingQuestion(String preparedQuestions) {
        if (checkSleep()) {
        	Thread.sleep(pollPeriod); // TODO: 8/29/19 ух на 2 гига прям у меня график оператвной памяти подскакивает, это очень хорошо что мы с этим столкнулись это надо запомнить OutOfMemoryError бывает не каждый день, и хорошо что он есть. Хоже когда ты запскаешь демона через while и фигачишь а он жрет весь перфрманс и где он проседает понять удастся не быстро. Циклические процессы только если они конечны можно пускать без таймера. Здесь не бесконечный луп, но пока мы ждем секудну проходят тонны итераций, это важно помнить.
            return false;
        }

        String question = preparedQuestions.toLowerCase().trim();
		if (!question.equals("")) {
            boolean wantToAnswer = makeDecision(question) && checkQuestionLength(question);
            if (wantToAnswer) {
                reproduce(question, "", questionAnswer);
            }
		}
		return true;
	}

	// TODO: 8/29/19 а как насчет их неравновесными сделать?
	private Boolean makeDecision(String question) {
		boolean wantToAnswer = false;
		int variant = random.nextInt(7);
		if (variant == 0) {
			reproduce(question, RUDE, systemMap);
		} else if (variant >= 1 && variant <= 4) {
			wantToAnswer = true;
		} else if (variant == 5) {
			reproduce(question, STICK_KICK, systemMap);
		} else if (variant == 6) {
			sleep(question);
		}
		return wantToAnswer;
	}

	private Boolean checkSleep() {
		boolean isSleep =  false;
		LocalDateTime now = LocalDateTime.now();
		if (now.isBefore(timeWakeUp)) {
			isSleep = true;
            Duration durationNow = Duration.between(now, timeWakeUp);
			if (duration != null && duration.getSeconds() < durationNow.getSeconds()) {
			    timeWakeUp = now.plusSeconds(duration.getSeconds());
			    output("left to sleep (sec): " + duration.getSeconds());
            } else {
                //log.info("left to sleep (sec): " + (duration.toMillis() / 1000)); // TODO: 8/29/19 да вывод один, но это не занчит что при тесторовании нельзя логиировать состояние это очень важно, так что тут играет злую шутку с тобой это правило
                output("left to sleep (sec): " + durationNow.getSeconds());
            }
		}
		return isSleep;
	}

	private void sleep(String question) {
		timeWakeUp = LocalDateTime.now().plusSeconds(random.nextInt(50) + 10);
		reproduce(question, SLEEP, systemMap);
	}

	private Boolean checkQuestionLength(String questionFromUser) {
		String check = "";
		if (questionFromUser.length() >= longQuestion) {
			check = LONG_QUESTION;
		} else if (questionFromUser.length() <= shortQuestion) {
			check = SHORT_QUESTION;
		}
		if (!check.equals("")) {
			reproduce(questionFromUser, check, systemMap);
			return false;
		}
		return true;
	}

	private void reproduce(String question, String action, Map<String, String> map) {
		String searchWord = question;
		if (!action.equals("")) {
			searchWord = action;
		}

		String answer = "";
		int countQuestions = 0;
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (searchWord.contains(entry.getKey())) {
				answer = entry.getValue();
				countQuestions++;
			}
		}
		if (countQuestions > 1) {
			answer = "You ask too many questions";
		} else if (answer.equals("")) {
			answer = "I do't hear the question in your speeches";
		}
		addConversation(question, answer, action);
		output(answer);
	}

	private void output(String answer) {
		log.info(answer);
	}

	public void addConversation(String question, String answer, String action) {
		Communication communication = new Communication(question, answer, action);
		historyConversation.add(communication);
	}

	@SneakyThrows
	public void createReport() {
		sortHistoryConversation();
		converter.toJSON(historyConversation);
	}

	@SneakyThrows
	public List<Communication> getHistoryConversation() {
		return converter.fromJSON();
	}

	@SneakyThrows
	public String getReportString() {
		sortHistoryConversation();
		return converter.getStringJSON(historyConversation);
	}

	private void sortHistoryConversation() {
		historyConversation.stream().sorted(Comparator.comparing(Communication::getTimeCommunication));
	}
}
