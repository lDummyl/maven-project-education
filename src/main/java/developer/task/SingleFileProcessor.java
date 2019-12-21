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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SingleFileProcessor implements Runnable {

    private Path pathFile;
    private String schemaFile;

    private Map<LocalDate, List<User>> outputMap;//Output output;

    public SingleFileProcessor(Path pathFile, String schemaFile, Map<LocalDate, List<User>> outputMap) {
        this.pathFile = pathFile;
        this.schemaFile = schemaFile;
        this.outputMap = outputMap;
    }


    @SneakyThrows
    @Override
    public void run() {
        if (!isFileValid(pathFile)) {
            return;
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
        LocalDateTime asyncStart = LocalDateTime.now();
        XMLParser xmlParser = new XMLParser();
        xmlParser.parseXMLWithMapper(pathFile.toFile());
        Map<LocalDate, Map<UserSite, UserIndicators>> dateUserMap = xmlParser.getVisitsMap();
//        System.out.println(Thread.currentThread().getName() + " Async millis:" + Duration.between(asyncStart, LocalDateTime.now()).toMillis());
        LocalDateTime syncStart = LocalDateTime.now();
        addAllUsers(dateUserMap);
//        System.out.println(Thread.currentThread().getName() + " Sync millis:" + Duration.between(syncStart, LocalDateTime.now()).toMillis());
    }


    @Synchronized
    private synchronized void addAllUsers(Map<LocalDate, Map<UserSite, UserIndicators>> dateUserMap) {
//        List<LogDay> logDays = outputMap.getLogDays();
        for (Map.Entry<LocalDate, Map<UserSite, UserIndicators>> entryDate : dateUserMap.entrySet()) {
//            String day = entryDate.getKey().toString();
//            List<LogDay> collect = logDays.stream().filter(i -> i.getDay().equals(day)).collect(Collectors.toList());
//            if (collect.size() > 1) {
//                throw new RuntimeException("Ambiguous date output");
//            } else {
//                if (collect.isEmpty()) {
//                    logDays.add(getCurrentLogDay(day, entryDate.getValue()));
//                } else {
//                    LogDay logDay = collect.get(0);
//                    List<User> users = logDay.getUsers();
//                    addUsers(users, entryDate.getValue());
//                }
//            }
            List<User> users = outputMap.get(entryDate.getKey());
            if (users == null) {
                outputMap.put(entryDate.getKey(), getCurrentUserList(entryDate.getValue()));
            } else {
                addUsers(users, entryDate.getValue());
            }
        }
    }

    private List<User> getCurrentUserList(Map<UserSite, UserIndicators> userValues) {
        List<User> users = new ArrayList<>();
        for (Map.Entry<UserSite, UserIndicators> entry : userValues.entrySet()) {
            UserSite userSite = entry.getKey();
            UserIndicators userIndicators = entry.getValue();
            User user = new User(userSite.user, userSite.site, userIndicators.timeSpent, userIndicators.visitQuantity);
            users.add(user);
        }

        return users;
    }

    private void addUsers(List<User> users, Map<UserSite, UserIndicators> userValues) {
        Map<UserSite, User> newUsers = new HashMap<>();
        for (User user : users) {
//            for (Map.Entry<UserSite, UserIndicators> entry : userValues.entrySet()) {
//                UserSite userSite = entry.getKey();
//                UserIndicators userIndicators = entry.getValue();
//                if (userEquals(user, userSite)) {
//                    addToUser(user, userIndicators);
//                } else {
//                    User findUser = newUsers.get(userSite);
//                    if (findUser != null) {
//                        addToUser(findUser, userIndicators);
//                    } else {
//                        newUsers.put(userSite, new User(userSite.user, userSite.site, userIndicators.timeSpent, userIndicators.visitQuantity));
//                    }
//                }
//            }
            UserSite userSite = new UserSite(user.getUserId(), user.getUrl());
            UserIndicators userIndicators = userValues.get(userSite);
            if (userIndicators != null) {
                addToUser(user, userIndicators);
                userValues.remove(userSite);
            }
        }
        for (Map.Entry<UserSite, UserIndicators> entry : userValues.entrySet()) {
            UserSite userSite = entry.getKey();
            UserIndicators userIndicators = entry.getValue();
            newUsers.put(userSite, new User(userSite.user, userSite.site, userIndicators.timeSpent, userIndicators.visitQuantity));
        }
        users.addAll(new ArrayList<>(newUsers.values()));
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
        users.add(user);
    }
}
