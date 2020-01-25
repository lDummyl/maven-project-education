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

    public void seeAllSecretaries() {
        java.util.Scanner input = new Scanner(System.in);
        System.out.println(hr.name + ": Посмотрите всех кандидатов?" + System.lineSeparator() + " -Скажите 'Yes' для просмотра всех кандидатов");
        String answer = input.nextLine();
        if (answer.equals("Yes")) {
            System.out.println("Вот все кандидаты:");
            hr.seeAll();
            candidateSelection();
        } else if (answer != "Y") {
            System.out.println(hr.name + ": Прошу прощения, я зайду позже..." + System.lineSeparator() + " -Перезапустите программу");
        }
    }

    public void candidateSelection() {
        Scanner input = new Scanner(System.in);
        System.out.println(director.name + ": Так, сейчас посмотрим кто нам больше всех подходит." + System.lineSeparator() + " -Скажите 'Yes' если думаете что директору кто то понравился");
        String answer = input.nextLine();
        if (answer.equals("Yes")) {
            director.random();
        } else if (answer != "Y") {
            System.out.println("Посмотрю позже... " + System.lineSeparator() + " -Перезапустите программу");
        }
    }


    public void createEmployees() {

        // TODO: 1/23/20 не уверен что ты понимаешь что делаешь
        // TODO: 1/23/20 и знаешь что самое интересное по сути secretaries это один и тот же объект на всех, гляди
        Collection<CompanyEmployees> values = new ArrayList<>(employees.values());
        values.remove(hr);
        values.remove(director);
        for (CompanyEmployees value : values) {
            if (secretaries == value) {
                System.out.println("Its the same object!");
            }
        }
        // TODO: 1/23/20 в данном случае map тебе не нужен. Заведи List с кандидатами в методе main и передавай его в офис.
        //  Где ты видел офис в котором рождаются люди? Они туда приходят извне.
    }


    //Приглашение людей
    void invitePeaople(Object human) {

    }


}
