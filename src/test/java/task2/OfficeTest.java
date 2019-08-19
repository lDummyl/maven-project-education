package task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.Assert.*;

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
    public void newOffices(){

        Office office = new Office();
        ArrayList<Office> additionalOffice = new ArrayList<>();
        ArrayList<Secretary> secretariesWorking = new ArrayList<>();

        ArrayList<Object> secretaries = new ArrayList<>();
        secretaries.add(new Secretary("Маша"));    //создаем секретарей
        secretaries.add(new Secretary("Алла"));
        secretaries.add(new Secretary("Анжелла"));
        secretaries.add(new Secretary("Зина"));
        secretaries.add(new Secretary("Марина"));
        secretaries.add(new Secretary("Лера"));


        for(int i=0; i<5; i++) {
            secretaries.forEach(office::invitePeople);
            secretariesWorking.add(office.secretary);
        }

        assertTrue(secretaries.contains(office.secretary));


        System.out.println(secretariesWorking);


        additionalOffice.add(new Office("Офис №1"));
        additionalOffice.add(new Office("Офис №2"));
        additionalOffice.add(new Office("Офис №3"));

     //   additionalOffice.add(new Office("Офис №1", secretariesWorking.get(0)));
     //  additionalOffice.add(new Office("Офис №2", secretariesWorking.get(1)));
     //   additionalOffice.add(new Office("Офис №3", secretariesWorking.get(2)));


        for(int i=0; i<secretariesWorking.size(); i++) {
            if(i<additionalOffice.size())
            additionalOffice.get(i).workingOffice(secretariesWorking.get(i));
            else
            additionalOffice.get(i-additionalOffice.size()).workingOffice(secretariesWorking.get(i));

        }

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
    public void addAccountant(){

        Office office = new Office();

        ArrayList<Object> laborMarket = new ArrayList<>();
        laborMarket.add(new Secretary("Маша"));    //создаем секретарей
        laborMarket.add(new Secretary("Алла"));
        laborMarket.add(new Secretary("Анжелла"));
        laborMarket.add(new Secretary("Зина"));
        laborMarket.add(new Secretary("Марина"));
        laborMarket.add(new Secretary("Лера"));
        laborMarket.add(new Accountant("Виолетта"));


        laborMarket.forEach(i-> System.out.println(i));

        laborMarket.forEach(office::invitePeople);
        assertTrue(laborMarket.contains(office.secretary));

    }

}