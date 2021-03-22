package bonus;

import java.util.ArrayList;
import java.util.Arrays;
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
		Data data = createData(chars);
		System.out.println(data);
	}

	private static Data createData(char[] chars) {
		Data result = new Data();
		for (int i = 1; i < chars.length; i++) {
			result.length++;
			if (chars[i] == ')') {
				return result;
			}
			if (chars[i] == '(') {
				Data data = createData(Arrays.copyOfRange(chars, i, chars.length));
				i += data.length;
				result.length += data.length;
				result.nested.add(data);
			} else result.name.append(chars[i]);
		}
		return result;
	}

}

class Data {
	StringBuilder name = new StringBuilder();
	int length = 0;
	List<Data> nested = new ArrayList<>();
}
