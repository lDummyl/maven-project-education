package bonus;

import java.util.Arrays;
import java.util.List;


/*Используя данную конструкцию, работая только в методе main вывести на печать
	ABC в строку и в столбик.
 */

public class Lambda {


	public static void main(String[] args) {
		Funkey fun3 = s -> s + "hohoho"  ;

		Funkey fun2 = s -> {
			System.out.println("hohoho!");
			System.out.println(s);
			return "123";
		}   ;

		Funkey fun =(String s) -> {
			System.out.println("hohoho!");
			System.out.println(s);
			return "123";
		}   ;

		Funkey fun1 = new Funkey() {
			@Override
			public String print(String s) {
				System.out.println("s = " + s);
				return null;
			}
		};
		test(fun1);


	}

	public static void test(Funkey func) {
		List<String> strings = Arrays.asList("A", "B", "C");
		for (String string : strings) {
			String print = func.print(string);
			System.out.println("print = " + print);
		}
	}

	public static void testNum(Funkey func) {
		List<Integer> strings = Arrays.asList(1, 2, 3);
		int result  = 0;
		for (int i : strings) {
		//	result += func.add1(i);
 		}
		System.out.println("result = " + result);
	}
}

@FunctionalInterface
interface Funkey {
	 String print(String s) ;
}


