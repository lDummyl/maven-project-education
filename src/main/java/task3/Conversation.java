package task3;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Conversation {

	private List<Communication> historyConversation = new ArrayList<>();
	private Converter converter = new Converter("conversation.json");

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
	public String getStringJSON() {
		sortHistoryConversation();
		return converter.getStringJSON(historyConversation);
	}

	private void sortHistoryConversation() {
		historyConversation.stream().sorted(Comparator.comparing(Communication::getTimeCommunication));
	}
}
