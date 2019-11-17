package developer.task.XMLInteraction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import developer.task.structureXML.output.Output;

import java.io.File;
import java.io.IOException;

public class XMLWriter {

    private static final String HEAD_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
    private static ObjectMapper xmlMapper = new XmlMapper();

    public static Boolean writeXMLWithMapper(Output output, String pathFile) {
        File file = new File(pathFile);
        try {
            String xmlString = HEAD_XML + xmlMapper.writeValueAsString(output);
            xmlMapper.writeValue(file, xmlString);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
