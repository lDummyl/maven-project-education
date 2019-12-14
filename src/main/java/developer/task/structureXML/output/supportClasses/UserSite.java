package developer.task.structureXML.output.supportClasses;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class UserSite {
    public String user;
    public String site;
//    public Integer visitQuantity = 1;

    public UserSite(String user, String site) {
        this.user = user;
        this.site = site;
    }
}
