package task3;

import java.util.Random;
import java.util.Scanner;

public class GreatOracle {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public String sticks(){
        return "*Оракул ударил вас палкой*";
    }

    public String huff(){
        int randomIndexCurse = random.nextInt(TextConstants.curse.size());
        return TextConstants.curse.get(randomIndexCurse);
    }

}
