package simpleTasks;

public class Violin extends StringInstrument {

    private final String madeBy;

    public Violin(String madeBy) {
        this.madeBy = madeBy;
    }


    @Override
    public Sound play() {

        if (madeBy.equals("Stradivari")){
            return new Sound("Magnificent Sound!", this);
        } else {
            return new Sound("Ok Sound", this);
        }
    }
}
