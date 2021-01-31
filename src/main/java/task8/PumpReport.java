package task8;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PumpReport {
    private List<PumpTechResponse> pumpTechResponses;
    private PumpCommercialBlock commercialBlock;
    private Integer successSelected;
    private Integer failSelected;
    private Integer requestIntTotal;
    private LocalDate dateTime;

    public PumpReport(List<PumpTechResponse> pumpTechResponses) {
        this.pumpTechResponses = pumpTechResponses;
        this.commercialBlock = new PumpCommercialBlock(getPumpTechResponses());
        this.successSelected = getSuccessNumber(pumpTechResponses);
        this.requestIntTotal = pumpTechResponses.size();
        this.failSelected = requestIntTotal - successSelected;
        getDataTime();
    }

    private void getDataTime() {
        LocalDate dateTime = pumpTechResponses.get(0).getRequest().getDateTime();
        if (dateTime != null) {
            this.dateTime = dateTime;
        }
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
}
