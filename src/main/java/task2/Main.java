package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    // TODO: 26.01.2020 устроить в штат охранника, Юриста и бухгалтера
    public static void main(String[] args) {
        Random random = new Random();
        List<String> names = Arrays.asList("Masha", "Katya", "Zina");
        List<Secretary> candidates = new ArrayList<>();

        List<String> names2 = Arrays.asList("Marina", "Katerina", "Zinaida", "Aida", "Nikolay", "Anton", "Maxim", "Semen");
        List<String> surname = Arrays.asList("A.", "B.", "C.", "D.", "E.", "F.", "G.", "H.");
        List<Loader> candidates3 = new ArrayList<>();

        for (int i = 0; i < 20; i++) {

            Secretary secretary = new Secretary(names.get(random.nextInt(names.size())) + i);
            candidates.add(secretary);
            String s = surname.get(random.nextInt(surname.size()));
            Loader loader = new Loader(s + names2.get(random.nextInt(names2.size())));
            candidates3.add(loader);
        }
        List<CompanyEmployee> companyEmployees = new ArrayList<>();
        companyEmployees.addAll(candidates);
        companyEmployees.addAll(candidates3);

        Office office = new Office();

        for (CompanyEmployee companyEmployee : companyEmployees) {
            office.invite(companyEmployee);
        }


        Secretary secretary = office.secretary;
        Loader loader = office.loader;
        AllCandidate allCandidate = office.allCandidate;


        System.out.println("secretary = " + secretary);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Candidate = " + allCandidate);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Грузчик = " + loader );


    }
}


