package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Polynomial Lagrange interpolation

public class LagrangeInterpolator implements Interpolator {

    Scanner myScanner = new Scanner(System.in);
    List<Point> points = new ArrayList<>();

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public static void main(String[] args) {
        LagrangeInterpolator interpolator = new LagrangeInterpolator();
        interpolator.readPointsFromConsole();
        interpolator.readXfromConsole();
    }

    private  void readXfromConsole() {
        System.out.print("Enter the arbitrary value x for which you want the value y: ");
        float x = myScanner.nextFloat();  //Store the value in x
        float y = getY(x);
        System.out.println("When x = " + x + "," + " y = " + y);
    }

    private void readPointsFromConsole() {
        System.out.print("Enter the number of terms n: ");
        int n = myScanner.nextInt(); //Store the value in n
        for (int count = 0; count < n; count++) //Start the loop for X
        {
            System.out.println("Enter point #" + count);
            System.out.print("Enter the value for x" + count + ": ");
            float x = myScanner.nextFloat();
            System.out.print("Enter the value for y" + count + ": ");
            float y = myScanner.nextFloat();
            points.add(new Point(x, y));
        }
    }

    public float getY(float x) {
        float y = 0;
        int n = points.size();
        for (int count = 0; count < n; count++) {
            float numerator = 1;
            float denominator = 1;

            for (int count2 = 0; count2 < n; count2++) {
                if (count2 != count) {
                    numerator = numerator * (x - points.get(count2).x);
                    denominator = denominator * (points.get(count).x - points.get(count2).x);
                }
            }
            y = y + (numerator / denominator) * points.get(count).y;
        }
        return y;
    }
}

class Point {

    float x;
    float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
}