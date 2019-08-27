package task3;

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

	public void createReport() {
		try {
			converter.toJSON(historyConversation);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public String getStringJSON() {
		try {
			return converter.getStringJSON(historyConversation);
		} catch (IOException e) {
			return e.toString();
		}
	}
}
