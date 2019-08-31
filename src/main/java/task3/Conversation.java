package task3;

import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Conversation {

	private Set<Communication> historyConversation = new TreeSet<>(Comparator.comparing(Communication::getTimeCommunication));
	private Converter converter = new Converter("conversation.json");

	public void addConversation(String question, String answer) {
		Communication communication = new Communication(question, answer);
		historyConversation.add(communication);
	}

	@SneakyThrows
	public void createReport() {
		converter.toJSON(historyConversation);
	}

	@SneakyThrows
	public String getStringJSON() {
		return converter.getStringJSON(historyConversation);
	}
}
