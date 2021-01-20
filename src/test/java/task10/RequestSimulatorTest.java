package task10;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import newpumpbutchselector.CirculationPumpBatchReport;
import newpumpselector.CirculationPumpSelector;
import newpumpselector.CirculationPumpSelectorException;
import org.junit.Test;
import task7.Pump;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class RequestSimulatorTest {

    @Test
    public void simulationTest(){
        RequestSimulator requestSimulator = new RequestSimulator();
        Integer numberOfReports = 10;
        int numberOfRequests = 7;


        List<CirculationPumpBatchReport> simulate = requestSimulator.simulate(numberOfReports, numberOfRequests);
        GeneralPumpReport generalPumpReport = new GeneralPumpReport();
        System.out.println();
    }
    /*public static void main(String[] args) throws CirculationPumpSelectorException, JsonProcessingException {
        CirculationPumpSelector circulationPumpSelector = new CirculationPumpSelector();
        Optional<Pump> pump = circulationPumpSelector.selectPump(1.0, 1.0);
        ObjectMapper ma = new ObjectMapper();
        String s = ma.writeValueAsString(pump);
        System.out.println(s);
    }*/

}