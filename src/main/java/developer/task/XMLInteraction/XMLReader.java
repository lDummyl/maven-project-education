package developer.task.XMLInteraction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLReader {

    private static ObjectMapper xmlMapper = new XmlMapper();

    @SneakyThrows
    public static Document readXML(File file) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        return document;
    }

    @SneakyThrows
    public static <T> T readXMLWithMapper(File file, Class<T> clazz) {
        T newInstance = xmlMapper.readValue(file, clazz);

        return newInstance;
    }
}
