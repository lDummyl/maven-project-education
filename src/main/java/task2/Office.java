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

    public Office(Director director, Hr hr) {
        this.director = director;
        this.hr = hr;
    }

    public Office() {
    }

    List<Secretary> secretaries = new ArrayList();

    List<Security> securities = new ArrayList();

    List<Jurist> jurists = new ArrayList();

    List<Accountant> accountants = new ArrayList();

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setHr(Hr hr) {
        this.hr = hr;
    }

    public void setSecretaries(List<Secretary> secretaries) {
        this.secretaries = secretaries;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }

    public void setJurists(List<Jurist> jurists) {
        this.jurists = jurists;
    }

    public void setAccountants(List<Accountant> accountants) {
        this.accountants = accountants;
    }

    public Director getDirector() {
        return director;
    }

    public void listWorkers(){
            System.out.println(director);
            System.out.println(hr);
            System.out.println(secretaries);
            System.out.println(securities);
            System.out.println(jurists);
            System.out.println(accountants);
        }

        //претенденты идут по одному, когда их достаточно,
        // то диретор принимает решение и берет одного в штат

        void invitePeaople(Object human) {

        }




}

