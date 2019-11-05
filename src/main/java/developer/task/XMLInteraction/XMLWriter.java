package developer.task.XMLInteraction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import developer.task.structureXML.output.Output;
import lombok.SneakyThrows;

import java.io.File;

public class XMLWriter {

    private static ObjectMapper xmlMapper = new XmlMapper();

    @SneakyThrows
    public static Boolean writeXMLWithMapper(Output output, String pathFile) {
        File file = new File(pathFile);
        xmlMapper.writeValue(file, output);

        return true;
    }
}
