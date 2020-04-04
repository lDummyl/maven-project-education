package simpleTasks.Cosmetics;

public class CosmeticsApplying {
    private Cosmetics cosmetics;
    private String makeUpSatisfaction;

    public CosmeticsApplying(Cosmetics cosmetics, String makeUpSatisfaction) {
        this.cosmetics = cosmetics;
        this.makeUpSatisfaction = makeUpSatisfaction;
    }

    @Override
    public String toString() {
        return "You applied " + cosmetics.getClass().getSimpleName() + ". Your satisfaction after using is " + makeUpSatisfaction;
    }
}
