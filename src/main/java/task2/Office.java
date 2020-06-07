package task2;


import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Office {

    int requiredQtyOfAccountants;
    int requiredQtyOfJurist;
    int requiredQtyOfSecretary;
    int requiredQtyOfSecurity;

    // TODO: 5/21/20 ну что ж похоже нам предстоит организовать энергичное расширение нашего офиса,
    //  пожалуй не помешает добавить юриста, охранника, и бухгалтеров(в одном офисе 2х с другом 3х).

    Director director;

    Hr hr;

    public Office(Director director, Hr hr, int requiredQtyOfSecretary, int requiredQtyOfSecurity,
                  int requiredQtyOfJurist, int requiredQtyOfAccountants) {
        this.requiredQtyOfAccountants = requiredQtyOfAccountants;
        this.requiredQtyOfJurist = requiredQtyOfJurist;
        this.requiredQtyOfSecretary = requiredQtyOfSecretary;
        this.requiredQtyOfSecurity = requiredQtyOfSecurity;
        this.director = director;
        this.hr = hr;
    }

    public Office(Director director, Hr hr, int requiredQtyOfAccountants) {
       this(director,hr, 1,1,1,requiredQtyOfAccountants);
    }

    List<Secretary> secretaries = new ArrayList();

    List<Security> securities = new ArrayList();

    List<Jurist> jurists = new ArrayList();

    List<Accountant> accountants = new ArrayList();

    List<? extends OfficeWorker> officeWorkers = new ArrayList();

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setHr(Hr hr) {
        this.hr = hr;
    }

//    public void setSecretaries(Secretary secretary) {
//        this.secretaries.add(secretary);
//    }
//
//    public void setSecurities(Security security) {
//        this.securities.add(security);
//    }
//
//    public void setJurists(Jurist jurist) {
//        this.jurists.add(jurist);
//    }
//
//    public void setAccountants(Accountant accountant) {
//        this.accountants.add(accountant);
//    }

    public void setSecretaries(List<Secretary> secretaryList, int requiredQtyOfSecretary){
        this.secretaries = director.invite(hr.filter(secretaryList), requiredQtyOfSecretary);
    }

    public void setSecurities(List<Security> securityList, int requiredQtyOfSecurity){
        this.securities = director.invite(hr.filter(securityList), requiredQtyOfSecurity);
    }

    public void setJurists(List<Jurist> juristList, int requiredQtyOfJurist){
        this.jurists = director.invite(hr.filter(juristList), requiredQtyOfJurist);
    }

    public void setAccountants(List<Accountant> accountantList, int requiredQtyOfAccountants){
        this.accountants = director.invite(hr.filter(accountantList), requiredQtyOfAccountants);
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

