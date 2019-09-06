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
	private int sleepTime;
	private LocalDateTime timeCommunication;

	public Communication(String question, String answer, String action, int sleepTime) {
		this.question = question;
		this.answer = answer;
		this.action = action;
		this.sleepTime = sleepTime;
		this.timeCommunication = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Communication{" +
				"question='" + question + '\'' +
				", answer='" + answer + '\'' +
				", action='" + action + '\'' +
				", sleepTime=" + sleepTime +
				", timeCommunication=" + timeCommunication +
				'}';
	}
}
