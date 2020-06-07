package task2;

import task1.Person;

import java.util.ArrayList;
import java.util.List;

public class Accountant extends OfficeWorker{

    private Person person;

    List<BankAccount> bankAccounts = new ArrayList<>();

    public Accountant(Person person) {
        this.person = person;
    }

    public void createBankAccount(int sum){
        bankAccounts.add(new BankAccount(sum));
    }

    public void toPay(int numberBankAccount, int price){
        bankAccounts.get(numberBankAccount).remove(price);
    }

    @Override
    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Accountant{" +
                person +
                '}';
    }
}
