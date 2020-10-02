package customPackage.animals;

public class Forest {
    public static void main(String[] args) {
        // eagle -- males and females
        Eagle baldie = new Eagle("Baldie", Gender.MALE);
        Eagle giffie = new Eagle("Giffie", Gender.MALE);
        Eagle lessie = new Eagle("Lessie", Gender.FEMALE);
        Rookie bbird = new Rookie("B-Bird", Gender.MALE);
        // eagle eats rookies
        baldie.eats(bbird);
        // eagle nests and sits on eggs
        Egg egg;
        egg = lessie.createEgg(baldie);
        System.out.println(egg);
        egg = giffie.createEgg(baldie);
        System.out.println(egg);
        lessie.nesting();
    }
}
