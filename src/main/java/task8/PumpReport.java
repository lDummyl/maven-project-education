package task8;


import java.util.List;
import java.util.stream.Collectors;


public class PumpReport {
    private List<PumpTechResponse> pumpTechResponses;
    private PumpCommercialBlock commercialBlock;
    private Integer successSelected;
    private Integer failSelected;
    private Integer requestIntTotal;

    public PumpReport(List<PumpTechResponse> pumpTechResponses) {
        this.pumpTechResponses = pumpTechResponses;
        this.commercialBlock = new PumpCommercialBlock(getPumpTechResponses());
        this.successSelected = getSuccessNumber(pumpTechResponses);
        this.requestIntTotal = pumpTechResponses.size();
        this.failSelected = requestIntTotal - successSelected;
    }

    private Integer getSuccessNumber(List<PumpTechResponse> pumpTechResponses) {
      return pumpTechResponses.stream().filter(value -> value.getPumpOrNull() != null).collect(Collectors.toList()).size();
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

    public Integer getSuccessSelected() {
        return successSelected;
    }

    public void setSuccessSelected(Integer successSelected) {
        this.successSelected = successSelected;
    }

    public Integer getFailSelected() {
        return failSelected;
    }

    public void setFailSelected(Integer failSelected) {
        this.failSelected = failSelected;
    }

    public Integer getRequestIntTotal() {
        return requestIntTotal;
    }

    public void setRequestIntTotal(Integer requestIntTotal) {
        this.requestIntTotal = requestIntTotal;
    }
}
