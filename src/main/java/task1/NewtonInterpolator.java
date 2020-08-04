package task1;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

class GFG {
    // Function to find the product term
    static float proterm(int i, float value, float[] x) {
        float pro = 1;
        for (int j = 0; j < i; j++) {
            pro = pro * (value - x[j]);
        }
        return pro;
    }

    // Function for calculating
    // divided difference table
    static void dividedDiffTable(float[] x, float[][] y, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                y[j][i] = (y[j][i - 1] - y[j + 1]
                        [i - 1]) / (x[j] - x[i + j]);
            }
        }
    }

    // Function for applying Newton's
    // divided difference formula
    static float applyFormula(float value, float[] x,
                              float[][] y, int n) {
        float sum = y[0][0];

        for (int i = 1; i < n; i++) {
            sum = sum + (proterm(i, value, x) * y[0][i]);
        }
        return sum;
    }

    // Function for displaying
    // divided difference table
    static void printDiffTable(float[][] y, int n) {
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

    public static void main(String[] args) {
        // number of inputs given
        float value, sum;
        //Declaration of the scanner variable
        Scanner myScanner = new Scanner(System.in);

        //Declaration of variables
        int n; //Number of terms
        int count, count2; //Loop variables, for counting loops

        //Prompt a user to enter a value
        System.out.print("Enter the number of terms n: ");
        n = myScanner.nextInt(); //Store the value in n
        float[][] y = new float[n][n];
        float[] x = new float[n];

        // y[][] is used for divided difference
        // table where y[][0] is used for input
//        y[0][0] = 12;
//        y[1][0] = 13;
//        y[2][0] = 14;
//        y[3][0] = 16;
        for (count = 0; count < n; count++) //Start the loop for X
        {
            //Prompt the user to enter the sequel for xi
            System.out.print("Enter the value for x" + count + ": ");
            //Store the sequence in the Array, arrayx
            x[count] = myScanner.nextFloat();
        }
        //Prompt user to enter the array for Y
        System.out.println("Enter the values that are in yi.");
        for (count = 0; count < n; count++) // loop for Y
        {
            //Prompt the user to enter the sequence for yi
            System.out.print("Enter the value for y" + count + ": ");
            //Store the sequence in the Array, arrayy
            y[count][0] = myScanner.nextFloat();
        }

        // calculating divided difference table
        dividedDiffTable(x, y, n);

        // displaying divided difference table
        printDiffTable(y, n);

        // value to be interpolated
        value = 7;

        // printing the value
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        System.out.println("\nValue at " + df.format(value) + " is "
                + df.format(applyFormula(value, x, y, n)));
    }

    public class NewtonInterpolator implements Interpolator {

        @Override
        public float getY(float x) {
            throw new NotImplementedException();
        }

        @Override
        public void setPoints(List<Point> points) {
            throw new NotImplementedException();
        }


    }
}
