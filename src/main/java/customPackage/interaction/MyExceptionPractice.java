package customPackage.interaction;

import customPackage.animals.Egg;
import customPackage.animals.Gender;

public class MyExceptionPractice {
    public static void main(String[] args) {
        System.out.println("Program start");
        if (true) {
            try {
                Egg egg = provideEgg();
                egg.growUp();
            } catch (NullPointerException e) {
                System.out.println("Not Good at all!");
                System.exit(-1);
            } catch (RuntimeException e) {
                System.out.println("Exception has been caught");
            }
        }
        System.out.println("Program stop");
    }

    public static Egg provideEgg() {
        //throw new RuntimeException("Хоба!");
        try {
            throw new Exception("Хоба!");
        } catch (Exception e) {
            throw new RuntimeException(e);
            // Interview question - what's the difference between checked and unchecked exception RuntimeException
        }
    }
}