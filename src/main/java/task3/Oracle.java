package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Oracle implements Runnable {
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
                    ;
                }

                Random random = new Random();
                Integer deal = random.nextInt(100);

                if (deal <= 10) {

                } else if (deal > 10 && deal <= 20) {

                } else if (deal > 20 && deal <= 30) {

                } else if (deal > 30 && deal <= 100) {

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


        @Override
        public void run () {

        }
    }
