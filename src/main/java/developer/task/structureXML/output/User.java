package developer.task.structureXML.output;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import developer.task.structureXML.output.supportClasses.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JacksonXmlRootElement(localName = "user")
public class User {

    @JacksonXmlProperty(localName = "userId")
    private String userId;

    @JacksonXmlProperty(localName = "url")
    private String url;

    @JacksonXmlProperty(localName = "average")
    private Long average = 0L;

    @JsonIgnore
    private Long timeSpent;

    @JsonIgnore
    private Integer visitQuantity = 1;

    public User(String userId, String url, Long timeSpent, Integer visitQuantity) {
        this.userId = userId;
        this.url = url;
        this.timeSpent = timeSpent;
        this.visitQuantity = visitQuantity;

        UserService.calculateAverage(this);
    }

    @Override
    public String toString() {
        return "User{" +
                ", userId='" + userId + '\'' +
                ", url='" + url + '\'' +
                ", average=" + average + '\'' +
                ", timeSpent=" + timeSpent + '\'' +
                ", userQuantity=" + visitQuantity +
                '}';
    }
}
