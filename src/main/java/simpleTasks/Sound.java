package simpleTasks;

public class Sound {

    private final String sound;
    private MusicalInstrument instrument;

    public Sound(String sound, MusicalInstrument instrument) {
        this.sound = sound;
        this.instrument = instrument;
    }

    @Override
    public String toString() {
        return "You hear "+ sound + " by " + instrument.getClass().getSimpleName();
    }
}
