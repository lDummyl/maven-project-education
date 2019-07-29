package task1;


//задание вывести на печать Hello World 10 раз в одну строчку
// hint: use stream Api

import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		IntStream.range(1, 10).forEach(i -> System.out.print("Hello World"));
	}
}
