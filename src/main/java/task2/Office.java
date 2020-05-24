package task2;


import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Office {

	// TODO: 5/21/20 ну что ж похоже нам предстоит организовать энергичное расширение нашего офиса,
	//  пожалуй не помешает добавить юриста, охранника, и бухгалтеров(в одном офисе 2х с другом 3х).

	Director director;

	Hr hr;

	List<Secretary> secretaries;

	List<Security> securities;

	List<Jurist> jurists;

    List<Accountant> accountants;



    public void setDirector(Director director) {
        this.director = director;
    }

    public void setHr(Hr hr) {
        this.hr = hr;
    }

    public void setSecretaries(Secretary secretary) {
        this.secretaries.add(secretary);
    }

    public void setSecurities(Security security) {
        this.securities.add(security);
    }

    public void setJurists(Jurist jurist) {
        this.jurists.add(jurist);
    }

    public void setAccountants(Accountant accountant) {
        this.accountants.add(accountant);
    }

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
        if(human instanceof Secretary){
            setSecretaries((Secretary) human);
        }else if (human instanceof Security){
            setSecurities((Security) human);
        }else if (human instanceof Jurist) {
            setJurists((Jurist) human);
        }else if (human instanceof Accountant) {
            setAccountants((Accountant) human);
        }
	}



}

