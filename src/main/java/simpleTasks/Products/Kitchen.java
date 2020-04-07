package simpleTasks.Products;

public class Kitchen implements NotEatable{
    public static void main(String[] args) {
        Person person = new Person();

        Pelmeni pelmeni = new Pelmeni();
        Plate plate = new Plate();
        Table table = new Table();
        Fork fork = new Fork();
        // person.takePlate(plate);  //взял тарелку
       // person.putFoodOnPlate(pelmeni);  //наложил пельмешей
       // person.sitDownForDinner(table);  //сел за стол
       // person.takeFork(fork);  //взял вилку
       // person.eat();  //ест
    }
}
