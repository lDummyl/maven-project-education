package task1.controller;

import task1.service.PersonAnalyzer;
import task1.util.NameGenerator;
import task1.util.PersonGenerator;

public class Main {

    public static void main(String[] args) {
        PersonAnalyzer pa = new PersonAnalyzer();

        System.out.println(pa.getOldest(new PersonGenerator().generate()));
        System.out.println(pa.getRandomPersonsList(new NameGenerator().generate()));
    }

}

