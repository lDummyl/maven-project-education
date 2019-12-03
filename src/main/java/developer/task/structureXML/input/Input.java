package developer.task.structureXML.input;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JacksonXmlRootElement(localName = "input")
public class Input {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "log")
    private List<Log> logs;
}
