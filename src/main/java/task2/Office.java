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
    	employees.put("Сandidate1",secretaries);
    	employees.put("Сandidate2",secretaries);
    	employees.put("Сandidate3",secretaries);
    	employees.put("Сandidate4",secretaries);
    	employees.put("Сandidate5",secretaries);
    	employees.put("Сandidate6",secretaries);
    	employees.put("Сandidate7",secretaries);
    	employees.put("Сandidate8",secretaries);
    	employees.put("Сandidate9",secretaries);
    	employees.put("Сandidate10",secretaries);

    }

    public void random2(){
        Random random = new Random();
        List<String> keys = new ArrayList<String>(employees.keySet());
        String randomKey = keys.get(random.nextInt(keys.size()));
        CompanyEmployees value = employees.get(randomKey);
        if(randomKey == director.name){

            System.out.println("I will think more");
        }
        else if(randomKey == hr.name){
            System.out.println("I will think more");
        }
        else {
            System.out.println("I choose a " + randomKey);
        }

    }

    public void random() {

	}
    //Приглашение людей
    void invitePeaople(Object human) {

    }

}
