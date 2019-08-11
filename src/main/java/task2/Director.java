package task2;

import java.util.List;
import java.util.Random;

public class Director {
    private Secretary secretary;

    public void makeDecision(List<WantAJob> candidates) {
        if (secretary == null) {
            Random random = new Random(); // при каждом вызове этого метода будет создаваться новый Рандом это нехорошо (будет не очень рандомно :), лучше создать его однажды в поле и потом вызывать.
            //++ Debug
            int size = candidates.size() - 1; // не путай так человека, который будет читать если вычитаешь из size 1 то переменную назови lastIndex
            int index = random.nextInt(size);
            System.out.println(index + " " + size + " ");
            //--
            secretary = (Secretary) candidates.get(index); // а вот тут тебя ждет ClassCastException
        }
    }

    public Secretary getSecretary() {
        return secretary;
    }
}
