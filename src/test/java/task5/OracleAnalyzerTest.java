package task5;

import org.junit.Test;
import task3.Resolution;
import task4.ArraySerializerToJson;
import task4.ArraySerializerToJsonTest;
import task4.OracleQuestionProvider;
import task4.QuestionsGenerator;

import java.util.Collection;

import static org.junit.Assert.*;

public class OracleAnalyzerTest {

    @Test
    public void deserializeAndAnalyze() {
    }

    @Test
    public void analyzeOracleData() {
        ArraySerializerToJson arraySerializerToJson = new ArraySerializerToJson();
        Collection<Resolution> newFileJSON = arraySerializerToJson.deserializeJsonArray("newFileJSON", Resolution.class);

        OracleAnalyzer oracleAnalyzer = new OracleAnalyzer();
       oracleAnalyzer.analyzeOracleData(newFileJSON);


    }

}