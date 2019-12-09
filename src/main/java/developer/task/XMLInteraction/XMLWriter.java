package developer.task.XMLInteraction;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import developer.task.structureXML.output.Output;

import java.io.File;
import java.io.IOException;

public class XMLWriter {

    private static XmlMapper xmlMapper = new XmlMapper();

    public static Boolean writeXMLWithMapper(Output output, String pathFile) {
        File file = new File(pathFile);
        try {
            xmlMapper.writeValue(file, output);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
