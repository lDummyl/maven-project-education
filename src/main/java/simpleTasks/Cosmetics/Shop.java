package simpleTasks.Cosmetics;

import org.w3c.dom.ls.LSOutput;
import simpleTasks.DomesticAppliances.MyVersion.Water;

public class Shop {

    public static void main(String[] args) throws Exception {
        Parfum parfum = new Parfum("Armani", 6000, "Flowers");
        Parfum parfum2 = new Parfum("Armani", 6000, "Citrus");
        Lipstick lipstick1 = new Lipstick("Lancome",2000, "Red");
        Lipstick lipstick2 = new Lipstick("Lancome", 1800, "Peach");
        GlamorousPerson kardashian = new GlamorousPerson("Kim Kardashian");
        kardashian.apply(Parfum.class, parfum.aroma);
        kardashian.apply(Parfum.class, parfum2.aroma);
        kardashian.apply(Lipstick.class, lipstick1.color);
        kardashian.apply(Lipstick.class, lipstick2.color);
        kardashian.apply(Parfum.class, new Water(99)); // TODO: 4/6/20 бедняжке Ким будет очень больно если такое случится
        kardashian.apply(lipstick1);
        kardashian.apply(parfum);   // TODO: 4/6/20 а тут такого не случится


        //  kardashian.applyCosmetics(parfum);
        //kardashian.allCosmetics.forEach(System.out::println);
    }
    // TODO: 4/5/20 запомни метод должен отвечать на простой вопрос.
    //  Что я делаю? Я(Человек) применяю на себя косметику. Прибор не может платить за себя, косметика не накладывает себя сама
    //  если возвращет boolean то отвечает на вопрос любой вопрос под ответ да или нет. isWorkDone, isReadyToWork. и тд
    //  и классов мало меньше 10 а желательно 15ть. .

}
