package task8;

import org.junit.Test;
import task7.Pump;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CollectionPump {
    @Test
    public void addSpeedTest() {
        List<Pump> pumps = addPumps();
        Pump pump = pumps.get(0);
        assertEquals(3, pump.getSpeeds().size());
    }

    public static List<Pump> addPumps() {
        ArrayList<Pump> pumps = new ArrayList<>();

        Double[] consumptionGHN_20speed1 = {1.0, 1.5};
        Double[] pressureGHN_20speed1 = {45.0, 50.0};

        Double[] consumptionGHN_20speed2 = {1.0, 1.5, 2.0, 2.5};
        Double[] pressureGHN_20speed2 = {64.0, 70.0, 75.0, 76.0};

        Double[] consumptionGHN_20speed3 = {1.0, 1.5, 2.0, 2.5, 3.0};
        Double[] pressureGHN_20speed3 = {80.0, 90.0, 95.0, 98.0, 95.0};

        Pump GHN_20_65_130 = new Pump("GHN 20/65-130", consumptionGHN_20speed1, pressureGHN_20speed1, 104.0);
        GHN_20_65_130.addSpeed(consumptionGHN_20speed2, pressureGHN_20speed2);
        GHN_20_65_130.addSpeed(consumptionGHN_20speed3, pressureGHN_20speed3);
        pumps.add(GHN_20_65_130);

        Double[] consumptionGHN_25speed1 = {1.0, 2.0, 3.0};
        Double[] pressureGHN_25speed1 = {96.0, 105.0, 112.5};

        Double[] consumptionGHN_25speed2 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
        Double[] pressureGHN_25speed2 = {112.5, 137.5, 155.0, 170.0, 175.0, 185.0};

        Double[] consumptionGHN_25speed3 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};
        Double[] pressureGHN_25speed3 = {150.0, 175.0, 185.0, 195.0, 200.0, 205.0, 205.0, 205.0};

        Pump GHN_25_80_180 = new Pump("GHN 25/80-180", consumptionGHN_25speed1, pressureGHN_25speed1, 270.0);
        GHN_25_80_180.addSpeed(consumptionGHN_25speed2, pressureGHN_25speed2);
        GHN_25_80_180.addSpeed(consumptionGHN_25speed3, pressureGHN_25speed3);
        pumps.add(GHN_25_80_180);


        Double[] consumptionBasic_40speed1 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0};
        Double[] pressureBasic_40speed1 = {110.0, 120.0, 130.0, 140.0, 140.0, 140.0, 140.0};

        Double[] consumptionBasic_40speed2 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
        Double[] pressureBasic_40speed2 = {180.0, 200.0, 220.0, 240.0, 260.0, 280.0, 285.0, 290.0, 285.0, 260.0};

        Double[] consumptionBasic_40speed3 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0};
        Double[] pressureBasic_40speed3 = {280.0, 290.0, 300.0, 310.0, 320.0, 330.0, 340.0, 350.0, 360.0, 350.0, 340.0, 330.0, 320.0};

        Pump GHN_Basic_40_70_F = new Pump("GHN Basic 40-70 F", consumptionBasic_40speed1, pressureBasic_40speed1, 49_689.0);
        GHN_Basic_40_70_F.addSpeed(consumptionBasic_40speed2, pressureBasic_40speed2);
        GHN_Basic_40_70_F.addSpeed(consumptionBasic_40speed3, pressureBasic_40speed3);
        pumps.add(GHN_Basic_40_70_F);


        Double[] consumptionBasic_80speed1 = {1.0, 5.0, 10.0, 15.0, 25.0};
        Double[] pressureBasic_80speed1 = {40.0, 600.0, 650.0, 650.0, 600.0};

        Double[] consumptionBasic_80speed2 = {1.0, 5.0, 15.0, 30.0, 50.0};
        Double[] pressureBasic_80speed2 = {200.0, 1000.0, 1200.0, 1400.0, 1200.0};

        Double[] consumptionBasic_80speed3 = {1.0, 10.0, 25.0, 45.0, 65.0};
        Double[] pressureBasic_80speed3 = {400.0, 1600.0, 2000.0, 2100.0, 1500.0};

        Pump GHND_Basic_80_120_F = new Pump("GHND_Basic_80_120_F", consumptionBasic_80speed1, pressureBasic_80speed1, 230_134.82);
        GHND_Basic_80_120_F.addSpeed(consumptionBasic_80speed2, pressureBasic_80speed2);
        GHND_Basic_80_120_F.addSpeed(consumptionBasic_80speed3, pressureBasic_80speed3);
        pumps.add(GHND_Basic_80_120_F);


        Double[] consumptionGHN_Basic_80speed1 = {1.0, 5.0, 10.0, 15.0, 25.0};
        Double[] pressureGHN_Basic_80speed1 = {40.0, 500.0, 600.0, 600.0, 500.0};

        Double[] consumptionGHN_Basic_80speed2 = {1.0, 5.0, 15.0, 30.0, 50.0};
        Double[] pressureGHN_Basic_80speed2 = {200.0, 1000.0, 1200.0, 1400.0, 1200.0};

        Double[] consumptionGHN_Basic_80speed3 = {1.0, 10.0, 25.0, 45.0, 65.0};
        Double[] pressureGHN_Basic_80speed3 = {400.0, 1600.0, 2000.0, 2100.0, 1800.0};

        Pump GHN_Basic_80_120_F = new Pump("GHN_Basic_80_120_F", consumptionGHN_Basic_80speed1, pressureGHN_Basic_80speed1, 113_689.49);
        GHN_Basic_80_120_F.addSpeed(consumptionGHN_Basic_80speed2, pressureGHN_Basic_80speed2);
        GHN_Basic_80_120_F.addSpeed(consumptionGHN_Basic_80speed3, pressureGHN_Basic_80speed3);
        pumps.add(GHN_Basic_80_120_F);

        return pumps;
    }
}
