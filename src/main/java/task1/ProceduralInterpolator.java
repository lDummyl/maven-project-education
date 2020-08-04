package task1;

import java.util.Scanner;

// по 3 м точкам получить коэффициенты квадратного трехчлена ax2 + bx + c в виде массива [a,b,c]

public class ProceduralInterpolator {

// Polynomial Lagrange interpolation

    public static void main(String[] args) {
        //Declaration of the scanner variable
        Scanner myScanner = new Scanner(System.in);

        //Declaration of variables
        int n; //Number of terms
        int count, count2; //Loop variables, for counting loops

        float[] arrayx = new float[200]; //Array limit 199
        float[] arrayy = new float[200]; //Array limit 199
        //The arbitrary value, x to be entered for
        //which the value of y can be known
        float x = 0;
        float y = 0; //The corresponding value, f(x)=y
        float numerator; //The numerator
        float denominator;  //The denominator

        //Prompt a user to enter a value
        System.out.print("Enter the number of terms n: ");
        n = myScanner.nextInt(); //Store the value in n

        //Prompt user to enter the array for X
        System.out.println("Enter the values that are in xi.");

        for (count = 0; count < n; count++) //Start the loop for X
        {
            //Prompt the user to enter the sequel for xi
            System.out.print("Enter the value for x" + count + ": ");
            //Store the sequence in the Array, arrayx
            arrayx[count] = myScanner.nextFloat();
        }
        //Prompt user to enter the array for Y
        System.out.println("Enter the values that are in yi.");
        for (count = 0; count < n; count++) // loop for Y
        {
            //Prompt the user to enter the sequence for yi
            System.out.print("Enter the value for y" + count + ": ");
            //Store the sequence in the Array, arrayy
            arrayy[count] = myScanner.nextFloat();
        }
        //Prompt the user to enter any (the arbitrary)
        //value x to get the corresponding value of y
        System.out.print("Enter the arbitrary value x for which you want the value y: ");
        x = myScanner.nextFloat();  //Store the value in x

        //first Loop for the polynomial calculation
        for (count = 0; count < n; count++) {
            //Initialisation of variable
            numerator = 1;
            denominator = 1;

            //second Loop for the polynomial calculation
            for (count2 = 0; count2 < n; count2++) {
                if (count2 != count) {
                    numerator = numerator * (x - arrayx[count2]);
                    denominator = denominator * (arrayx[count] - arrayx[count2]);
                }
            }
            y = y + (numerator / denominator) * arrayy[count];
        }
        System.out.println("When x = " + x + "," + " y = " + y);
    }
}

