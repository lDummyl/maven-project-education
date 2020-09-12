package bonus;

import java.util.Arrays;
import java.util.List;


/*Используя данную конструкцию, работая только в методе main вывести на печать
	ABC в строку и в столбик.
 */

public class Lambda {


    public static void main(String[] args) {

        Funkey fun = System.out::println;
        test(fun);
        Funkey fun2 = System.out::print;
        test(fun2);
    }

    public static void test(Funkey func) {
        List<String> strings = Arrays.asList("A", "B", "C");
        for (String string : strings) {
            func.print(string);
        }
    }
}

@FunctionalInterface
interface Funkey {
    void print(String s);
}


