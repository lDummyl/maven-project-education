package task8;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@NoArgsConstructor
public class Converter {

    ObjectMapper mapper = new ObjectMapper();
    // TODO: 9/23/19 не стоит создавать на каждый фаил по конвертору, лучше оставить его утильным
    private String pathFile;

    {
        mapper.findAndRegisterModules();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    public Converter(String pathFile) {
        this.pathFile = pathFile;
    }

    // TODO: 9/23/19 я бы воспользовался полиморфизмом в данном случае
    @SneakyThrows
    public List<Pair> pairFromJSON(Path pathFile) {
        String content = new String(Files.readAllBytes(pathFile));
        return pairFromJSON(content);
    }

    @SneakyThrows
    public List<Pair> pairFromJSON(String jsonBody) {
        return mapper.readValue(jsonBody, new TypeReference<List<Pair>>() {});
    }

    @SneakyThrows
    public String getStringJSON(List<Pair> pairList) {
        return mapper.writeValueAsString(pairList);
    }

    @SneakyThrows
    public void selectionReportToJSON(SelectionReport selectionReport) {
        mapper.writeValue(new File(pathFile), selectionReport);
    }

    @SneakyThrows
    public String getStringJSON(SelectionReport selectionReport) {
        return mapper.writeValueAsString(selectionReport);
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }
}
