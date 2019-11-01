package task3;

import java.util.Random;

public class Oracle {
    private Random random = new Random();
    private String answer = "Ну... Это даже я не знаю...";
    private String tooLongQuestion = "Будь лаконичней...";
    private String tooShortQuestion = "Будь красноречивее...";
    private String tooManyQuestions = "Ты задаешь слишком много вопросов!";
    private String noQuestion = "Не слышу вопроса в твоих речах.";
    private String rudeness = "Иди в задницу со своими вопросами!!!";
    private String tired = "Я устал... \n Пойду отдохну.";
    private TakeABreak takeABreak = new TakeABreak();


    // TODO: 10/23/19 хорошо, в целом, но есть такая вешь как статический анализ кода, например Sonar. В Идею можно импортировать плагин
    //  sonar lint и он покажет что не так с этим методом. Кроме того часто при совместной работе достигабются определенные конвенции по стилю
    //  чаще всего будет требование блок if размещать в {} строкой ниже. Технически проще мержить такой код так что в этом есть смысл..


    // TODO: 10/25/19 а если я добавлю еще 20 условий, не запутаешься? Лучше разбить на логические модули в зависимости от того что мы обрабатывем, длину содержание и проч.
    public String askTheOracle (String question) {
        switch (whatIsCase(question)){
            case 1: {
                return String.format("Я буду отдыхать еще %s секунд", takeABreak.getTimeToRelax());
            }
            case 2: {
                return noQuestion;
            }
            case 3: {
                return tooManyQuestions;
            }
            case 4: {
                return rudeness;
            }
            case 5: {
                takeABreak.setTimeToRelax(random.nextInt(60));
                takeABreak.start();
                return tired;
            }
            case 6: {
                return tooLongQuestion;
            }
            case 7: {
                return tooShortQuestion;
            }
            case 8: {
                if (question.toLowerCase().contains("\bчто\b")) {
                    return "Эти зания у тебя уже есть, загляни в свою душу";
                }
                if (question.toLowerCase().contains("\bгде\b")) {
                    return "Ты попадешь туда в скором времени";

                }
                if (question.toLowerCase().contains("\bкогда\b")) {
                    return "Когда наступит этот момент - ты узнаешь";

                }
                return answer;
            }
            default: return answer;
        }
    }

    private boolean isQuestion (String question) {
        if (question.contains("?")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isMoreOneQuestion (String question){
        if (isQuestion(question)){
            int answerCount = 0;
            for (int i = 0; i < question.length(); i++) {
                if (question.charAt(i) == '?'){ // TODO: 10/25/19 почему ты уверен что человек всегда озаботится поставить занк впроса, я бы считал слова
                    answerCount++;
                    if (answerCount>1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int whatIsCase (String question){
        int chance = random.nextInt(10);
        if (takeABreak.isAlive()) {
            return 1;
        }
        if (!isQuestion(question)) {
            return 2;
        }
        if (isMoreOneQuestion(question)) {
            return 3;
        }
        if (chance == 6){
            return 4;
        }
        if (chance > 6) {
            return 5;
        }
        if (question.length() > 30) {
            return 6;
        }
        if (question.length() < 5) {
            return 7;
        }
        return 8;
    }

}
