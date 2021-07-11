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

    public List <Offer> getOffers (List <Request> list){
        List <CirculatingPump> pumps = new ArrayList<>();
        Calculation calculation = new Calculation();
        Sales sales = new Sales();
        List <Offer> offers = new ArrayList<>();
        List <Request> list2 = new ArrayList<>();
        for (Request request : list) {
            if (request.getCharacteristics() != null) {
               CirculatingPump pump = calculation.getSuitablePump(request.getCharacteristics().getPressure());
               pumps.add(pump);
                Offer offer = new Offer(request.date, pump);
                offers.add(offer);
            }
            else {
                list2.add(request);
            }
        }
        for (Request request : list2) {
                    CirculatingPump alternativePump = sales.getAlternativePump(pumps);
                    Offer offer = new Offer(request.date, alternativePump, "Альтернативный насос");
                    offers.add(offer);
                }
        return offers;
    }

    public void writeToJsonFileOffers (File file, List <Offer> offers) throws IOException {
        mapper.writeValue(file, offers);
    }
}
