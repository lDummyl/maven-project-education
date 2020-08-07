package task1;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class NewtonInterpolator implements Interpolator {
    List<Point> points = new ArrayList<>();

    float proterm(int i, float value, float[] x) {
        float pro = 1;
        for (int j = 0; j < i; j++) {
            pro = pro * (value - x[j]);
        }
        return pro;
    }

    void dividedDiffTable(float[] x, float[][] y, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                y[j][i] = (y[j][i - 1] - y[j + 1]
                        [i - 1]) / (x[j] - x[i + j]);
            }
        }
    }

    // Function for applying Newton's
    // divided difference formula
    float applyFormula(float value, float[] x,
                       float[][] y, int n) {
        float sum = y[0][0];

        for (int i = 1; i < n; i++) {
            sum = sum + (proterm(i, value, x) * y[0][i]);
        }
        return sum;
    }

    // Function for displaying
    // divided difference table
    void printDiffTable(float[][] y, int n) {
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.HALF_UP);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                String str1 = df.format(y[i][j]);
                System.out.print(str1 + "\t ");
            }
            System.out.println();
        }
    }

    @Override
    public float getY(float x) {
        int n = points.size(); //Number of terms
        float[][] y = new float[n][n];
        float[] xArr = new float[n];

        for (int i = 0; i < n; i++) {

            xArr[i] = points.get(i).x;
            y[i][0] = points.get(i).y;
        }

        // calculating divided difference table
        dividedDiffTable(xArr, y, n);
        // displaying divided difference table
        printDiffTable(y, n);
        // printing the value
        return this.applyFormula(x, xArr, y, n);
    }

    @Override
    public void setPoints(List<Point> points) {
        this.points = points;

    }


}
