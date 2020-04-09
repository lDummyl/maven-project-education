package simpleTasks.Products;

public class Kitchen {
    public static void main(String[] args) {
        Person person = new Person();
        Dog dog = new Dog();
        Spaghetti spaghetti = new Spaghetti();
        person.name = "Olga";
        person.preferFood.add(spaghetti.getClass().getSimpleName());

        Pelmeni pelmeni = new Pelmeni();
        Plate plate = new Plate();
        plate.putFoodOnPlate(pelmeni);
        plate.putFoodOnPlate(spaghetti);
        Table table = new Table();
        table.putPlate(plate);

        Fork fork = new Fork();
        System.out.println(pelmeni.done);
        cook(pelmeni);
        System.out.println(pelmeni.done);
        cook(spaghetti);
        person.takePlate(plate);  //взял тарелку
//         person.putFoodOnPlate(pelmeni);  //наложил пельмешей
//         person.sitDownForDinner(table);  //сел за стол
//         person.takeFork(fork);  //взял вилку


        dog.bark();

        person.eat();  //ест
        feed(dog);
        feed(person, spaghetti);
    }

    private static void feed(Eater eater, Food food) {
        if (food.done) {
            eater.eat(food);
        }
    }

    private static void cook(Food food) {
        if (food instanceof Boilable) {
            boil(food);
        }
    }

    private static void boil(Food food) {
        food.done = true;
    }

    private static void feed(Eater eater) {
        Pelmeni pelmeni = new Pelmeni();
        eater.eat(pelmeni);
    }

}
