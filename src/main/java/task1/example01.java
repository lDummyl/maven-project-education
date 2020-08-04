package task1;

// This small example computes standard deviation

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class example01 {
    public static final int TOTAL_ELEMENTS = 80;

    public static void main(String[] args) {
        Random random = new Random();
        //int[] actual_values = new int[TOTAL_ELEMENTS];
        List<Integer> actual_values = new ArrayList<>();
        int[] measured_values = new int[TOTAL_ELEMENTS];
        int square_sum = 0;
        int i = 0;
        while (i < TOTAL_ELEMENTS) {
            int curr_actual_value = random.nextInt(100);
            actual_values.add(curr_actual_value);
            int curr_measured_value = random.nextInt(100);
            measured_values[i] = curr_measured_value;
            System.out.println("Measured value: " + curr_measured_value +
                    " Actual value: " + curr_actual_value +
                    " Difference: " + (curr_measured_value - curr_actual_value));
            square_sum += Math.pow(curr_measured_value - curr_actual_value, 2);
            i += 1;
        }
        // TO-DO: I cannot print the arrays actual_values and measured_values
        System.out.println(actual_values);
        System.out.println("The standard deviation: " + Math.pow(square_sum / TOTAL_ELEMENTS, 1 / 2));

    }
}
