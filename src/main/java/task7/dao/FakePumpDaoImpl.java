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
    // TODO: 9/18/20 а вот тут детские игрушки кончаются, насос описыватся характеристикой кривой,
    //  по одной на каждую скорость и по ней нужно подобрать подходящий, настоящий насос https://imp-pumps.com/wp-content/uploads/2018/10/Katalog-GHN_RUS-min.pdf
    public Optional<Pump> selectPump(Double flow, Double power) {
        List<Pump> listOfConvenientPumps = new ArrayList<>();
        for (Pump pump : pumpList) {
            if (pump.getFlow() > flow && pump.getPressure() > power)
                listOfConvenientPumps.add(pump);
        }
        listOfConvenientPumps.sort((p1, p2) -> (int) (p1.getPrice() - p2.getPrice()));
        if (!listOfConvenientPumps.isEmpty())
            return Optional.of(listOfConvenientPumps.get(0));
        else
            return Optional.empty();
    }
}
