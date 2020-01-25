package task2;

import java.util.Scanner;

public class HR extends CompanyEmployees {

    Secretaries secretaries = new Secretaries();


    public HR(String name) {
        this.name = name;
    }
    public void seeAllSecretaries (){
        System.out.println("Посмотрите всех кандидатов");
    }


    public void seeAll() {
        secretaries.createEmpl();

        for (String s : secretaries.empl) {
            System.out.println(s);
        }


    }
}

