package customPackage.plants;

public class Raspberry extends Plant {

    public Raspberry(String sort_name, int gestation_time, int max_berries){
        super(sort_name, gestation_time, max_berries);
    }

    public static void main(String[] args) {
        int berries;
        Raspberry plainsman = new Raspberry("plainsman", 20, 50);

        berries = plainsman.gestate(plainsman.gestation_time, plainsman.max_berries);
        System.out.println("Number of berries on this bush: " + berries);
    }
}
