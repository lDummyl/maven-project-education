package customPackage.plants;

public class Gooseberry extends Plant {

    public Gooseberry(String sort_name, int gestation_time, int max_berries){
        super(sort_name, gestation_time, max_berries);
    }

    public static void main(String[] args) {
        int berries;
        Gooseberry golden = new Gooseberry("golden", 20, 50);

        berries = golden.gestate(golden.gestation_time, golden.max_berries);
        System.out.println("Number of berries on this bush: " + berries);
    }
}
