package task4;

import org.junit.Test;
import task3.Resolution;

import java.util.List;


public class SerializerForAnyTest {

    @Test
    public void serializeCollectionToJSON() {
        OracleQuestionProvider oracleQuestionProvider = new OracleQuestionProvider();
        List<Resolution> resolutions = oracleQuestionProvider.askOracle(1000);

        String file = "newFileJSON";
        SerializerForAny serializerForAny = new SerializerForAny();
        serializerForAny.serializeCollectionToJSON(resolutions, file);
    }
    @Test
    public void serializeCollectionToJSONandDeserialize() {
        OracleQuestionProvider oracleQuestionProvider = new OracleQuestionProvider();
        List<Resolution> resolutions = oracleQuestionProvider.askOracle(1000);

        String file = "newFileJSON";
        SerializerForAny serializerForAny = new SerializerForAny();
        serializerForAny.serializeCollectionToJSON(resolutions, file);

        serializerForAny.deserializeResolution(file, Resolution.class);
    }

    @Test
    public void serializeToCustom() {
        OracleQuestionProvider oracleQuestionProvider = new OracleQuestionProvider();
        List<Resolution> resolutions = oracleQuestionProvider.askOracle(1000);

        String file = "newFileJSON";
        SerializerForAny serializerForAny = new SerializerForAny();
        serializerForAny.serializeCollectionToCustomJSON(resolutions, file);
    }

   @Test
    public void deserialize() {
        OracleQuestionProvider oracleQuestionProvider = new OracleQuestionProvider();
        List<Resolution> resolutions = oracleQuestionProvider.askOracle(1000);

        String file = "newFileJSON";
        SerializerForAny serializerForAny = new SerializerForAny();
        serializerForAny.serializeCollectionToCustomJSON(resolutions, file);

       serializerForAny.deserializeCollectionFromFileCustom(file, Resolution.class);

    }
}