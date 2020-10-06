package SortingExperiment;

public class Point {
    Integer code;
    Double temperature;
    Integer frequency;

    public Point(String allPoints) {
        String[] split = allPoints.split(",");

        this.code = Integer.parseInt(split[0].replaceAll("\\s+", ""));
        this.temperature = Double.parseDouble(split[1].replaceAll("\\s+", ""));
        this.frequency = Integer.parseInt(split[2].replaceAll("\\s+", ""));
    }
}
