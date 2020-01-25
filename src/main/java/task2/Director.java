package task2;

import java.util.Random;

public class Director extends CompanyEmployees {

    Secretaries secretaries = new Secretaries();

    public Director (String name){
        this.name = name;
    }
    public void random() {
        Random rand = new Random();
        secretaries.createEmpl();
        String randomKey2 = secretaries.empl.get(rand.nextInt(secretaries.empl.size()));
        System.out.print(name +": Что-ж, я выбираю - ");
        System.out.println(randomKey2);

    }
}
