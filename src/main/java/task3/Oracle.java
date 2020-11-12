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

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public void run() {
        super.run();
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
                    try {
                        slepping.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // TODO: 11/13/2020 (Для себя) Попробовать через local Date

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

    }
