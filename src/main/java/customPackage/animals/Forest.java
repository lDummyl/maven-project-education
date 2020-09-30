package customPackage.animals;

public class Forest {
    public static void main(String[] args) {
        // eagle -- males and females
        Eagle baldie = new Eagle("Baldie", true, "male");
        Eagle lessie = new Eagle("Lessie", true, "female");
        Blackbird blackie = new Blackbird("Blackie", true, "male");
        Rookie bbird = new Rookie("B-Bird", true, "male");
        // eagles eats blackbirds
        baldie.eats(blackie);
        // eagle eats rookies
        baldie.eats(bbird);
        // eagle nests and sits on eggs
        lessie.nesting();
    }
}
