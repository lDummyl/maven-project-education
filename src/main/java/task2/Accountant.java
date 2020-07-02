package task2;

import task1.Person;

import java.util.ArrayList;
import java.util.List;

public class Accountant extends OfficeWorker{

    private Person person;

    public Accountant(Person person) {
        this.person = person;
    }

    public BankAccount createBankAccount(int sum){
        return new BankAccount(sum);
    }

    public void toPay(BankAccount bankAccount, int price){
        bankAccount.remove(price);
    }

    public int getBalance(BankAccount bankAccount){
      return bankAccount.getSum();
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
