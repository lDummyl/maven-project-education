package SortingExperiment;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadExperiment readExperiment = new ReadExperiment();
        List pointList = readExperiment.readExp("C:\\Users\\Sakro\\Documents\\Java\\maven-project-education\\src\\main\\java\\SortingExperiment\\test");

        FreqReport freqReport = new FreqReport(pointList);
        freqReport.setField();
        List badPoints =  freqReport.getBadPoints();
        System.out.println(badPoints);
    }
}
