package task2;


import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Office {

    Director director;

    Hr hr;

    final int requireOfSecretary = 1;
    final int requireOfSecurity = 1;
    final int requireOfJurist = 1;
    final int requireOfAccountant;

    final int qtyApproveCandidates = 10;
    List<OfficeWorker> allCandidates = new ArrayList<>();

    public Office(Director director, Hr hr, int requireOfAccountant) {
        this.director = director;
        this.hr = hr;
        this.requireOfAccountant = requireOfAccountant;
    }

    public Office(Director director, Hr hr) {
        this.director = director;
        this.hr = hr;
        this.requireOfAccountant = 1;
    }

    public Office(Director director, Hr hr, int requireOfAccountant, List<OfficeWorker> allCandidates) {
        this.director = director;
        this.hr = hr;
        this.requireOfAccountant = requireOfAccountant;
        this.allCandidates = allCandidates;
    }

    List<Secretary> secretaries = new ArrayList<>();
    List<Security> securities = new ArrayList<>();
    List<Jurist> jurists = new ArrayList<>();
    List<Accountant> accountants = new ArrayList<>();
    List<BankAccount> bankAccounts = new ArrayList<>();

    public void init() {
        secretaries = director.invite(hr.approvedSecretary, requireOfSecretary);
        securities = director.invite(hr.approvedSecurity, requireOfSecurity);
        jurists = director.invite(hr.approvedJurist, requireOfJurist);
        accountants = director.invite(hr.approvedAccountant, requireOfAccountant);
    }

    // TODO: 6/11/20 тогда тут все делают свою офисную работу секретари варят, юристы судятся, бухгалтеры сводят баланс
    public void work(int colorNail, OfficeWorker pal, int toPay) {
        secretaries.get(0).changeColorNail(colorNail);
        System.out.println(secretaries.get(0).getColorNail());
        securities.get(0).speakWithSomeone(pal);
        jurists.get(0).sue();
        bankAccounts.add(accountants.get(0).createBankAccount(50000));
        for (Accountant accountant : accountants) {
            accountant.toPay(bankAccounts.get(0), toPay);
        }
        System.out.println(accountants.get(1).getBalance(bankAccounts.get(0)));
    }

    public void listWorkers() {
        System.out.println(director);
        System.out.println(hr);
        System.out.println(secretaries);
        System.out.println(securities);
        System.out.println(jurists);
        System.out.println(accountants);
    }

    //претенденты идут по одному, когда их достаточно,
    // то диретор принимает решение и берет одного в штат

    void invitePeople(Object human) {
            hr.invite(human);
    }


}

