package simpleTasks.Cosmetics;

public class CosmeticsApplying { // TODO: 4/5/20 транные промежуточные классы, опять не абстрактыные, и не ясно зачем.
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
