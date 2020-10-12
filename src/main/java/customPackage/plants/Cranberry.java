package customPackage.plants;

public class Cranberry extends Plant {

    public Cranberry(String sort_name, int gestation_time, int max_berries){
        super(sort_name, gestation_time, max_berries);
    }

    public static void main(String[] args) {
        int berries;
        Cranberry ocean_spray = new Cranberry("ocean_spray", 20, 50);

        berries = ocean_spray.gestate(ocean_spray.gestation_time, ocean_spray.max_berries);
        System.out.println("Number of berries on this bush: " + berries);
    }
}
