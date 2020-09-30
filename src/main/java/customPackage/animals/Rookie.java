package customPackage.animals;

public class Rookie extends Animal {
    public Rookie(String name, boolean isAlive, String gender) {
        super(name, isAlive, gender);
    }

    public static void main(String[] args) {
        Rookie blackie = new Rookie("blackie", true, "male");
        System.out.println(blackie.scream());
        String food;
        food = "Grain";
        if (food == "Grain") {
            System.out.println(blackie.eatFood(food));
        }

    }

    @Override
    public String scream() {
        return "Karr-r!";
    }

    public boolean eatFood(String foodName) {
        boolean consumed = false;
        switch (foodName) {
            case "Banana":
                consumed = false;
            case "Grain":
                consumed = true;
        }

        return consumed;
    }
}



