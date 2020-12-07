package task5;

import task3.Resolution;
import task4.ArraySerializerToJson;

import java.time.LocalDateTime;
import java.util.Collection;

public class OracleAnalyzer {
    ArraySerializerToJson arraySerializerToJson = new ArraySerializerToJson();

    public ReportData analyzeOracleData(String fileName) {
        Collection<Resolution> resolutions = arraySerializerToJson.deserializeJsonArray(fileName, Resolution.class);


        getTimesOfRudeness();
        getTimesOfStickHit();
        mostPopularValidAnswer();
        getAbsoluteTimeOFSleep();


        return new ReportData(getTimesOfRudeness(), getTimesOfStickHit(), getAbsoluteTimeOFSleep().getSecond(), mostPopularValidAnswer());
    }

    private LocalDateTime getAbsoluteTimeOFSleep() {
        return null;
    }

    private String mostPopularValidAnswer() {
        return null;
    }

    private Integer getTimesOfStickHit() {
        return null;
    }

    private Integer getTimesOfRudeness() {
        return null;
    }

}
