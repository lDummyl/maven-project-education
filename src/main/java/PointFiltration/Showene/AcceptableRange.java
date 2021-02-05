package PointFiltration.Showene;

public class AcceptableRange<T extends Number> {

    T upperBound;
    T lowerBound;

    public AcceptableRange(T upperBound, T lowerBound) {
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
    }
}
class Numbers{
    Number upperBound;
    Number lowerBond;

    public Numbers(Number upperBound, Number lowerBond) {
        this.upperBound = upperBound;
        this.lowerBond = lowerBond;
    }
}
class Main{
    public static void main(String[] args) {
        Numbers numbers = new Numbers(2,4);
        Numbers numbers1 = new Numbers(5.5,6.5);

        if (false){
            Integer lowerBond = (Integer) numbers1.lowerBond;
            System.out.println(lowerBond);
        }

        AcceptableRange<Double> doubleIntegerAcceptableRange = new AcceptableRange<>(3.0, 4.0);
        AcceptableRange<Double> doubleAcceptableRange = new AcceptableRange<>(5.0, 10.0);
        Double lowerBound = doubleAcceptableRange.lowerBound;

    }
}