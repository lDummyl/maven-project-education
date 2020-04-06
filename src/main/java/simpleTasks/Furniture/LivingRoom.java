package simpleTasks.Furniture;

public class LivingRoom {
    public static void main(String[] args) throws Exception {
        Person person = new Person("Olga");
        Carpet carpet = new Carpet();
        Table table = new Table();
        Bed bed = new Bed();

        person.clean(table);
        person.clean(carpet);
        person.goToSleep(bed);
    }
}
