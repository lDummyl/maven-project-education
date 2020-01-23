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

	    // TODO: 1/23/20 не уверен что ты понимаешь что делаешь
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
	    // TODO: 1/23/20 и знаешь что самое интересное по сути secretaries это один и тот же объект на всех, гляди
	    Collection<CompanyEmployees> values = new ArrayList<>(employees.values());
	    values.remove(hr);
	    values.remove(director);
	    for (CompanyEmployees value : values) {
	    	if(secretaries == value){
			    System.out.println("Its the same object!");
		    }
	    }
	    // TODO: 1/23/20 в данном случае map тебе не нужен. Заведи List с кандидатами в методе main и передавай его в офис.
	    //  Где ты видел офис в котором рождаются люди? Они туда приходят извне.
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
