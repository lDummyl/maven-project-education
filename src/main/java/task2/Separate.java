package task2;

import java.util.ArrayList;
import java.util.List;

public class Separate {


    public static void main(String[] args) {
        List<CompanyEmployee> companyEmployees = new ArrayList<>();
        Secretary secretary = new Secretary("Vera");
        Loader loader = new Loader("Zhora");
        companyEmployees.add(secretary);
        companyEmployees.add(loader);

        distinct(companyEmployees);


    }

    private static void distinct(List<CompanyEmployee> companyEmployee) {
        // сигнатура метода distinct(List objects)
        // название метода distinct
        // аргументы (List objects)

        CompanyEmployee o = companyEmployee.get(0);
        if (o instanceof Secretary){
            Secretary sec = (Secretary) o;
            sec.makeSomeCoffee();
        }
        if (o instanceof Loader){
            Loader loader = (Loader) o;
            System.out.println(loader.toString());
        }


    }
}
