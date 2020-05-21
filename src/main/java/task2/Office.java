package task2;


import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Office {

	// TODO: 5/21/20 ну что ж похоже нам предстоит организовать энергичное расширение нашего офиса,
	//  пожалуй не помешает добавить юриста, охранника, и бухгалтеров(в одном офисе 2х с другом 3х).
	public Office(Director director, Hr hr) {
		this.director = director;
		this.hr = hr;
	}

	// TODO: 5/18/20 эти поля должны получить свои объекты.
	Director director;

	Hr hr;


		// TODO: 5/21/20 нет лучшего средства против NPE как дебаг режим
//	Secretary secretary = (Secretary) director.invite(hr.filterOfficeWorker(officeWorkers));
//	Почему-то в этом местя я ловлю NPE. Хотя если просто выводить на печать выбранного директором секретаря, то он видит этот объект.

		public void listWorkers () {
			System.out.println(director);
			System.out.println(hr);


		}







	//претенденты идут по одному, когда их достаточно,
	// то диретор принимает решение и берет одного в штат

	void invitePeaople(Object human){

	}



}

