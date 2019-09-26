package task8;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class ConverterTest {

    Logger log = Logger.getLogger(ConverterTest.class.getName());
    ObjectMapper objectMapper  = new ObjectMapper();

    // TODO: 9/23/19 кое-чего не хватет, но ты уж сам доведи до ума
    @Test
    public void pairFromJSON() throws JsonProcessingException {
        List<Pair> pairs = Arrays.asList(new Pair(1., 1.), new Pair(4., 4.));
        //String s = objectMapper.writeValueAsString(pairs);
        Converter converter = new Converter();

        String s = converter.getStringJSON(pairs);
        log.info(s);
        List<Pair> parsed = converter.pairFromJSON(s);

        assertEquals(2, parsed.size());
    }
}
