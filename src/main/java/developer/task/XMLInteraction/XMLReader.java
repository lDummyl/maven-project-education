package developer.task.XMLInteraction;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;

import java.io.File;

public class XMLReader {

    private static XmlMapper xmlMapper = new XmlMapper();

    @SneakyThrows
    public static <T> T readXMLWithMapper(File file, Class<T> clazz) {
        T newInstance = xmlMapper.readValue(file, clazz);

        return newInstance;
    }
}
