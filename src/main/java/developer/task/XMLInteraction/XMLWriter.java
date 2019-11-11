package developer.task.XMLInteraction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import developer.task.structureXML.output.Output;

import java.io.File;
import java.io.IOException;
import java.util.logging.XMLFormatter;

public class XMLWriter {

    private static ObjectMapper xmlMapper = new XmlMapper();
//    private static XMLFormatter formatter = new XMLFormatter();

    public static Boolean writeXMLWithMapper(Output output, String pathFile) {
        File file = new File(pathFile);
        try {
//            String xmlString = xmlMapper.writeValueAsString(output);
            xmlMapper.writeValue(file, output);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
