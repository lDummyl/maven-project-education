package task7;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    List <CirculatingPump> listOfPumps = new ArrayList<>();
    {
     listOfPumps.add(new CirculatingPump("КАЛИБР", 65.0, 41.6, 4, 1609.00));
     listOfPumps.add(new CirculatingPump("ВИХРЬ", 72.0, 50.0, 4, 3090.00));
     listOfPumps.add(new CirculatingPump("UNIPUMP", 100.0, 63.33, 6, 2709.00));
     listOfPumps.add(new CirculatingPump("ELITECH", 105.0, 23.0, 9, 4500.00));
     listOfPumps.add(new CirculatingPump("MATEUS", 93.0, 55.0, 6, 2498.00));
    }

    //Q = 0,86R/TF–TR - формула для расчета расхода
//    температуру можно поставить произвольно?




}
