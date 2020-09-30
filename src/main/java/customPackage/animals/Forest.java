package customPackage.animals;

public class Forest {
    public static void main(String[] args) {
        // eagle -- males and females
        Eagle baldie = new Eagle("Baldie", true, Gender.MALE);
        Eagle giffie = new Eagle("Giffie", true, Gender.MALE);
        Eagle lessie = new Eagle("Lessie", true, Gender.FEMALE);
        Blackbird blackie = new Blackbird("Blackie", true, Gender.MALE);
        Rookie bbird = new Rookie("B-Bird", true, Gender.MALE);
        // eagles eats blackbirds
        baldie.eats(blackie);
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
