package customPackage.plants;

import java.util.Random;

public abstract class Plant {
    public final String sort_name;
    public int gestation_time;
    public int max_berries;

    public int gestate(int gestation_time, int max_berries){
        for (int i = 0; i < gestation_time; i++) {
            System.out.println("Gestation Week: " + i);
        }
        int berry_count = new Random().nextInt(max_berries);
        return berry_count;
    };

    public Plant(String sort_name, int gestation_time, int max_berries) {
        this.sort_name = sort_name;
        this.gestation_time = gestation_time;
        this.max_berries = max_berries;
    }
}
