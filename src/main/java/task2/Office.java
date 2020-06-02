package task2;


import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Office {

    int requiredQtyOfAccountants =1;
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


    public void setDirector(Director director) {
        this.director = director;
    }

    public void setHr(Hr hr) {
        this.hr = hr;
    }

    public void setSecretaries(Secretary secretary) {
        this.secretaries.add(secretary);
    }

    public void setSecurities(Security security) {
        this.securities.add(security);
    }

    public void setJurists(Jurist jurist) {
        this.jurists.add(jurist);
    }

    public void setAccountants(Accountant accountant) {
        this.accountants.add(accountant);
    }

//    <T extends OfficeWorker> void work(List<? extends T>... tList) {
//        for (int i = 0; i < tList.length; i++) {
//            if (tList[i].get(0) instanceof Secretary) {
//                setSecretaries((Secretary) director.invite(hr.filter(tList[i])));
//            } else if (tList[i].get(0) instanceof Security) {
//                setSecurities((Security) director.invite(hr.filter(tList[i])));
//            } else if (tList[i].get(0) instanceof Jurist) {
//                setJurists((Jurist) director.invite(hr.filter(tList[i])));
//            } else if (tList[i].get(0) instanceof Accountant) {
//                setAccountants((Accountant) director.invite(hr.filter(tList[i])));
//            }
//        }
//    }

    <T extends OfficeWorker> void work(List<? extends T>... tList)  {
        for (int i = 0; i < tList.length; i++) {
            if (tList[i].get(0) instanceof Secretary) {
                secretaries = (List<Secretary>) director.invite(hr.filter(tList[i]), requiredQtyOfSecretary);
            } else if (tList[i].get(0) instanceof Security) {
                securities = (List<Security>) director.invite(hr.filter(tList[i]), requiredQtyOfSecurity);
            } else if (tList[i].get(0) instanceof Jurist) {
                jurists = (List<Jurist>) director.invite(hr.filter(tList[i]), requiredQtyOfJurist);
            } else if (tList[i].get(0) instanceof Accountant) {
                accountants = (List<Accountant>) director.invite(hr.filter(tList[i]), requiredQtyOfAccountants);
            }
        }
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

        void invitePeaople (Object human){
            List<OfficeWorker> officeWorkers = hr.invite(human);
            director.


        // TODO: 5/26/20 офис это простаранство, всю работу в нем делают люди, на чью похожа эта?
            if (human instanceof Secretary) {
                setSecretaries((Secretary) human);
            } else if (human instanceof Security) {
                setSecurities((Security) human);
            } else if (human instanceof Jurist) {
                setJurists((Jurist) human);
            } else if (human instanceof Accountant) {
                setAccountants((Accountant) human);
            }
        }

        void invitePeaople ( int qty, Object ...human){
            for (int i = 0; i < qty; i++) {
                invitePeaople(human[i]);
            }
        }




}

