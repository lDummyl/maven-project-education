package task8;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Converter {

    ObjectMapper mapper = new ObjectMapper();
    private String pathFile;

    {
        mapper.findAndRegisterModules();
    }

    public Converter(String pathFile) {
        this.pathFile = pathFile;

        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    @SneakyThrows
    public List<Pair> pairFromJSON(String pathFile) {
        String content = new String(Files.readAllBytes(Paths.get(pathFile)));
        return mapper.readValue(content, new TypeReference<List<Pair>>() {});
    }

    @SneakyThrows
    public String getStringPairList(List<Pair> pairList) {
        return mapper.writeValueAsString(pairList);
    }

    @SneakyThrows
    public void selectionReportToJSON(SelectionReport selectionReport) {
        mapper.writeValue(new File(pathFile), selectionReport);
    }

    @SneakyThrows
    public String getStringSelectionReport(SelectionReport selectionReport) {
        return mapper.writeValueAsString(selectionReport);
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }
}
