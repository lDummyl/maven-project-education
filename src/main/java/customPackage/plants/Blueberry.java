package customPackage.plants;

public class Blueberry extends Plant {

    public Blueberry(String sort_name, int gestation_time, int max_berries){
        super(sort_name, gestation_time, max_berries);
    }

    public static void main(String[] args) {
        int berries;
        Blueberry bluecrop = new Blueberry("bluecrop", 12, 80);

        berries = bluecrop.gestate(bluecrop.gestation_time, bluecrop.max_berries);
        System.out.println("Number of berries on this bush: " + berries);
    }
}
