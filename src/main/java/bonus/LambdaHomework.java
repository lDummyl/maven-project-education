package bonus;

public class LambdaHomework {
    public static void main(String[] args) {

        Calculation calculation1 = (a, b, c) -> a + 1 + b + 1 + c + 1;
        Calculation calculation2 = (a, b, c) -> a*10 + b*10 + c*10;

        int result1 = calculation1.calculate(1,2,3);
        int result2 = calculation2.calculate(1,2,3);
        System.out.println(result1);
        System.out.println(result2);
    }
}

@FunctionalInterface
interface Calculation {
    int calculate(int a, int b, int c);
}