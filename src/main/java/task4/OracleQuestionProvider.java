package task4;

import task3.Oracle;
import task3.Resolution;

import java.util.ArrayList;
import java.util.List;

// TODO: 05.12.2020 возможно сделал слишком много классов
public class OracleQuestionProvider {
    Oracle oracle = new Oracle();
    QuestionsGenerator questionsGenerator = new QuestionsGenerator();
    SerializerForAny serializer = new SerializerForAny();

    public void askOracleAndSerialize(int numberOfQuestions, String fileName) {
        List<Resolution> resolutions = askOracle(numberOfQuestions);
        serializer.serializeCollectionToJSON(resolutions, fileName);
    }

    public List<Resolution> askOracle(int numberOfQuestions) {

        List<Resolution> resolutions = new ArrayList<>();
        for (int i = 0; i < numberOfQuestions; i++) {
            resolutions.add(oracle.ask(questionsGenerator.getQuestion()));
        }
        return resolutions;
    }
}
