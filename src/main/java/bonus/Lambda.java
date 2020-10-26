package bonus;

import java.util.Arrays;
import java.util.List;


/*Используя данную конструкцию, работая только в методе main вывести на печать
	ABC в строку и в столбик.
 */

public class Lambda {


	public static void main(String[] args) {


		// TODO: 10/26/20 доп. вывести CBA только 1 раз. Не важно как но не меняя кода нигде кроме лямбды. Задачка с подвохом так что думай out of the box.
		//  добавить дженерик в Funkey. Создать 3 новых интерфейса и методы TestDigits в нем коллекциями чисел. Через новые интрефейсы получить сумму,
		//  получить перевернутую колелекцию, только простые числа строкой через запятую.
		Funkey funHor = (s -> System.out.print(s));
		Funkey funVert = (s -> System.out.println(s));
		test(funHor);
		System.out.println(" ");
		test(funVert);

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


