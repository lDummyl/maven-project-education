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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
    private Duration durationSleepTime = Duration.ZERO;
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

        questionAnswer.put(Question.WHAT.name().toLowerCase(), "what you need to know");
        questionAnswer.put(Question.WHEN.name().toLowerCase(), "on time");
        questionAnswer.put(Question.WHERE.name().toLowerCase(), "somewhere");
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

        boolean giveAnswer = false;
        String question = preparedQuestions.toLowerCase().trim();
		if (!question.equals("")) {
			giveAnswer = makeDecision(question);
            if (giveAnswer && checkQuestionLength(question)) {
                reproduce(question, "", questionAnswer);
            }
		}
		return giveAnswer;
	}

	// TODO: 8/29/19 а как насчет их неравновесными сделать?
	private Boolean makeDecision(String question) {
		boolean wantToAnswer = false;
		int variant = random.nextInt(9);
		if (variant == 0) {
			reproduce(question, RUDE, systemMap);
		} else if (variant == 1) {
			reproduce(question, STICK_KICK, systemMap);
		} else if (variant == 2) {
			sleep(question);
		} else if (variant >= 3) {
			wantToAnswer = true;
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
		int sleepTime = random.nextInt(50) + 10;
        durationSleepTime = Duration.ofSeconds(sleepTime);
		timeWakeUp = LocalDateTime.now().plusSeconds(sleepTime);
		reproduce(question, SLEEP, systemMap);
        durationSleepTime = Duration.ZERO; // не уверен что это корректное решение
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
		String metacharacter = "\\b";
		if (!action.equals("")) {
			searchWord = action;
            metacharacter = "";
		}

		String answer = "";
		int countQuestions = 0;
		for (Map.Entry<String, String> entry : map.entrySet()) {
			Matcher matcher = Pattern.compile(metacharacter + entry.getKey() + metacharacter, Pattern.CASE_INSENSITIVE)
					.matcher(searchWord);
			while (matcher.find()) {
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

	private void addConversation(String question, String answer, String action) {
		Communication communication = new Communication(question, answer, action, durationSleepTime);
		historyConversation.add(communication);
	}

	@SneakyThrows
	private void createReport() {
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
		historyConversation = historyConversation.stream()
				.sorted(Comparator.comparing(Communication::getTimeCommunication))
				.collect(Collectors.toList());
	}
}
