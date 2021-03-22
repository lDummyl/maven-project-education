package bonus;

// TODO: 1/26/20 Заменить все артикли "а" кроме первого и последнего, заменять следует только артикли
//  буквы "а" в составе слов замене не подлежат.


import java.util.Deque;
import java.util.LinkedList;

public class ArticleReplacement {

	public static void main(String[] args) {

		String s = "a creature is a  small part of a big world";
		String a = "a";
		String b = "the";
		String[] words = s.split(" ");
		Deque<Integer> targetIndexes = new LinkedList<>();
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(a)) {
				targetIndexes.add(i);
			}
		}
		targetIndexes.pollFirst();
		targetIndexes.pollLast();
		for (Integer targetIndex : targetIndexes) {
			words[targetIndex] = b;
		}
		String result = String.join(" ", words);
		System.out.println(result);

	}
}
