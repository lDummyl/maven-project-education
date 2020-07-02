package task2;

import org.junit.Test;
import task1.PersonProvider;

import java.util.List;

import static org.junit.Assert.*;

public class AccountantTest {

    @Test
    public void createBankAccount() {
        PersonProvider personProvider = new PersonProvider();
        List<Accountant> accountants = personProvider.getSomeAccountants(1);
        BankAccount bankAccount = accountants.get(0).createBankAccount(5000);
        assertNotNull(bankAccount);
        int a = accountants.get(0).getBalance(bankAccount);
        accountants.get(0).toPay(bankAccount, 1000);
        int b = accountants.get(0).getBalance(bankAccount);
        assertTrue(a > b);
        bankAccount.add(500);
        int c = accountants.get(0).getBalance(bankAccount);
        assertTrue(c > b);
    }
}