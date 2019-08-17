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

        ArrayList<Object> secretaries = new ArrayList<>();
        secretaries.add(new Secretary("Маша"));    //создаем секретарей
        secretaries.add(new Secretary("Алла"));
        secretaries.add(new Secretary("Анжелла"));
        secretaries.add(new Secretary("Зина"));
        secretaries.add(new Secretary("Марина"));
        secretaries.add(new Secretary("Лера"));

        secretaries.forEach(office::invitePeople);
        assertTrue(secretaries.contains(office.secretary));

        Stream stream = secretaries.stream();
        Stream stream2 = secretaries.stream();
        Stream stream3 = secretaries.stream();

        stream.limit(2).forEach(x -> additionalOffice.add(new Office("Офис №1" ,x)));            //возвращает первые два элемента
        stream2.skip(2).limit(2).forEach(y -> additionalOffice.add(new Office("Офис №2" ,y)));   //возвращает два элемента начиная со второго
        stream3.skip(4).forEach(z -> additionalOffice.add(new Office("Офис №3" ,z)));            //возвращает возвращает все элементы после четвертого


        for(int i=0; i<additionalOffice.size(); i++)
            additionalOffice.get(i).workingOffice();



    }

}