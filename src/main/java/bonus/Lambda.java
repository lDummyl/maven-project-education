package bonus;

import java.util.Arrays;
import java.util.List;


/*Используя данную конструкцию, работая только в методе main вывести на печать
	ABC в строку и в столбик.
 */

public class Lambda {

	public static void main(String[] args) {
		Funkey fun1 = argS -> System.out.println(argS);
		Funkey fun2 = argS -> System.out.print(argS);

		print(fun2);
		System.out.println();
		print(fun1);
	}

	public static void print(Funkey func) {
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
