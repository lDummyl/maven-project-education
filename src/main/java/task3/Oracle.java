package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Oracle extends Thread {
    Question question;
    Answer answer;


    public Oracle(String quest) {
        this.question = new Question(quest);
        this.answer = answer;
    }



    public void roulettAction(String question) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            do {
                try {
                    String que = reader.readLine();
                } catch (IOException e) {
                    System.out.println("Некорректен вопрос");
                }

                Random random = new Random();
                int deal = random.nextInt(100);

                if (deal <= 10) {
                    Slepping slepping = new Slepping();
                    slepping.run();
                    // TODO: 11/12/2020   slepping.join; Получается могу создать нить но не могу использовать метод join
                } else if (deal <= 20) {

                } else if (deal <= 30) {

                } else {

                }


            }
            while (!question.equals("exit"));
        }


        public void stickHit() {
            System.out.println("(；一_一) ┻━┻༼ つ ಥ_ಥ ༽つ");
            System.out.println("-Оракл бьёт вас палкой");
        }

        public void sleeping (String question){

        }

        public void start() {

        }

    }
