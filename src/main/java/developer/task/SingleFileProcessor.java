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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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

    private void processData() {
        XMLParser xmlParser = new XMLParser();
        xmlParser.parseXMLWithMapper(pathFile.toFile());
        Map<UserSite, Map<LocalDate, UserIndicators>> userSiteMap = xmlParser.getUserSiteMap();
        addAllUsers(userSiteMap);
    }

    @Synchronized
    private void addAllUsers(Map<UserSite, Map<LocalDate, UserIndicators>> userSiteMap) {
        // TODO: 12/15/19 тогда будет так
        // я уже не понимаю этот механизм. мне необходимо объяснение этого функционала, либо наглядный пример
        Map<LocalDate, Map<UserSite, UserIndicators>> differentModel = new HashMap<>();
        for (Map.Entry<LocalDate, Map<UserSite, UserIndicators>> e : differentModel.entrySet()) {
            List<LogDay> currentLogDays = output.getLogDays();
            List<LogDay> collect = currentLogDays.stream().filter(i -> i.getDay().equals(e.getKey()) /*только убедись что преобразования корректыне*/).collect(Collectors.toList());
            if (collect.size() > 1) {
                throw new RuntimeException("Ambiguous date output");
            } else {
                if(collect.isEmpty()){
                    // TODO: 12/15/19 преобразуй юзеров и запиши их как новый список
//                    currentLogDays.add()
                }else {
                    LogDay logDay = collect.get(0);
                    List<User> users = logDay.getUsers();
                    // TODO: 12/15/19 добавь новые данные к ним.
//                    users.add()
                }
            }
        }

        // уникальные записи по дате, юзеру и сайту

        // пока что придумал только такие ступеньки
        // 12.15.19 при таком решении перестал проходить тест "testHighLoadValid"
//        List<LogDay> logDays = output.getLogDays();
//        for (Map.Entry<UserSite, Map<LocalDate, UserIndicators>> entry : userSiteMap.entrySet()) {
//            String userName = entry.getKey().user;
//            String userSite = entry.getKey().site;
//            for (Map.Entry<LocalDate, UserIndicators> entryDate : entry.getValue().entrySet()) {
//                String day = entryDate.getKey().toString();
//                boolean userFind = false;
//                for (LogDay logDay : logDays) {
//                    List<User> users = logDay.getUsers();
//                    boolean userDayFind = false;
//                    if (logDay.equals(day)) {
//                        for (User user : users) {
//                            if (userEquals(user, entry.getKey())) {
//                                addToUser(user, entryDate.getValue());
//                                userDayFind = true;
//                                userFind = true;
//                            }
//                        }
//                        if (!userDayFind) {
//                            addUser(users, userName, userSite, entryDate);
//                            userFind = true;
//                        }
//                    }
//                }
//                if (!userFind) {
//                    List<User> users = new ArrayList<>();
//                    addUser(users, userName, userSite, entryDate);
//                    logDays.add(new LogDay(day, users));
//                }
//            }
//        }
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

    private void addUser(List<User> users, String userName, String userSite, Map.Entry<LocalDate, UserIndicators> entryDate) {
        UserIndicators userIndicators = entryDate.getValue();
        User user = new User(entryDate.getKey(), userName, userSite, userIndicators.timeSpent);
        user.setVisitQuantity(userIndicators.visitQuantity);
        UserService.calculateAverage(user);
        users.add(user);
    }
}
