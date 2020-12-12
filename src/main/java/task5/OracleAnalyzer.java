package task5;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import task3.Oracle;
import task3.OracleReaction;
import task3.Resolution;


import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class OracleAnalyzer {
    ObjectMapper objectMapper = new ObjectMapper();

    public ReportData deserializeAndAnalyze(String filename) {
        List<Resolution> resolutions = null;
        try {
            resolutions = objectMapper.readValue(filename +".json", new TypeReference<List<Resolution>>()  {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return analyzeOracleData(resolutions);
    }

    public ReportData analyzeOracleData(Collection<Resolution> resolutions) {
        Integer timesOfRudeness = getTimesOfRudeness(resolutions);
        Integer timesOfStickHit = getTimesOfStickHit(resolutions);
        String mostPopularQuestion = mostPopularQuestion(resolutions);
        Integer absoluteTimeOFSleep = getAbsoluteTimeOFSleep(resolutions);

        return new ReportData(timesOfRudeness, timesOfStickHit, absoluteTimeOFSleep, mostPopularQuestion);
    }

    private Integer getAbsoluteTimeOFSleep(Collection<Resolution> resolutions) {
        int sum = resolutions.stream().map(Resolution::getAnswer)
                .filter(s -> s.contains(Oracle.leftTimeToSleepMarker))
                .map(s -> s.replaceAll("[^0-9.]", ""))
                .mapToInt(Integer::parseInt).sum();
        return sum;
    }

    private String mostPopularQuestion(Collection<Resolution> resolutions) {
        // TODO: 08.12.2020 Скорее всего можно решить по аналогии с оффисом с помощью map
        Map<String, List<String>> questionMap = resolutions.stream().map(Resolution::getQuestion).sorted().collect(Collectors.groupingBy(String::valueOf));

        int biggestList = 0;
        String popularQuestion = "";

        for (Map.Entry<String, List<String>> entry : questionMap.entrySet()) {
            int size = entry.getValue().size();
            if (size > biggestList){
                biggestList = size;
                popularQuestion = entry.getValue().get(0);
            }
        }

        return popularQuestion;
    }

    private Integer getTimesOfStickHit(Collection<Resolution> resolutions) {
        List<String> collect = resolutions.stream().map(Resolution::getAnswer)
                .filter(s -> s.contains(OracleReaction.STICK_HIT.getValue()))
                .collect(Collectors.toList());

        return collect.size();
    }

    private Integer getTimesOfRudeness(Collection<Resolution> resolutions) {
        List<String> collect = resolutions.stream().map(Resolution::getAnswer)
                .filter(s -> s.contains(OracleReaction.RUDENESS.getValue()))
                .collect(Collectors.toList());

        return collect.size();
    }

}
