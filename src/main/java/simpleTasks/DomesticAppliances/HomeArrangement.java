package simpleTasks.DomesticAppliances;

public class HomeArrangement {

    public static void main(String[] args) {
        Refrigerator refrigerator = new Refrigerator("Samsung");
        ElectricityCost pay = refrigerator.consumeElectricity();
        System.out.println(pay);
    }
}
