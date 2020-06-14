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

    int requireOfSecretary;
    int requireOfSecurity;
    int requireOfJurist;
    int requireOfAccountant;

    public Office(Director director, Hr hr, int requireOfSecretary, int requireOfSecurity, int requireOfJurist,
                  int requireOfAccountant, List<? extends OfficeWorker> allCandidates) {
        this.director = director;
        this.hr = hr;
        this.requireOfSecretary = requireOfSecretary;
        this.requireOfSecurity = requireOfSecurity;
        this.requireOfJurist = requireOfJurist;
        this.requireOfAccountant = requireOfAccountant;
        this.hr.filter(allCandidates);
    }

    List<Secretary> secretaries = new ArrayList<>();
    List<Security> securities = new ArrayList<>();
    List<Jurist> jurists = new ArrayList<>();
    List<Accountant> accountants = new ArrayList<>();

    List<BankAccount> bankAccounts = new ArrayList<>();

    public void init(){
        secretaries = director.invite(hr.approvedSecretary, requireOfSecretary);
        securities = director.invite(hr.approvedSecurity, requireOfSecurity);
        jurists = director.invite(hr.approvedJurist, requireOfJurist);
        accountants = director.invite(hr.approvedAccountant, requireOfAccountant);
    }
    // TODO: 6/11/20 убери все эти сеттеры они тебе не нужны на данном этапе

    // TODO: 6/11/20 тогда тут все делают свою офисную работу секретари варят, юристы судятся, бухгалтеры сводят баланс
    public void work(int colorNail, OfficeWorker pal, int toPay){
        secretaries.get(0).changeColorNail(colorNail);
        System.out.println(secretaries.get(0).getColorNail());
        securities.get(0).speakWithSomeone(pal);
        jurists.get(0).sue();
        bankAccounts.add(accountants.get(0).createBankAccount(50000));
        for (Accountant accountant : accountants) {
            accountant.toPay(bankAccounts.get(0), 500);
        }
        System.out.println(accountants.get(1).getBalance(bankAccounts.get(0)));
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

