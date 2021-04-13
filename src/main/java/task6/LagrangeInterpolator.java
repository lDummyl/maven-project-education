package task6;


import java.util.Scanner;

public class LagrangeInterpolator extends Interpolator {

	Scanner myScanner = new Scanner(System.in);

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
}

