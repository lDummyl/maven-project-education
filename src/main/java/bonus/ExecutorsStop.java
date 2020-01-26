package bonus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

/*Способы корректной остановки пула потоков и их особенности
 * Задача заключается в том чтобы main method закончился только после заврешния работы всех потоков,
 * если же по прошествии заданного таймаута потоки еще не завершили работу, положить все потоки и выйти из метода
 * броском эксепшена (по завершении красная кнопка стоп гореть не должна)*/

public class ExecutorsStop {


	/**
	 * Если учитывать риск того что какой-то поток может не остановиться совсем.
	 */
	public static void main(String[] args) throws InterruptedException, TimeoutException {

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			executorService.submit(() -> runForever());
		}
		// TODO: 1/23/20 put code here
		System.out.println("Main done!");

	}

	/**
	 * Ждем до последнего.
	 */
	public static void main2(String[] args) throws InterruptedException {

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		List<Callable<Object>> tasks = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Runnable runnable = () -> run();
			// TODO: 1/23/20 put code here
		}
		// TODO: 1/23/20 and here
		System.out.println("Main done!");

	}

	private static void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread() + "Done!");
	}

	private static void runForever() {
		try {
			while (true) {
				Thread.sleep(10000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
