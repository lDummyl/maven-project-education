package SortingExperiment;

import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class RangerImplTest {

    @Test
    public void getRange() {

        ReadExperiment readExperiment = new ReadExperiment();
        int presentTooBigFrq = 20_000;
        List<Point> pointList = readExperiment.readExp("C:\\Users\\Sakro\\Documents\\Java\\maven-project-education\\src\\main\\java\\SortingExperiment\\test");
        AcceptableRange<Double> range = new RangerImpl().getRange(pointList.stream().map(i -> i.frequency.hzValue).collect(Collectors.toList()));
        List<Point> goodPoints = pointList.stream().filter(p -> p.frequency.hzValue >= range.lowerBound &&
                p.frequency.hzValue <= range.upperBound).collect(Collectors.toList());
        assertFalse(goodPoints.stream().anyMatch(p -> p.frequency.hzValue == presentTooBigFrq));
        System.out.println(goodPoints);
    }
}