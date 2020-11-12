package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Slepping implements Runnable {
    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do {
            try {
                String que = reader.readLine();
            } catch (IOException e) {
                System.out.println("Некорректен вопрос");
            }
        }
        while (true);
    }
}
