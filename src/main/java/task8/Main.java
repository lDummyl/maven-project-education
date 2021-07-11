package task8;

import task10.Statistics;
import java.io.File;
import java.io.IOException;
import java.time.Month;
import java.util.List;
import java.util.Map;

/*
	Реализовать пакетный подбор насосов
	создать генератор JSON, который содержит пары расход/напор
	принимать его на вход и выдавать json в виде отчета: насос, входные параметры,
	рабочая точка модель, первый технический блок
	второй блок коммерческий, список уникальных моделей, их количество цена за штуку/сумму
	плюс всего за предложение, с доставкой(отдельно) 10% от стоимости, при стоиомсти выше 10 000
	доставка бесплатно.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		RequestFactory requestFactory = new RequestFactory();
		File file = new File("C:\\Users\\Krugl\\IdeaProjects\\maven-project-education\\requests.json");
		File file2 = new File("C:\\Users\\Krugl\\IdeaProjects\\maven-project-education\\suitablePumps.json");
		ProcessingRequest processingRequest = new ProcessingRequest();
		Statistics statistics = new Statistics();
		List <Request> requests = requestFactory.getRequestsList(100);
		requestFactory.getRequestListInJSON(file, requests);
		List <Request> list2 = processingRequest.readJsonFile(file);
		List <Offer> suitablePumps = processingRequest.getOffers(list2);
		processingRequest.writeToJsonFileOffers(file2, suitablePumps);
		List <Offer> offers = statistics.readOffers(file2);
		Map<Month, Integer> statisticPerMonth = statistics.qtyPurchasesPerMonth(offers);
		statisticPerMonth.forEach((m, i) -> System.out.println("Month: " + m + " Quantity of purchases: " + i));
		Map <Integer, Integer> statisticPerYear = statistics.qtyPurchasesPerYear(offers);
		statisticPerYear.forEach((y, i) -> System.out.println("Year = " + y + " Quantity of purchases: " + i));
		Map <Month, Integer> errors = statistics.qtyErrorsPerMonth(offers);
		errors.forEach((y, i) -> System.out.println("Month = " + y + " Quantity of errors: " + i));
		System.out.println(new Sales().deliveryCost(offers));

	}

}
