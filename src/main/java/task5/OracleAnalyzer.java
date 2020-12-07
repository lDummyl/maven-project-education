package task5;

import task3.Resolution;
import task4.ArraySerializerToJson;

import java.time.LocalDateTime;
import java.util.Collection;

public class OracleAnalyzer {
    ArraySerializerToJson arraySerializerToJson = new ArraySerializerToJson();

    public ReportData analyzeOracleData(String fileName) {
        Collection<Resolution> resolutions = arraySerializerToJson.deserializeJsonArray(fileName, Resolution.class);


        getTimesOfRudeness(resolutions);
        getTimesOfStickHit(resolutions);
        mostPopularValidAnswer(resolutions);
        getAbsoluteTimeOFSleep(resolutions);

        return null;
        //return new ReportData(getTimesOfRudeness(), getTimesOfStickHit(), getAbsoluteTimeOFSleep().getSecond(), mostPopularValidAnswer());
    }

    private LocalDateTime getAbsoluteTimeOFSleep(Collection<Resolution> resolutions) {
        return null;
    }

    private String mostPopularValidAnswer(Collection<Resolution> resolutions) {
        return null;
    }

    private Integer getTimesOfStickHit(Collection<Resolution> resolutions) {
        return null;
    }

    private Integer getTimesOfRudeness(Collection<Resolution> resolutions) {
        return null;
    }

}
