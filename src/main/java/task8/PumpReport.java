package task8;


import task7.Pump;


import java.util.List;

public class PumpReport {
    List<Pump> pumpsList;
    PumpTechnicalBlock technicalBlock;
    PumpCommercialBlock commercialBlock;

    public PumpReport(PumpRequest request, List<Pump> pumpsList) {
        this.pumpsList = pumpsList;
        this.technicalBlock = new PumpTechnicalBlock(request, pumpsList);
    }
}
