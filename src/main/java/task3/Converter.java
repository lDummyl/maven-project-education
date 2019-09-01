package task3;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Converter {

	ObjectMapper mapper = new ObjectMapper();
	private String pathFile;

	{
		mapper.findAndRegisterModules();// TODO: 9/1/19 добавил зависимости почитай это для времени https://stackoverflow.com/questions/27952472/serialize-deserialize-java-8-java-time-with-jackson-json-mapper
	}

	public Converter(String pathFile) {
		this.pathFile = pathFile;

		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	}

	public void toJSON(List<Communication> historyConversations) throws IOException {
		mapper.writeValue(new File(pathFile), historyConversations);
	}

	// TODO: 9/2/19 не знаю успел ли поглядеть прошлый коммит, но теерь новости хорошие, все работет проблема была в том что сериализуются данные по разному до и после подключения дом модуля в маппер, я пытался старые данные десериализовать пропатченным маппером, не вышло, сериалзовал по новой, сработало.
	public List<Communication> fromJSON() throws IOException {
//        List list = mapper.readValue(new File(pathFile), List.class);// TODO: 9/1/19 вот по этому Unchecked assignment
        String content = new String(Files.readAllBytes(Paths.get(pathFile)));
        List<Communication> communicationList = mapper.readValue(content, new TypeReference<List<Communication>>() {}); // TODO: 9/1/19 это мощное колдунство но иначе generic фргумент не передать
		return communicationList;
	}

	public String getStringJSON(List<Communication> historyConversations) throws IOException {
		return mapper.writeValueAsString(historyConversations);
	}

	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}
}
