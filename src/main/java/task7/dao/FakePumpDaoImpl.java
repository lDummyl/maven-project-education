package task7.dao;

import task7.model.Pump;
import task7.util.PumpFiller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FakePumpDaoImpl implements PumpDao {

    private static final List<Pump> pumpList;
    private static final PumpFiller pumpFiller;

    static {
        pumpFiller = new PumpFiller();
        pumpList = pumpFiller.fill();
    }

    @Override
    public Optional<Pump> selectPump(Double flow, Double power) {
        List<Pump> listOfConvenientPumps = new ArrayList<>();
        for (Pump pump : pumpList) {
            if (pump.getFlow() > flow && pump.getPressure() > power)
                listOfConvenientPumps.add(pump);
        }
        listOfConvenientPumps.sort((p1, p2) -> (int) (p1.getPrice() - p2.getPrice()));
        if (listOfConvenientPumps.size() > 0)
            return Optional.of(listOfConvenientPumps.get(0));
        else
            return Optional.empty();
    }
}
