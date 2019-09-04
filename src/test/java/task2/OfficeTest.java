package task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
        Office additionalOffice2 = new Office("Офис №2");
        Office additionalOffice3 = new Office("Офис №3");

        secretaries.forEach(office::invitePeople);

        Secretary secretary = office.secretary;
        //  boolean isWorking = secretary.office != null;
        boolean isWorking = secretary.isWorking;

        if (isWorking) {
            secretary.office = additionalOffice1;
        }

        //     Office wockingIn = secretary.office;

        assertTrue(secretaries.contains(office.secretary));  // не очень понимаю какая здесь должна быть проверка

/*
      Office offissNuber1 = null;
        for (int i = 0; i < additionalOffice.size(); i++) {
            Office offiss = additionalOffice.get(i);
            offiss.workingOffice();
            // TODO: 8/16/19 что-то не так способ 1
            if (offiss.nameOffice.equals("Офис №1")) {
                if (offissNuber1 == null) {
                    offissNuber1 = offiss;
                    System.out.println("offissNuber1 = " + offissNuber1 + "offiss = " + offiss);
                } else {
                    if (!offiss.equals(offissNuber1)) {
                        System.out.println("как это офис 1 уже есть, не не равен офису 1, ¯\\_(ツ)_/¯");
                        System.out.println("(2)offissNuber1 = " + offissNuber1 + "(2)offiss = " + offiss);
                        assertTrue(offiss.equals(offissNuber1));
                    }
                }
            }
        }

 */
        // TODO: 8/16/19 способ 2
        //    long offices1qty = additionalOffice.stream().filter(off -> off.nameOffice.equals("Офис №1")).count();
        //    assertThat("Offices 1 qty", offices1qty, lessThan(2L));


   /*     Stream stream = secretariesWorking.stream();
        Stream stream2 = secretaries.stream();
        Stream stream3 = secretaries.stream();

        stream.limit(2).forEach(x -> additionalOffice.add(new Office("Офис №1" ,x)));            //возвращает первые два элемента
        stream2.skip(2).limit(2).forEach(y -> additionalOffice.add(new Office("Офис №2" ,y)));   //возвращает два элемента начиная со второго
        stream3.skip(4).forEach(z -> additionalOffice.add(new Office("Офис №3" ,z)));            //возвращает возвращает все элементы после четвертого
    */

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

        ArrayList<Object> laborMarket = new ArrayList<>();
        laborMarket.add(new Secretary("Маша"));
        laborMarket.add(new Secretary("Алла"));
        laborMarket.add(new Secretary("Анжелла"));
        laborMarket.add(new Secretary("Зина"));
        laborMarket.add(new Secretary("Марина"));
        laborMarket.add(new Secretary("Лера"));
        laborMarket.add(new Accountant("Виолетта"));
        laborMarket.add(new Accountant("Фекла"));
        laborMarket.add(new Accountant("Фекла1"));
        laborMarket.add(new Accountant("Фекла2"));
        laborMarket.add(new Accountant("Фекла3"));
        Collections.shuffle(laborMarket);
        laborMarket.forEach(office::invitePeople);


        Secretary secretary = office.secretary;;
        Accountant accountant = office.accountant;

        System.out.println(secretary);
        System.out.println(accountant);

        //  assertTrue(laborMarket.contains(office.secretary));
        assertTrue(laborMarket.contains(office.accountant));
    }

}