package task7.util;

import task7.model.Pump;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PumpFiller {

    public List<Pump> fill() {
        List<Pump> list = new ArrayList<>();
        list.add(new Pump(UUID.randomUUID(), "Grundfos1", 100.0, 20.0, 30.0));
        list.add(new Pump(UUID.randomUUID(), "Grundfos2", 200.0, 30.0, 35.0));
        list.add(new Pump(UUID.randomUUID(), "Grundfos3", 300.0, 40.0, 40.0));
        list.add(new Pump(UUID.randomUUID(), "Grundfos4", 400.0, 50.0, 45.0));
        list.add(new Pump(UUID.randomUUID(), "Grundfos5", 500.0, 60.0, 50.0));
        return list;
    }
}
