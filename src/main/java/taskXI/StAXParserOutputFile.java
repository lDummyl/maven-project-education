package taskXI;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public interface StAXParserOutputFile {

    default String formatter(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        return formatter.format(date);
    }


    default void writeToFile(Map<LocalDate, List<OutgoingFile>> map) {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter(
                    new FileWriter("C:\\java\\1.xml"));
            for (Map.Entry<LocalDate, List<OutgoingFile>> entry : map.entrySet()) {
                {
                    for (List<OutgoingFile> value : map.values()) {
                        for (OutgoingFile file : value) {

                            writer.writeStartDocument();
                            writer.writeStartElement("output");
                            writer.writeStartElement("logday");
                            writer.writeStartElement("?","day", formatter(entry.getKey()));
                            writer.writeStartElement("users");
                            writer.writeStartElement("user");
                            writer.writeAttribute("id", file.userID);
                            writer.writeAttribute("url", file.url);
                            writer.writeAttribute("average", String.valueOf(file.average));
                            writer.writeEndElement();
                            writer.writeEndElement();
                            writer.writeEndElement();
                            writer.writeEndElement();
                            writer.writeEndElement();
                            writer.writeEndDocument();
                        }
                    }
                }
            }

            writer.flush();
            writer.close();

        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}