package developer.task;

import developer.task.XMLInteraction.XMLParser;
import developer.task.structureXML.output.LogDay;
import developer.task.structureXML.output.Output;
import developer.task.structureXML.output.User;
import developer.task.structureXML.output.supportClasses.UserIndicators;
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
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SingleFileProcessor implements Runnable {

    private Path pathFile;
    private String schemaFile;

    // TODO: 12/15/19 а вообще не плохо бы было иметь изначально Output в виде Map<LocalDate, List<User>> а потом если надо преобразовнаие
    //        тривиальное, зато в мапе не недо ничего итеративно искать стримами или циклом, просто get вызвал, или еще лучше merge который мы уже видели
    private Output output;//List<User> users;

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

    @SneakyThrows
    private void processData() {
        LocalDateTime asyncStart = LocalDateTime.now();
        XMLParser xmlParser = new XMLParser();
        xmlParser.parseXMLWithMapper(pathFile.toFile());
        Map<LocalDate, Map<UserSite, UserIndicators>> dateUserMap = xmlParser.getVisitsMap();
        System.out.println(Thread.currentThread().getName() + "Async millis:" + Duration.between(asyncStart, LocalDateTime.now()).toMillis());
        LocalDateTime syncStart = LocalDateTime.now();
        try {
            addAllUsers(dateUserMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "Sync millis:" + Duration.between(syncStart, LocalDateTime.now()).toMillis());
    }


    @Synchronized
    private void addAllUsers(Map<LocalDate, Map<UserSite, UserIndicators>> dateUserMap) {
        List<LogDay> logDays = output.getLogDays();
        for (Map.Entry<LocalDate, Map<UserSite, UserIndicators>> entryDate : dateUserMap.entrySet()) {
            String day = entryDate.getKey().toString();
            List<LogDay> collect = logDays.stream().filter(i -> i.getDay().equals(day)).collect(Collectors.toList());
            if (collect.size() > 1) {
                throw new RuntimeException("Ambiguous date output");
            } else {
                if (collect.isEmpty()) {
                    logDays.add(getCurrentLogDay(day, entryDate.getValue()));
                } else {
                    LogDay logDay = collect.get(0);
                    List<User> users = logDay.getUsers();
                    addUsers(users, entryDate.getValue());
                }
            }
        }
    }

    private LogDay getCurrentLogDay(String day, Map<UserSite, UserIndicators> userValues) {
        List<User> users = new ArrayList<>();
        for (Map.Entry<UserSite, UserIndicators> entry : userValues.entrySet()) {
            UserSite userSite = entry.getKey();
            UserIndicators userIndicators = entry.getValue();
            User user = new User(userSite.user, userSite.site, userIndicators.timeSpent, userIndicators.visitQuantity);
            users.add(user);
        }

        return new LogDay(day, users);
    }

    private void addUsers(List<User> users, Map<UserSite, UserIndicators> userValues) {
        for (User user : users) {
            for (Map.Entry<UserSite, UserIndicators> entry : userValues.entrySet()) {
                if (userEquals(user, entry.getKey())) {
                    addToUser(user, entry.getValue());
                } else {
                    UserSite userSite = entry.getKey();
                    UserIndicators userIndicators = entry.getValue();
                    addUser(users, userSite.user, userSite.site, userIndicators);
                }
            }
        }
    }

    private Boolean userEquals(User user, UserSite userSite) {
        return user.getUserId().equals(userSite.user)
                && user.getUrl().equals(userSite.site);
    }

    private void addToUser(User user, UserIndicators userIndicators) {
        user.setTimeSpent(user.getTimeSpent() + userIndicators.timeSpent);
        user.setVisitQuantity(user.getVisitQuantity() + userIndicators.visitQuantity);
        UserService.calculateAverage(user);
    }

    private void addUser(List<User> users, String userId, String url, UserIndicators userIndicators) {
        User user = new User(userId, url, userIndicators.timeSpent, userIndicators.visitQuantity);
        UserService.calculateAverage(user);
        users.add(user);
    }
}
