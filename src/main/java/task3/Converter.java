package task3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class Converter {

    private String pathFile;
    ObjectMapper mapper = new ObjectMapper();

    public Converter(String pathFile) {
        this.pathFile = pathFile;

        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    public void toJSON(Set<Communication> historyConversations) throws IOException {
        mapper.writeValue(new File(pathFile), historyConversations);
    }

    public Set<Communication> fromJSON() throws IOException {
        return mapper.readValue(new File(pathFile), Set.class);
    }

    public String getStringJSON(Set<Communication> historyConversations) throws IOException {
        return mapper.writeValueAsString(historyConversations);
    }
}
