package task3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class Communication {

	private String question;
	private String answer;
	private String action;
	private Duration durationSleepTime;
	private LocalDateTime timeCommunication;

	public Communication(String question, String answer, String action, Duration durationSleepTime) {
		this.question = question;
		this.answer = answer;
		this.action = action;
		this.durationSleepTime = durationSleepTime;
		this.timeCommunication = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Communication{" +
				"question='" + question + '\'' +
				", answer='" + answer + '\'' +
				", action='" + action + '\'' +
				", durationSleepTime=" + durationSleepTime +
				", timeCommunication=" + timeCommunication +
				'}';
	}
}
