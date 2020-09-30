package customPackage.animals;

public class Turkey extends Animal {


    public Turkey(String name, boolean isAlive) {
        super(name, isAlive);
    }

    @Override
    public String scream() {
        return "gobble!";
    }

    public int runAway(boolean threat) {
        int speed;
        if (threat) {
            speed = 10;
        } else {
            speed = 0;
        }
        return speed;
    }
}
