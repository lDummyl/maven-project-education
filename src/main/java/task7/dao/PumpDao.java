package task7.dao;

import task7.model.Pump;

import java.util.Optional;
import java.util.UUID;

public interface PumpDao extends Dao<Pump, UUID> {

    Optional<Pump> selectPump(Double flow, Double power);
}
