package simpleTasks.Cosmetics;

import org.w3c.dom.ls.LSOutput;

public class Shop {
    public static void main(String[] args) {
        Parfum parfum = new Parfum("Armani", "Flowers");
        GlamorousPerson kardashian = new GlamorousPerson("Kim Kardashian");
        kardashian.applyCosmetics(parfum);
        kardashian.allCosmetics.forEach(System.out::println);
    }
    // TODO: 4/5/20 запомни метод должен отвечать на простой вопрос.
    //  Что я делаю? Я(Человек) применяю на себя косметику. Прибор не может платить за себя, косметика не накладывает себя сама
    //  если возвращет boolean то отвечает на вопрос любой вопрос под ответ да или нет. isWorkDone, isReadyToWork. и тд
    //  и классов мало меньше 10 а желательно 15ть. .

}
