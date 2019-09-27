package task2;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class OfficeTest {

    @Test
    public void testOk() {
        Office office = new Office();

        ArrayList<Object> secretaries = new ArrayList<>();
        secretaries.add(new Secretary("Маша"));    //создаем секретарей
        secretaries.add(new Secretary("Алла"));
        secretaries.add(new Secretary("Анжелла"));
        secretaries.add(new Secretary("Зина"));
        secretaries.add(new Secretary("Марина"));
        secretaries.add(new Secretary("Лера"));

        secretaries.forEach(office::invitePeople);
        assertTrue(secretaries.contains(office.secretary));

    }

    @Test
    public void passEmptyList() {
        Office office = new Office();
        ArrayList<Object> secretaries = new ArrayList<>();

        secretaries.forEach(office::invitePeople);
        assertEquals(null, office.secretary);

    }

    // TODO: 9/4/19 отлично! Осталось только починить этот тест и порядок

    @Test(expected = RuntimeException.class)
    public void getBossAnger() {
        Office office = new Office();
        ArrayList<Object> secretaries = new ArrayList<>();

        for (int i = 0; i < 6; i++)                       //создаем 6 кандидатов жилающих работать, но е совсем секретарей
            secretaries.add(new WantAWork() {
                @Override
                public boolean passInterview() {
                    return true;                         //возвращаем положительный результат прохождения интерьвью у Hr
                }
                @Override
                public boolean isHired() {
                    return false;                         //возвращаем положительный результат прохождения интерьвью у Hr
                }

            });

        secretaries.forEach(office::invitePeople);

    }

    @Test
    public void mainTest() {
        String test = "Main question of the universe and everything";
        //       int result = new SuperComPuter.ask(test);
        //       assertEquals(42, result);
    }


    @Test
    public void multipleOfficeTest100Iterations() {

        for (int i = 0; i < 100; i++) {
            multipleOfficeTest();
        }
    }

// TODO: 9/4/19 вот тебе готовый тест, не изменяя его нужно  сделать так чтобы он проходил.
    // TODO: 9/12/19 уже лучше, но попробуй теперь с новыми данными

    public void multipleOfficeTest() {

        List<Object> labourMarket = getLabourMarket();
        Set<Office> offices = Stream.generate(Office::new).limit(3).collect(Collectors.toSet());

        HashSet<Object> alreadySaw = new HashSet<>();

        for (Office office : offices) {
            for (Object candidate : labourMarket) {
                office.invitePeople(candidate);
            }

            Secretary secretary = office.secretary;
            assertNotNull(secretary);
            assertFalse(alreadySaw.contains(secretary));
            alreadySaw.add(secretary);
            Accountant accountant = office.accountant;
            assertNotNull(accountant);
            assertFalse(alreadySaw.contains(accountant));
            alreadySaw.add(accountant);
        }
    }


    @Test
    public void newOffices() {

        Office office = new Office();

        ArrayList<Object> secretaries = new ArrayList<>();
        secretaries.add(new Secretary("Маша"));    //создаем секретарей
        secretaries.add(new Secretary("Алла"));
        secretaries.add(new Secretary("Анжелла"));
        secretaries.add(new Secretary("Зина"));
        secretaries.add(new Secretary("Марина"));
        secretaries.add(new Secretary("Лера"));

        Office additionalOffice1 = new Office("Офис №1");

        secretaries.forEach(office::invitePeople);

        Secretary secretary = office.secretary;
        //  boolean isWorking = secretary.office != null;
        boolean isWorking = secretary.hired;

        if (isWorking) {
            secretary.office = additionalOffice1;
        }

        //     Office wockingIn = secretary.office;

        assertTrue(secretaries.contains(office.secretary));  // не очень понимаю какая здесь должна быть проверка

        // TODO: 8/16/19 способ 2
        //    long offices1qty = additionalOffice.stream().filter(off -> off.nameOffice.equals("Офис №1")).count();
        //    assertThat("Offices 1 qty", offices1qty, lessThan(2L));

    }


    @Test
    public void addAccountantStress() {

        for (int i = 0; i < 10000; i++) {
            try {
                addAccountant();
            } catch (Exception e) {
                e.printStackTrace();
                String message = e.getMessage();
                assertFalse(message.contains(new Office().hr.name));
            }

        }
    }

    // TODO: 8/29/19 айайай а тестик то падает время от времени, директор ругается, лучше путь hr подготовиться, отсортирует всех кандидатов, разложит по папочкам у себя в картотеке и тогда дирктору проще будет, чем если ему все на стол просто вывалено

    @Test
    public void addAccountant() {

        Office office = new Office();

        List<Object> laborMarket = getLabourMarket();
        laborMarket.forEach(office::invitePeople);


        Secretary secretary = office.secretary;;
        Accountant accountant = office.accountant;

        System.out.println(secretary);
        System.out.println(accountant);

        assertTrue(laborMarket.contains(office.accountant));
    }

    private List<Object> getLabourMarket() {
        List<Object> laborMarket = new ArrayList<>();
        laborMarket.add(new Secretary("Маша"));
        laborMarket.add(new Secretary("Алла"));
        laborMarket.add(new Secretary("Анжелла"));
        laborMarket.add(new Secretary("Зина"));
        laborMarket.add(new Secretary("Марина"));
        laborMarket.add(new Sluggard());
        laborMarket.add(new Sluggard());
        laborMarket.add(new Sluggard());
        laborMarket.add(new Sluggard());
        laborMarket.add(new Sluggard());
        laborMarket.add(new Sluggard());
        laborMarket.add(new Sluggard());
        laborMarket.add(new Sluggard());
        laborMarket.add(new Sluggard());
        laborMarket.add(new Sluggard());
        laborMarket.add(new Sluggard());
        laborMarket.add(new Sluggard());
        laborMarket.add(new Sluggard());
        laborMarket.add(new Sluggard());
        laborMarket.add(new Sluggard());
        laborMarket.add(new Sluggard());
        laborMarket.add(new Sluggard());
        laborMarket.add(new Sluggard());
        laborMarket.add(new Accountant("Виолетта"));
        laborMarket.add(new Accountant("Фекла"));
        laborMarket.add(new Accountant("Фекла1"));
        laborMarket.add(new Accountant("Фекла2"));
        laborMarket.add(new Accountant("Фекла3"));

        laborMarket.add(new Accountant("Фекла4"));
        laborMarket.add(new Accountant("Фекла5"));
        laborMarket.add(new Accountant("Фекла6"));
        laborMarket.add(new Accountant("Фекла7"));

        Collections.shuffle(laborMarket);
        return laborMarket;
    }

}
class Sluggard implements WantAWork{

    @Override
    public boolean passInterview() {
        return true;
    }
    public boolean isHired(){
        return false;
    }
}