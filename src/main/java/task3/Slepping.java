package task3;

import sun.util.resources.LocaleData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class Slepping {
    public static final int maximuxSleep = 60;

    public void sleepRandom() {
        Random random = new Random();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LocalTime now = LocalTime.now();
        LocalTime sleepTime = now.plusSeconds(random.nextInt(maximuxSleep));

        // TODO: 11/15/2020 Работвет, но не возвращается в очсновной метод пока не будет введена еще строка
        while (LocalTime.now().isBefore(sleepTime)) {
            try {
                String s = reader.readLine();
                if (s != null) {
                    if (Duration.between(LocalTime.now(), sleepTime).isNegative()) {
                        System.out.println("Ну говори, говори");
                    } else {
                        System.out.println(Duration.between(LocalTime.now(), sleepTime));
                    }
                }
            } catch (IOException e) {
                System.out.println("Wrong");
            }
        }
    }

    public static void main(String[] args) {
        Slepping slepping = new Slepping();
        slepping.sleepRandom();
    }
}
