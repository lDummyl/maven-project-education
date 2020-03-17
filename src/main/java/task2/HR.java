package task2;

import java.util.Random;

public class HR {

   static double tellBossKPIOfEmployees() {
       Random random = new Random();

       return random.nextInt(20) * 1.0;
    }

    double KPI;
    HR(double KPI){
       this.KPI = KPI;
    }
}
