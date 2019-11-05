package developer.task.structureXML.output;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JacksonXmlRootElement(localName = "output")
public class Output {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "logday")
    private List<LogDay> logDays = new ArrayList<>();
}
