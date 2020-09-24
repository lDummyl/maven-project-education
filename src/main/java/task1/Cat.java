package task1;

public class Cat extends Animal { // создаем класс Cat отнаследованный от класса Animal
    public Cat(String name) {
        super(name);
    }

    public void play(Cottonball cottonball) { // создаем метод play
        System.out.println(name + " plays with " + cottonball); // выводим на экран

    }
}
