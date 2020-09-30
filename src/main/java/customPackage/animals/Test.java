package customPackage.animals;

public class Test {

    public static void toPrint(Animal creature) {
        System.out.printf(creature.scream());
    }

    public static void main(String[] args) {

        // TODO: 8/25/20 Нужно больше животных, еще 5ть минимум. Объедините общее поведение в интерфейсы,
        //  например, кусает и собака и змея значит у них общий интерфейс. Больше полей (свойств) у каждого класса и нужно чтобы
        //  у вас были разные объекты пока у вас один класс - один объект, а нужно много разных, собак, кошек, змей ядовитых и нет,
        //  кусачих и мирных, с намордником и без, разных объектов одного класса, ведущих себя по разному(поля должны определять\влиять на повдение).
        Dog doggie = new Dog("Beenie", true, "male");
        Bird birdie = new Bird("Beekie", true, "female");
        Donkey maxie = new Donkey("Max", true, "male");
        toPrint(doggie);
        toPrint(birdie);
    }
}
