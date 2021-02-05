package newpumpbutchselector;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.Test;
import task8.PumpRequest;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class CirculationBatchFileSelectorTest {
    ObjectMapper objectMapper = new ObjectMapper();
    @SneakyThrows
    @Test
    public void selectPumpsFromRequestFile() {

        File requestFile = new File("src/test/resources/testfiles/circulationpumpselector/RequestFile.json");
        File fileToWrite = new File("src/test/resources/testfiles/circulationpumpselector/Result.json");

        CirculationBatchFileSelector selector = new CirculationBatchFileSelector();
        selector.selectPumpsFromRequestFile(requestFile, fileToWrite);
    }

    @Test
    public void getReportFromRequestFile() {
    }
}