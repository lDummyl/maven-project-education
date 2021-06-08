package task8;

import java.io.File;
import java.io.IOException;
import java.util.List;

/*
	Реализовать пакетный подбор насосов
	создать генератор Josn, который содержит пары расход/напор
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
		List list = requestFactory.getRequestsList(20);
		requestFactory.getRequestListInJSON(file, list);
		List list2 = processingRequest.readJsonFile(file);
		List pumps = processingRequest.getPumps(list2);
		processingRequest.writeToJsonFileSuitablePumps(file2, pumps);

	}

}
