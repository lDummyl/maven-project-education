package SortingExperiment;

import
        java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class ReadExperiment {

    public List<Point> readExp(String fileName) {
        List<Point> points = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                points.add(new Point(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return points;
    }
}
