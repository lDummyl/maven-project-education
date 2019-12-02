package developer.task.structureXML.output.supportCasses;

import developer.task.structureXML.output.User;

public class UserService {

    public static void calculateAverage(User user) {
        user.setAverage(getCalculateAverage(user));
    }

    public static Long getCalculateAverage(User user) {
        return user.getTimeSpent() / user.getUserQuantity();
    }
}
