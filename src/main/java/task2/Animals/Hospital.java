package task2.Animals;

import java.util.ArrayList;
import java.util.List;

public class Hospital {




    public void invite(List <Animals> list, PlayGrownd playGrownd) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Vaccinated " + list.get(i));
            playGrownd.invite(list.get(i));
        }
        }
}
