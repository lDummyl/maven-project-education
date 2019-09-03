package task3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class Communication {

	private String question;
	private String answer;
	private String action;
	private LocalDateTime timeCommunication;

	public Communication(String question, String answer, String action) {
		this.question = question;
		this.answer = answer;
		this.action = action;
		this.timeCommunication = LocalDateTime.now();
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

	public String getAction() {
		return action;
	}

	public LocalDateTime getTimeCommunication() {
		return timeCommunication;
	}

	@Override
	public String toString() {
		return "Communication{" +
				"question='" + question + '\'' +
				", answer='" + answer + '\'' +
				", action='" + action + '\'' +
				", timeCommunication=" + timeCommunication +
				'}';
	}
}
