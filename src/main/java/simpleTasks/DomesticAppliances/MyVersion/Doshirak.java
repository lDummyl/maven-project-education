package simpleTasks.DomesticAppliances.MyVersion;

public class Doshirak {
    private  int hotWater;
    public Doshirak(Water hotWater) {
        this.hotWater = 60;  //когда доширак готов, темп понижается до 60
    }

    @Override
    public String toString() {
        return "Your doshirak is ready";
    }
}
