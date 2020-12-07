package task4;


import org.junit.Test;
import task3.Resolution;
import java.util.Collection;
import java.util.List;


import static org.junit.Assert.*;


public class ArraySerializerToJsonTest {

    @Test
    public void serializeCollectionToJSON() throws InterruptedException {
        OracleQuestionProvider oracleQuestionProvider = new OracleQuestionProvider();
        List<Resolution> resolutions = oracleQuestionProvider.askOracle(1000);

        String file = "newFileJSON";
        ArraySerializerToJson arraySerializerToJson = new ArraySerializerToJson();
        arraySerializerToJson.serializeCollectionToJSON(resolutions, file);
    }
    @Test
    public void deserializeCollectionFromJSON() throws InterruptedException {
        OracleQuestionProvider oracleQuestionProvider = new OracleQuestionProvider();
        List<Resolution> resolutions = oracleQuestionProvider.askOracle(1000);

        String file = "newFileJSON";
        ArraySerializerToJson arraySerializerToJson = new ArraySerializerToJson();
        arraySerializerToJson.serializeCollectionToJSON(resolutions, file);

        Collection<Resolution> deserialized = arraySerializerToJson.deserializeJsonArray(file, Resolution.class);

        assertEquals(resolutions.size(), deserialized.size());

        for (Resolution resolution : deserialized) {
            assertNotNull(resolution);
            assertEquals(Resolution.class, resolution.getClass());
        }
    }
}