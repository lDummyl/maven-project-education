package bonus;

import java.util.Arrays;
import java.util.List;


/*Используя данную конструкцию, работая только в методе main вывести на печать
	ABC в строку и в столбик.
 */

public class Lambda {

	String print;

	void print(String a){
		System.out.println();
	}


	public void main(String[] args) {

		Funkey fun1 = argS -> System.out.println(argS);
		Funkey fun2 = argS -> System.out.print(argS);
		Funkey fun = this::print;
		test(fun);

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


