package newpumpbutchselector;

public class ReportProvider {
    PumpResponseProvider responseProvider;
    CommercialBLockProvider commercialBLockProvider;

    public ReportProvider() {
        this.commercialBLockProvider = new CommercialBLockProvider();
    }


}
