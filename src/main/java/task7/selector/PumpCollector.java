package task7.selector;

import task7.pump.Pump;

import java.util.Collection;

public interface PumpCollector {
    Collection<Pump> getPumps();
    void addPump(Pump pump);
}
