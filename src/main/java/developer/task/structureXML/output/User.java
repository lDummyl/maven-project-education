package developer.task.structureXML.output;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
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

    @JsonIgnore
    private LocalDate date;

    @JacksonXmlProperty(localName = "userId")
    private String userId;

    @JacksonXmlProperty(localName = "url")
    private String url;

    @JacksonXmlProperty(localName = "average")
    private Long average = 0L;

    @JsonIgnore
    private Long timeSpent;

    @JsonIgnore
    private Integer userQuantity = 1;

    public User(String userId, String url) {
        this.userId = userId;
        this.url = url;
    }

    public void calculateAverage() {
        average = timeSpent / userQuantity;
    }
    // TODO: 11/29/19 строго говоря ДТО не должен содержать логики, это довольно бурно обсуждаемый тезис,
    //  который идет вразрез с принципом инкапсуляции
    //  но будь готов что твои товарищи будут на этом настаивать.

    @Override
    public String toString() {
        return "User{" +
                "date=" + date +
                ", userId='" + userId + '\'' +
                ", url='" + url + '\'' +
                ", average=" + average + '\'' +
                ", timeSpent=" + timeSpent + '\'' +
                ", userQuantity=" + userQuantity +
                '}';
    }
}
