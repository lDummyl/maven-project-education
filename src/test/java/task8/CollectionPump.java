package task8;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import task7.Pump;

import java.io.File;
import java.io.IOException;
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

        Double[] consumptionGHN_20speed1 = {0.22, 0.55, 1.3};
        Double[] pressureGHN_20speed1 = {2.7, 1.7, 0.46};

        Double[] consumptionGHN_20speed2 = {0.24, 1.0, 2.0};
        Double[] pressureGHN_20speed2 = {5.0, 3.0, 1.0};

        Double[] consumptionGHN_20speed3 = {0.5, 1.5, 2.1};
        Double[] pressureGHN_20speed3 = {6.0, 4.5, 2.8};

        Pump GHN_20_65_130 = new Pump("GHN 20/65-130", consumptionGHN_20speed1, pressureGHN_20speed1, 104.0);
        GHN_20_65_130.addSpeed(consumptionGHN_20speed2, pressureGHN_20speed2);
        GHN_20_65_130.addSpeed(consumptionGHN_20speed3, pressureGHN_20speed3);
        pumps.add(GHN_20_65_130);

        Double[] consumptionGHN_25speed1 = {0.5, 2.3, 4.0};
        Double[] pressureGHN_25speed1 = {4.8, 1.4, 0.26};

        Double[] consumptionGHN_25speed2 = {1.0, 4.0, 7.0};
        Double[] pressureGHN_25speed2 = {6.4, 3.5, 0.82};

        Double[] consumptionGHN_25speed3 = {1.0, 3.5, 6.3};
        Double[] pressureGHN_25speed3 = {7.0, 5.9, 3.7};

        Pump GHN_25_80_180 = new Pump("GHN 25/80-180", consumptionGHN_25speed1, pressureGHN_25speed1, 270.0);
        GHN_25_80_180.addSpeed(consumptionGHN_25speed2, pressureGHN_25speed2);
        GHN_25_80_180.addSpeed(consumptionGHN_25speed3, pressureGHN_25speed3);
        pumps.add(GHN_25_80_180);


        Double[] consumptionBasic_40speed1 = {0.5, 4.0, 8.0};
        Double[] pressureBasic_40speed1 = {2.7, 1.5, 0.86};

        Double[] consumptionBasic_40speed2 = {2.0, 6.0, 12.0};
        Double[] pressureBasic_40speed2 = {4.7, 3.5, 1.3};

        Double[] consumptionBasic_40speed3 = {2.0, 6.0, 11.0};
        Double[] pressureBasic_40speed3 = {6.4, 5.0, 3.1};

        Pump GHN_Basic_40_70_F = new Pump("GHN Basic 40-70 F", consumptionBasic_40speed1, pressureBasic_40speed1, 49_689.0);
        GHN_Basic_40_70_F.addSpeed(consumptionBasic_40speed2, pressureBasic_40speed2);
        GHN_Basic_40_70_F.addSpeed(consumptionBasic_40speed3, pressureBasic_40speed3);
        pumps.add(GHN_Basic_40_70_F);


        Double[] consumptionBasic_80speed1 = {4.3, 15.0, 29.0};
        Double[] pressureBasic_80speed1 = {4.1, 2.1, 0.32};

        Double[] consumptionBasic_80speed2 = {10.0, 30.0, 50.0};
        Double[] pressureBasic_80speed2 = {9.0, 5.5, 1.8};

        Double[] consumptionBasic_80speed3 = {12.0, 40.0, 65.0};
        Double[] pressureBasic_80speed3 = {12.0, 8.1, 2.3};

        Pump GHND_Basic_80_120_F = new Pump("GHND_Basic_80_120_F", consumptionBasic_80speed1, pressureBasic_80speed1, 230_134.82);
        GHND_Basic_80_120_F.addSpeed(consumptionBasic_80speed2, pressureBasic_80speed2);
        GHND_Basic_80_120_F.addSpeed(consumptionBasic_80speed3, pressureBasic_80speed3);
        pumps.add(GHND_Basic_80_120_F);


        Double[] consumptionGHN_Basic_80speed1 = {1.4, 10.0, 22.0};
        Double[] pressureGHN_Basic_80speed1 = {5.4, 2.0, 0.31};

        Double[] consumptionGHN_Basic_80speed2 = {5.1, 20.0, 40.0};
        Double[] pressureGHN_Basic_80speed2 = {13.0, 6.8, 1.6};

        Double[] consumptionGHN_Basic_80speed3 = {6.8, 32.0, 56.0};
        Double[] pressureGHN_Basic_80speed3 = {17.0, 12.0, 2.9};

        Pump GHN_Basic_80_190_F = new Pump("GHN_Basic_80_190_F", consumptionGHN_Basic_80speed1, pressureGHN_Basic_80speed1, 113_689.49);
        GHN_Basic_80_190_F.addSpeed(consumptionGHN_Basic_80speed2, pressureGHN_Basic_80speed2);
        GHN_Basic_80_190_F.addSpeed(consumptionGHN_Basic_80speed3, pressureGHN_Basic_80speed3);
        pumps.add(GHN_Basic_80_190_F);

        return pumps;
    }

    public static void main(String[] args) throws IOException {
        List<Pump> pumps = addPumps();
        new ObjectMapper().writeValue(new File("Fill.json"), pumps);
    }
}
