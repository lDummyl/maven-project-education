package newpumpselector;

import task7.Pump;

import java.util.Collection;

public interface CirculationPumpCollector {
    Collection<Pump> getPumps();
    void addPump(Pump pump);
}
