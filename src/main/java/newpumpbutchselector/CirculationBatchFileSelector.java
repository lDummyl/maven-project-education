package newpumpbutchselector;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import task8.PumpRequest;

import java.io.File;
import java.util.Collection;

/*
    Создать пакетный подбор пакетов насосов, т.е пакеты(массивы) Json-фаилов
    при формировании того же отчета что и в задаче #8
    реализовать поведение при не корректных данных ввода, например, расход
    или напор пропущены или содержат не числовое значение.
    В этом случае расчитать среднюю стоимость всего КП и предложить ее на замену
    при этом в моделе указать !Соответсвтующее предупреждение!,
    итоговый отчет формируется в том же формате

*/
public class CirculationBatchFileSelector {
    private final CirculationPumpBatchSelector selector;
    ObjectMapper mapper;

    public CirculationBatchFileSelector() {
        this.selector = new CirculationPumpBatchSelector();
        this.mapper = new ObjectMapper();
    }

    public void selectPumpsFromRequestFile(File fileWithRequests, File fileToWrite) {
        Collection<PumpRequest> requests = getRequests(fileWithRequests);
        writeToFile(requests, fileToWrite);
    }

    public CirculationPumpBatchReport getReportFromRequestFile(File fileWithRequests) {
        Collection<PumpRequest> requests = getRequests(fileWithRequests);
       return selector.selectPumpsWithReport(requests);
    }

    @SneakyThrows
    private void writeToFile(Collection<PumpRequest> requests, File fileToWrite) {
        mapper.writeValue(fileToWrite, requests);
    }

    @SneakyThrows
    private void writeToFile(CirculationPumpBatchReport report, File fileToWrite) {
        mapper.writeValue(fileToWrite, report);
    }

    @SneakyThrows
    private Collection<PumpRequest> getRequests(File fileWithRequests) {
        return mapper.readValue(fileWithRequests, new TypeReference<Collection<PumpRequest>>() {
        });
    }
}
