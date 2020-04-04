package simpleTasks.DomesticAppliances.MyVersion;

public class Kettle extends ElectricDevice {


    public Water boil(Water water) {
        water.temp  = 100;
        return water;
    }
}
