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


	public List<Communication> fromJSON() throws IOException {
//        List list = mapper.readValue(new File(pathFile), List.class);
        String content = new String(Files.readAllBytes(Paths.get(pathFile)));
        List<Communication> communicationList = mapper.readValue(content, new TypeReference<Communication[]>() {}); // TODO: 9/1/19 это мощное колдунство но иначе generic фргумент не передать

		return null; // TODO: 9/1/19 вот по этому Unchecked assignment
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

    // TODO: 9/1/19 но есть плохие нвовости у меня работает, у тебя почему-то все равно валится, нужно копать что не так, удачи!

	@SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        List<Ass> objects = new ArrayList<>();
        objects.add(new Ass("1", LocalDateTime.now()));
        objects.add(new Ass("2", LocalDateTime.now()));
        objects.add(new Ass("3", LocalDateTime.now()));
        objects.add(new Ass("4", LocalDateTime.now()));
        String s = objectMapper.writeValueAsString(objects);
        List<Ass> o = objectMapper.readValue(s, new TypeReference<List<Ass>>() { });

        Ass ass = o.get(2);
        System.out.println(ass.getTime().toString());

    }


}

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
class Ass{
    String string;
    LocalDateTime time;
}