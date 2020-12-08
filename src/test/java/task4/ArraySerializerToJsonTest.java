package task4;


import org.junit.Test;
import task3.Resolution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import static org.junit.Assert.*;


public class ArraySerializerToJsonTest {

    @Test
    public void serializeCollectionToJSON() throws InterruptedException {
        OracleQuestionProvider oracleQuestionProvider = new OracleQuestionProvider();
        List<Resolution> resolutions = oracleQuestionProvider.askOracle(1000,1);

        String file = "newFileJSON";
        ArraySerializerToJson arraySerializerToJson = new ArraySerializerToJson();
        arraySerializerToJson.serializeCollectionToJSON(resolutions, file);
    }

    // TODO: 08.12.2020 Дополнил тест, что вернклся тот же объект по значению
    @Test
    public void deserializeCollectionFromJSON() throws InterruptedException {
        OracleQuestionProvider oracleQuestionProvider = new OracleQuestionProvider();
        int numberOfQuestions = 1000;
        int timeToWait = 100;
        List<Resolution> resolutions = oracleQuestionProvider.askOracle(numberOfQuestions, timeToWait);

        String file = "newFileJSON";
        ArraySerializerToJson arraySerializerToJson = new ArraySerializerToJson();
        arraySerializerToJson.serializeCollectionToJSON(resolutions, file);

        Collection<Resolution> deserialized = arraySerializerToJson.deserializeJsonArray(file, Resolution.class);
        ArrayList<Resolution> deserializedList = new ArrayList<>(deserialized);

        assertEquals(resolutions.size(), deserializedList.size());

        for (Resolution resolution : deserializedList) {
            assertNotNull(resolution);
            assertEquals(Resolution.class, resolution.getClass());
        }

        for (int i = 0; i < resolutions.size(); i++) {
            assertEquals(resolutions.get(i), deserializedList.get(i));
        }
    }
}