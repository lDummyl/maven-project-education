package developer.task;

import developer.task.XMLInteraction.XMLParser;
import developer.task.structureXML.output.LogDay;
import developer.task.structureXML.output.Output;
import developer.task.structureXML.output.User;
import developer.task.structureXML.output.supportClasses.UserService;
import developer.task.structureXML.output.supportClasses.UserSite;
import lombok.SneakyThrows;
import lombok.Synchronized;
import org.xml.sax.SAXException;
import task7.RuntimeExceptionImp;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SingleFileProcessor implements Runnable {

    private Path pathFile;
    private String schemaFile;
    private Output output = new Output();//List<User> users;

    public SingleFileProcessor(Path pathFile, String schemaFile, Output output) {
        this.pathFile = pathFile;
        this.schemaFile = schemaFile;
        this.output = output;
    }


    @SneakyThrows
    @Override
    public void run() {
        if (!isFileValid(pathFile)) {
            return;
            // TODO: 11/27/19 а ведь я в коммите  3c50fbb5cabd2183c4474046df2dc30f19227378 предупреждал что не надо так делать.
            //  Не знаю что не так с последним ассертом у меня тест дальше этого блока не идет ¯\_(ツ)_/¯ а чтобы понять это пришлось дебажить, тратить время
        }
        processData();
    }

    private Boolean isFileValid(Path pathFile) {
        URL schemaXML = SingleFileProcessor.class.getClassLoader().getResource(schemaFile);
        if (schemaXML == null) {
            return false;
        }

        Source xmlFile = new StreamSource(pathFile.toFile());
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(schemaXML);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
        } catch (SAXException e) {
            return false;
        } catch (IOException e) {
            throw new RuntimeExceptionImp("can't validate file");
        }

        return true;
    }

    private void processData() {
        XMLParser xmlParser = new XMLParser();
        xmlParser.parseXMLWithMapper(pathFile.toFile());
        addAllUsers(xmlParser.getUserSiteMap());
    }

    @Synchronized
    private void addAllUsers(Map<UserSite, Map<LocalDate, Long>> userSiteMap) {
        // уникальные записи по дате, юзеру и сайту

        // пока что придумал только такие ступеньки
        List<LogDay> logDays = output.getLogDays();
        for (Map.Entry<UserSite, Map<LocalDate, Long>> entry : userSiteMap.entrySet()) {
            String userName = entry.getKey().user;
            String userSite = entry.getKey().site;
//            Integer visitQuantity = entry.getKey().visitQuantity;
            for (Map.Entry<LocalDate, Long> entryDate : entry.getValue().entrySet()) {
                String day = entryDate.getKey().toString();
                boolean userFind = false;
                for (LogDay logDay : logDays) {
                    List<User> users = logDay.getUsers();
                    boolean userDayFind = false;
                    if (logDay.equals(day)) {
                        for (User user : users) {
                            if (userEquals(user, entry.getKey())) {
                                addToUser(user, entryDate.getValue());//, visitQuantity);
                                userDayFind = true;
                                userFind = true;
                            }
                        }
                        if (!userDayFind) {
                            users.add(new User(entryDate.getKey(), userName, userSite, entryDate.getValue()));
                            userFind = true;
                        }
                    }
                }
                if (!userFind) {
                    List<User> users = new ArrayList<>();
                    users.add(new User(entryDate.getKey(), userName, userSite, entryDate.getValue()));
                    logDays.add(new LogDay(day, users));
                }
            }
        }
    }

    private Boolean userEquals(User user, UserSite userSite) {
        return user.getUserId().equals(userSite.user)
                && user.getUrl().equals(userSite.site);
    }

    private void addToUser(User user, Long timeSpent) {//, Integer visitQuantity) {
        user.setTimeSpent(user.getTimeSpent() + timeSpent);
        user.setVisitQuantity(user.getVisitQuantity() + 1);
        UserService.calculateAverage(user);
    }
}
