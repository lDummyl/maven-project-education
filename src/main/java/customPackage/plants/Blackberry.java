package customPackage.plants;

public class Blackberry extends Plant {

    public Blackberry(String sort_name, int gestation_time, int max_berries) {
        super(sort_name, gestation_time, max_berries);
    }

    public static void main(String[] args) {
        int berries;
        Blackberry kiowa = new Blackberry("kiowa", 15, 100);
        berries = kiowa.gestate(kiowa.gestation_time, kiowa.max_berries);
        System.out.println("Number of berries on this bush: " + berries);
    }
}
