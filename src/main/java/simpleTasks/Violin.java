package simpleTasks;

public class Violin extends StringInstrument {


    public Violin(String madeBy) {
        this.brandName = madeBy;
    }


    @Override
    public Sound play() {

        if (brandName.equals("Stradivari")) {
            return new Sound("Magnificent Sound!", this);
        } else {
            return new Sound("Ok Sound", this);
        }
    }
}
