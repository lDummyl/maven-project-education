package task2;

import java.util.List;
import java.util.Random;

public class Director {
    private WantAJob secretary; // решение не плохое, но как-то секретарь должен еще что-то помимо прохождения интервью уметь. Я бы всеже вынес его в Офис отсюда совсем. И при назначании проводил финальную проверку через instanceof
    private Random random = new Random();

    private final int enoughCandidatesToDecide = 3; // теперь это не magic number, и не стоит выбирать из одного кандидата


    public void makeDecision(List<WantAJob> candidates) {
        if (secretary == null) {
            //Random random = new Random(); // при каждом вызове этого метода будет создаваться новый Рандом это нехорошо (будет не очень рандомно :), лучше создать его однажды в поле и потом вызывать.
            int lastIndex = candidates.size() - 1; // не путай так человека, который будет читать если вычитаешь из size 1 то переменную назови lastIndex
                                                   // согласен, с названиями переменных у меня не всегда все ясно и просто
            int index = random.nextInt(lastIndex);
            //++ Debug
            //System.out.println(index + " " + lastIndex + " ");
            //--
            secretary = candidates.get(index); // исправил // а вот тут тебя ждет ClassCastException
        }
    }

    public WantAJob getSecretary() {
        return secretary;
    }

    private void makeSomeCoffee(){
//        secretary.????
    }

}
