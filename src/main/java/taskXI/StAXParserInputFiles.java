package taskXI;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public interface StAXParserInputFiles {


    default UserLogs createUserLogs(File file) {
        //извлечение данных из файлов xml с использованием xsd (посредством xerces)
        boolean timestamp = false;
        boolean userID = false;
        boolean url = false;
        boolean seconds = false;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            UserLogs userLogs = new UserLogs();
            XMLEventReader eventReader =
                    factory.createXMLEventReader(new FileReader(file));
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        if (qName.equalsIgnoreCase("log")) {
                            System.out.println("Start Element : log");
                        } else if (qName.equalsIgnoreCase("timestamp")) {
                            timestamp = true;
                        } else if (qName.equalsIgnoreCase("userID")) {
                            userID = true;
                        } else if (qName.equalsIgnoreCase("url")) {
                            url = true;
                        } else if (qName.equalsIgnoreCase("seconds")) {
                            seconds = true;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if (timestamp) {
                            userLogs.setUnixTime(Long.parseLong(characters.getData()));
                            System.out.println("timestamp: " + characters.getData());
                            timestamp = false;
                        }
                        if (userID) {
                            userLogs.setUserID(characters.getData());
                            System.out.println("userID: " + characters.getData());
                            userID = false;
                        }
                        if (url) {
                            userLogs.setUrl(characters.getData());
                            System.out.println("url: " + characters.getData());
                            url = false;
                        }
                        if (seconds) {
                            userLogs.setQtySecondsUserSpend(Integer.parseInt(characters.getData()));
                            System.out.println("seconds: " + characters.getData());
                            seconds = false;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();
                        if (endElement.getName().getLocalPart().equalsIgnoreCase("log")) {
                            System.out.println("End Element : log");
                            System.out.println();
                        }
                        break;
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
