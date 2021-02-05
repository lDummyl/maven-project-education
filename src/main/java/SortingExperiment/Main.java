package SortingExperiment;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ReadExperiment readExperiment = new ReadExperiment();
        List<Point> pointList = readExperiment.readExp("C:\\Users\\Sakro\\Documents\\Java\\maven-project-education\\src\\main\\java\\SortingExperiment\\test");

        AcceptableRange<Double> range = new RangerImpl().getRange(pointList.stream().map(i -> i.frequency.hzValue).collect(Collectors.toList()));
        List<Point> goodPoints = pointList.stream().filter(p -> p.frequency.hzValue >= range.lowerBound &&
                p.frequency.hzValue <= range.upperBound).collect(Collectors.toList());
        System.out.println(goodPoints);


//        FreqReport freqReport = new FreqReport(pointList);
//        freqReport.setField();
//        List badPoints = freqReport.getBadPoints();
//        System.out.println(badPoints);
    }
}
