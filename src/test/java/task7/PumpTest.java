package task7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PumpTest {
    @Test
    public void pumpGetValueTest(){
        Double[] pressureGHN_Basic_80speed1 = {1.0, 5.0, 10.0, 15.0, 25.0};
        Double[] consumptionGHN_Basic_80speed1 = {40.0, 500.0, 600.0, 600.0, 500.0};

        Double[] pressureGHN_Basic_80speed2 = {1.0, 5.0, 15.0, 30.0, 50.0};
        Double[] consumptionGHN_Basic_80speed2 = {200.0, 1000.0, 1200.0, 1400.0, 1200.0};

        Double[] pressureGHN_Basic_80speed3 = {1.0, 10.0, 25.0, 45.0, 65.0};
        Double[] consumptionGHN_Basic_80speed3 = {400.0 ,1600.0, 2000.0, 2100.0, 1800.0};

        Pump GHN_Basic_80_120_F = new Pump("GHN_Basic_80_120_F", consumptionGHN_Basic_80speed1, pressureGHN_Basic_80speed1, 113_689.49);
        GHN_Basic_80_120_F.addSpeed(consumptionGHN_Basic_80speed2, pressureGHN_Basic_80speed2);
        GHN_Basic_80_120_F.addSpeed(consumptionGHN_Basic_80speed3, pressureGHN_Basic_80speed3);

        List<Double> pressureValues = new ArrayList<>();
        for (int i = 1; i < 25; i++) {
            pressureValues.add((double) i);
        }

       // pressureValues.stream().map(value -> GHN_Basic_80_120_F.)
    }
}