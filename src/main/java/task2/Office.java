package task2;

import java.util.*;

public class Office {

	/*
	Secretary secretary;

	Director director;

	Hr hr;
	*/

    //претенденты идут по одному, когда их достаточно,
    // то диретор принимает решение и берет одного в штат

    Map<String, CompanyEmployees> employees = new HashMap<>();

    Secretaries secretaries = new Secretaries();
    Director director = new Director("Big Boss");
    HR hr = new HR("Elena");

    public void createEmployees() {
    	employees.put(director.name, director);
    	employees.put(hr.name, hr);

    }

    public void random2(){
        Random random = new Random();
        List<String> keys = new ArrayList<String>(employees.keySet());
        String randomKey = keys.get(random.nextInt(keys.size()));
        CompanyEmployees value = employees.get(randomKey);
        System.out.println(randomKey);
    }

    public void random() {

	}
    //Приглашение людей
    void invitePeaople(Object human) {

    }

}
