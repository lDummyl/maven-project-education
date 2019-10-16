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
		Data data = createData(chars, 1);
		System.out.println(data);
	}

	private static Data createData(char[] chars, int groupLevel) {
		StringBuilder name = new StringBuilder();
		int currentGroupLevel = 1;

		for (int i = 0; i < chars.length; i++) {
			//...
		}

		return null;
	}

}

class Data {
	StringBuilder name = new StringBuilder();
	int length = 0;
	List<Data> nested = new ArrayList<>();
}
