package MyCodeWars;

import java.util.Arrays;
import java.util.function.Function;

public class TwoSum {
           // Вернусть индексы элементов которые дают сумму равную целевому числу
            public static int[] twoSum(int[] numbers, int target)
            {


             int currentSum = 0;
                int[] recht= new int[2];
                for (int i = 0; i < numbers.length; i++) {
                    for (int j = i+1; j <= numbers.length-1; j++) {
                        currentSum = numbers[i] + numbers[j];
                        if (currentSum == target){
                            recht[0] = i;
                            recht[1] = j;
                        }
                    }
                }

                return recht;
            }

}
