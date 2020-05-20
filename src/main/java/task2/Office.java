package task2;


import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Office {

	List<OfficeWorker> officeWorkers;
	public Office(Director director, Hr hr, List<OfficeWorker> officeWorkers) {
		this.director = director;
		this.hr = hr;
		this.officeWorkers = officeWorkers;
	}

	// TODO: 5/18/20 эти поля должны получить свои объекты.
	Director director;

	Hr hr;


//	Secretary secretary = (Secretary) director.invite(hr.filterOfficeWorker(officeWorkers));
//	Почему-то в этом местя я ловлю NPE. Хотя если просто выводить на печать выбранного директором секретаря, то он видит этот объект.

	public void listWorkers(){
		System.out.println(director);
		System.out.println(hr);
		//System.out.println(secretary);
		System.out.println(director.invite(hr.filterOfficeWorker(officeWorkers)));
	}

	/*
	Код я причесал, но он мне очень не нравится по той причине, что он перестал быть гибким. Если раньше я все ссылочные
	типы мог указать через общий интерфейс OfficeWorker и мог создать нового офисного работника (например, программиста),
	список которых hr так же предлагал бы директору, то теперь мне нужно для этого писать отдельный метод.
	Получилось так потому, что я ввел критерий отсева. У класса Secretary теперь есть поле skill, по которому hr фильтрует
	кандидатов. И если я на вход метода фильтра работников подам список OfficeWorker'ов, то не смогу вытащить эту переменную, чтобы провести сравнение.

	 */






	//претенденты идут по одному, когда их достаточно,
	// то диретор принимает решение и берет одного в штат

	void invitePeaople(Object human){

	}

}

