package task5;

import org.junit.Test;
import task3.Oracle;
import task3.OracleReaction;
import task3.Resolution;

import static org.junit.Assert.*;

import java.util.ArrayList;


public class OracleAnalyzerTest {
    OracleAnalyzer oracleAnalyzer = new OracleAnalyzer();

    @Test
    public void statisticTestWithoutDeserialization() {
        ArrayList<Resolution> resolutions = new ArrayList<>();
        String testQuestion = "TestQuestion";
        String testAnotherQuestion = "TestQuestion2";
        String popularQuestion = "TestQuestion3";


        String stickHitString = OracleReaction.STICK_HIT.getValue();
        String rudenessString = OracleReaction.RUDENESS.getValue();
        int sleepTimesPerQuestion = 5;
        String sleepString = Oracle.leftTimeToSleepMarker + sleepTimesPerQuestion;
        String validAnswerString = "TestValidAnswerString";

        Integer stickHitsTimes = 5;
        Integer rudenessTimes = 10;
        Integer validAnswersTimes = 20;
        Integer sleepTimes = 5;
        Integer timesOfAnotherQuestion = validAnswersTimes + 10;
        Integer timesOFMostPopularQuestion = timesOfAnotherQuestion + 10;

        Integer sleepTimeAtAll = sleepTimes * sleepTimesPerQuestion;

        for (int i = 0; i < stickHitsTimes; i++) {
            resolutions.add(new Resolution(testQuestion, stickHitString));
        }

        for (int i = 0; i < rudenessTimes; i++) {
            resolutions.add(new Resolution(testQuestion, rudenessString));
        }

        for (int i = 0; i < validAnswersTimes; i++) {
            resolutions.add(new Resolution(testQuestion, validAnswerString));
        }
        for (int i = 0; i < sleepTimes; i++) {
            resolutions.add(new Resolution(testQuestion, sleepString));
        }

        for (int i = 0; i < timesOfAnotherQuestion; i++) {
            resolutions.add(new Resolution(testAnotherQuestion, validAnswerString));
        }
        for (int i = 0; i < timesOFMostPopularQuestion; i++) {
            resolutions.add(new Resolution(popularQuestion, validAnswerString));
        }

        ReportData reportData = oracleAnalyzer.analyzeOracleData(resolutions);

        assertNotNull(reportData);

        assertEquals(stickHitsTimes, reportData.timesOfStickHits);
        assertEquals(rudenessTimes, reportData.timesOfRudeness);
        assertEquals(sleepTimeAtAll, reportData.secondsOfSleep);
        assertEquals(popularQuestion, reportData.mostPopularQuestion);


    }

}