package customPackage.plants;

import customPackage.people.Gardener;

public class BerryGarden {

    public static void main(String[] args) {
        Gardener johnson = new Gardener("Johnson",50);
        BerryGarden grove = new BerryGarden();

        int b_berries;
        Blackberry kiowa = new Blackberry("kiowa", 15, 100);
        b_berries = kiowa.gestate(kiowa.gestation_time, kiowa.max_berries);
        System.out.println("Number of berries on this bush: " + b_berries);

        int r_berries;
        Raspberry plainsman = new Raspberry("plainsman", 20, 50);
        r_berries = plainsman.gestate(plainsman.gestation_time, plainsman.max_berries);
        System.out.println("Number of berries on this bush: " + r_berries);
    }
}
