package task7.service;

import task7.dao.FakePumpDaoImpl;
import task7.dao.PumpDao;
import task7.model.Pump;

import java.util.Optional;

public class PumpCalculator {

    PumpDao pumpDao;

    public PumpCalculator() {
        this.pumpDao = new FakePumpDaoImpl();
    }

    public Optional<Pump> get(Double flow, Double power) {
        return pumpDao.selectPump(flow, power);
    }
}
