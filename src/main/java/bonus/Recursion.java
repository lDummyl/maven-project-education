package bonus;

import java.util.ArrayList;
import java.util.List;

public class Recursion {

	private static final String data = "(Level 1 \n" +
			"    (Level 1.1\n" +
			"        (Level 1.1.1)\n" +
			"        (Level 1.1.2)\n" +
			"        (Level 1.1.3)\n" +
			"    )\n" +
			"    (Level 1.2\n" +
			"        (Level 1.2.1)\n" +
			"        (Level 1.2.2)\n" +
			"        (Level 1.2.3)\n" +
			"    )\n" +
			")";


	public static void main(String[] args) {
		String s = data.replaceAll("\n", "").trim();
		System.out.println(s);
		char[] chars = s.toCharArray();
		Data data = createData(chars, 0);
		System.out.println(data);
	}

	private static Data createData(char[] chars, int groupLevel) {
		String name = "";
		Data data = new Data();
		int currentGroupLevel = 0;

		for (int i = 0; i < chars.length; i++) { // не доделал
			char symbol = chars[i];

			if (symbol == '(') {
				currentGroupLevel++;
//			} else if (symbol == ')' && currentGroupLevel == groupLevel) {
//				groupLevel = -1;
			} else if (symbol == ')') {
				currentGroupLevel--;
			}

			if (currentGroupLevel == groupLevel && checkParentheses(symbol)) {
				name += symbol;
			} else if (currentGroupLevel == groupLevel + 1) {
				data.nested.add(createData(chars, currentGroupLevel));
			}
		}
		data.name = new StringBuilder(name.trim());
		data.length = data.name.length();

		return data;
	}

	private static Boolean checkParentheses(char symbol) {
		return symbol != '(' && symbol != ')';
	}
}

class Data {

	StringBuilder name = new StringBuilder();
	int length = 0;
	List<Data> nested = new ArrayList<>();

	@Override
	public String toString() {
		return "Data{" +
				"name=" + name +
//				", length=" + length +
				",\n nested=" + nested +
				'}';
	}
}
