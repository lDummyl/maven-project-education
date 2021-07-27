package taskXI;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public interface StAXParserInputFiles {


    default List<UserLogs> createUserLogs(File file) {
        //извлечение данных из файлов xml с использованием xsd (посредством xerces)
        List<UserLogs> list = new ArrayList<>();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            XMLEventReader eventReader =
                    factory.createXMLEventReader(new FileReader(file));
            UserLogs userLogs = new UserLogs();
            while (eventReader.hasNext()) {
                XMLEvent nextEvent = eventReader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "log":
                            userLogs = new UserLogs();
                            Attribute log = startElement.getAttributeByName(new QName("log"));
                            if (log != null) {}
                            break;
                        case "timestamp":
                            nextEvent = eventReader.nextEvent();
                            userLogs.setUnixTime(Long.parseLong(nextEvent.asCharacters().getData()));
                            break;
                        case "userId":
                            nextEvent = eventReader.nextEvent();
                            userLogs.setUserID(nextEvent.asCharacters().getData());
                            break;
                        case "url":
                            nextEvent = eventReader.nextEvent();
                            userLogs.setUrl(nextEvent.asCharacters().getData());
                            break;
                        case "seconds":
                            nextEvent = eventReader.nextEvent();
                            userLogs.setQtySecondsUserSpend(Integer.parseInt(nextEvent.asCharacters().getData()));
                            break;
                    }
                }
                if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("log")) {
                        list.add(userLogs);
                    }
                }
            }

        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
