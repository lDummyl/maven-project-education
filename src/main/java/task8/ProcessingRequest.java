package task8;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import task7.Calculation;
import task7.CirculatingPump;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessingRequest {
    ObjectMapper mapper = new ObjectMapper();

    public List <Request> readJsonFile (File file) throws IOException {
        return mapper.readValue(file, new TypeReference<List<Request>>(){});
    }

    public List <CirculatingPump> getPumps (List <Request> list){
        Calculation calculation = new Calculation();
        List <Float> listOfX = new ArrayList<>();
        for (Request request : list) {
            listOfX.add(request.getCharacteristics().getPressure());
        }
        return calculation.getListOfSuitablePump(listOfX);
    }

    public void writeToJsonFileSuitablePumps (File file, List <CirculatingPump> pumps) throws IOException {
        mapper.writeValue(file, pumps);
    }
}
