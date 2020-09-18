package task7.service;

import task7.dao.PumpDao;
import task7.model.Pump;

import java.util.Optional;

public class PumpCalculator {

    PumpDao pumpDao;

    public Optional<Pump> get(Double flow, Double power) {
        return pumpDao.selectPump(flow, power);
    }
    //Был конструктор, пришлось для тестов делать сеттер. Как правильно?
    public void setPumpDao(PumpDao pumpDao) {
        this.pumpDao = pumpDao;
    }
}
