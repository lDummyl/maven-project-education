package task3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Converter {

    private String pathFile;
    ObjectMapper mapper = new ObjectMapper();

    public Converter(String pathFile) {
        this.pathFile = pathFile;

        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    public void toJSON(List<Communication> historyConversations) throws IOException {
        mapper.writeValue(new File(pathFile), historyConversations);
    }

    public List<Communication> fromJSON() throws IOException {
        return mapper.readValue(new File(pathFile), List.class);
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
