package taskXI;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public interface StAXParserOutputFile {

    default String formatter(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
        return formatter.format(date);
    }

    default void writeToFile(Map<LocalDate, List<OutgoingFile>> map) {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter(
                    (new FileWriter("output.xml")));
            writer.writeStartDocument("utf-8", "1.0");
            writer.writeStartElement("output");
            writer.writeStartElement("logday");

            for (Map.Entry<LocalDate, List<OutgoingFile>> entry : map.entrySet()) {
                {
                    LocalDate date = entry.getKey();
                    writer.writeStartElement("day");
                    writer.writeAttribute("day", formatter(date).toUpperCase(Locale.ROOT));
                    writer.writeEndElement();
                    writer.writeStartElement("users");
                    List<OutgoingFile> values = entry.getValue();
                    for (OutgoingFile value : values) {
                        writer.writeStartElement("user");
                        writer.writeAttribute("average", String.valueOf(value.average));
                        writer.writeAttribute("url", value.url);
                        writer.writeAttribute("id", value.userID);
                        writer.writeEndElement();
                    }
                    writer.writeEndElement();
                }
            }
            writer.writeEndElement();
            writer.writeEndDocument();

            writer.flush();
            writer.close();

        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}