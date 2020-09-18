package customPackage.animals;

public class Rookie extends Animal {
    public Rookie(String name) {
        super(name);
    }

    public static void main(String[] args) {
        Rookie blackie = new Rookie("blackie");
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



