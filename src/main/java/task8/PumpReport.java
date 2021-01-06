package task8;


import java.util.List;


public class PumpReport {
    private List<PumpTechResponse> pumpTechResponses;
    private PumpCommercialBlock commercialBlock;

    public PumpReport(List<PumpTechResponse> pumpTechResponses) {
        this.pumpTechResponses = pumpTechResponses;
        this.commercialBlock = new PumpCommercialBlock(getPumpTechResponses());
    }

    public PumpReport() {
    }


    public List<PumpTechResponse> getPumpTechResponses() {
        return pumpTechResponses;
    }

    public void setPumpTechResponses(List<PumpTechResponse> pumpTechResponses) {
        this.pumpTechResponses = pumpTechResponses;
    }

    public PumpCommercialBlock getCommercialBlock() {
        return commercialBlock;
    }

    public void setCommercialBlock(PumpCommercialBlock commercialBlock) {
        this.commercialBlock = commercialBlock;
    }
}
