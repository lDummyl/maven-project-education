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
	private int sleepTime; // TODO: 9/6/19 лучше не хранить продолжительность в инте всегда, если это возможно. Так что лучше снова Duration, а сравниваться они прекрасно могут через compareTo. В Jackson модуль для 8й джавы уже подключен так что проблем быть не должно.

	private LocalDateTime timeCommunication;


	public static void main(String[] args) {

		Duration fiveSec =  Duration.ofSeconds(5);
		Duration oneMin =  Duration.ofMinutes(1);
		Duration week = Duration.ofDays(7);

		if(fiveSec.compareTo(oneMin)<0){
			System.out.println("hit!");
		}

		if(week.compareTo(oneMin)>0){
			System.out.println("hit!");
		}



	}

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
