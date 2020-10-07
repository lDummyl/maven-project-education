package SortingExperiment;

public class Point implements Comparable<Point>{
    Integer code;
    Double temperature;
    Double frequency;

    public Point(String allPoints){
        String[] split = allPoints.split(",");

        this.code = Integer.parseInt(split[0].replaceAll("\\s+", ""));
        this.temperature = Double.parseDouble(split[1].replaceAll("\\s+", ""));
        this.frequency = Double.parseDouble(split[2].replaceAll("\\s+", ""));

    }

    @Override
    public int compareTo(Point o) {
        return this.code.compareTo(o.code)*10 + this.temperature.compareTo(o.temperature);
    }
}
