package task2;

// Сделать 10 секретарей 1 HR и директора, который
// произвольно выбирает секретаря из предложенных отделом кадров,
// все это происходит в офисе

import java.util.Random;

public class Main {
	public static void main(String[] args) {

	}
	static class GenerateRandom {
		public void random_number() {
			Random rand = new Random(); //instance of random class
			int upperbound = 5;
			//generate random values from 1-5
			int int_random = rand.nextInt(upperbound);
			double double_random = rand.nextDouble();
			float float_random = rand.nextFloat();
		}
	}
}