package task6;

/*
	Реализовать алгоритм интерполяционного многочлена Лагранжа
	по данной ссылке использовать реализацию C# и адаптировать ее в синтаксис Java
	https://ru.wikibooks.org/wiki/%D0%A0%D0%B5%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D0%B8_%D0%B0%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC%D0%BE%D0%B2/%D0%98%D0%BD%D1%82%D0%B5%D1%80%D0%BF%D0%BE%D0%BB%D1%8F%D1%86%D0%B8%D1%8F/%D0%9C%D0%BD%D0%BE%D0%B3%D0%BE%D1%87%D0%BB%D0%B5%D0%BD_%D0%9B%D0%B0%D0%B3%D1%80%D0%B0%D0%BD%D0%B6%D0%B0

 */

public class Main {
    public static void main(String[] args) {
        final int size = 10;
        double[] xValues = new double[size];
        double[] yValues = new double[size];

        for (int i = 0; i < size; i++) {
            xValues[i] = i;
            yValues[i] = testF(i);
        }
        System.out.println(interpolateLagrangePolynomial(13.6, xValues, yValues, size));
    }

    public static double interpolateLagrangePolynomial(double x, double[] xValues, double[] yValues, int size) {
        double lagrangePol = 0;
        for (int i = 0; i < size; i++) {
            double basicsPol = 1;
            for (int j = 0; j < size; j++) {
                if (j != i)
                    basicsPol *= (x - xValues[j]) / (xValues[i] - xValues[j]);
            }
            lagrangePol += basicsPol * yValues[i];
        }
        return lagrangePol;
    }

    public static double testF(double x) {
        return x * x * x + 3 * x * x + 3 * x + 1;
    }
}
