package taskXI;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public interface StAXParserOutputFile {

    default String formatter (LocalDate date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        return formatter.format(date);
    }


    default void writeToFile (Map <LocalDate, List<OutgoingFile>> map)
    {
        try {
            StringWriter stringWriter = new StringWriter();

            XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(stringWriter);
            for (Map.Entry<LocalDate, List<OutgoingFile>> entry : map.entrySet()) {
                {
                    for (List<OutgoingFile> value : map.values()) {
                        for (OutgoingFile file : value) {

                            xMLStreamWriter.writeStartDocument();
                            xMLStreamWriter.writeStartElement("output");
                            xMLStreamWriter.writeStartElement("logday");
                            xMLStreamWriter.writeStartElement("day", formatter(entry.getKey()));
                            xMLStreamWriter.writeStartElement("users");
                            xMLStreamWriter.writeStartElement("user");

                            xMLStreamWriter.writeAttribute("id", file.userID);
                            xMLStreamWriter.writeAttribute("url", file.url);
                            xMLStreamWriter.writeAttribute("average", String.valueOf(file.average));
                            xMLStreamWriter.writeEndElement();

                            xMLStreamWriter.writeEndElement();
                            xMLStreamWriter.writeEndElement();
                            xMLStreamWriter.writeEndDocument();
                            xMLStreamWriter.writeEndDocument();
                            xMLStreamWriter.writeEndDocument();

                            xMLStreamWriter.flush();
                            xMLStreamWriter.close();

                            String xmlString = stringWriter.getBuffer().toString();

                            stringWriter.close();

                            System.out.println(xmlString);
                        }
                    }
                }
            }
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
        }



}
