package simpleTasks.DomesticAppliances.MyVersion;

public class Kitchen {

    public static void main(String[] args) {
        Kettle kettle = new Kettle();
        kettle.size = new Size(20,20,20);

        System.out.println(kettle.powerConsumption = new PowerConsumption(0.2));

        Water hotWater = kettle.boil(new Water(10));
        Doshirak doshirak = new Doshirak(hotWater);
        System.out.println(doshirak);

        Program voiceCommand = new Program("Switch on porridge");
        Multivarka multivarka = new Multivarka(voiceCommand);
        multivarka.executeProgram();
    }
}
