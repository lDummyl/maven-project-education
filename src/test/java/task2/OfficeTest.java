package task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class OfficeTest {

    List<String> femaleNames = Arrays.asList("Маша", "Алла");
    List<String> maleNames = Arrays.asList("Петр", "Иван");

    @Test
    public void testOk() {
        Office office = new Office();

        ArrayList<Object> secretaries = new ArrayList<>();
        secretaries.add(new Secretary("Маша"));
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

        for (int i = 0; i < 6; i++)
            secretaries.add(new WantAWork() {
                @Override
                public boolean passInterview() {
                    return true;
                }

                @Override
                public boolean isHired() {
                    return false;
                }

            });
        secretaries.forEach(office::invitePeople);
    }

    @Test
    public void multipleOfficeTest100Iterations() {

        for (int i = 0; i < 100; i++) {
            multipleOfficeTest();
        }
    }

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

    @Test
    public void addAccountant() {

        Office office = new Office();

        List<Object> laborMarket = getLabourMarket();
        laborMarket.forEach(office::invitePeople);

        Accountant accountant = office.accountant;

        assertTrue(laborMarket.contains(accountant));
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

        Collections.shuffle(laborMarket);
        return laborMarket;
    }

    @Test
    public void threeAccountantsInEachOffice() {
        List<Object> labourMarket = getLabourMarketSecondParty();
        Office office = new Office();
        for (Object candidate : labourMarket) {
            office.invitePeople(candidate);
        }
        List<Accountant> accountants = office.accountants;
        assertTrue(accountants.size() == office.director.accountantsRequired);    //тест пройден, если дир выбрал 3х бухгалтеров


    }


    @Test
    public void partAccountantsInOneOffice() {
        List<Object> laborMarket = new ArrayList<>();
        laborMarket.add(new Accountant(""));
        laborMarket.add(new Accountant(""));
        laborMarket.add(new Accountant(""));
        laborMarket.add(new Accountant(""));
        Office office = new Office();
        laborMarket.forEach(office::invitePeople);
        List<Accountant> accountants = office.accountants;
        assertEquals(2,  accountants.size());

    }

    @Test
    public void oneAccountantInOneOffice() {
        List<Object> laborMarket = new ArrayList<>();
        laborMarket.add(new Accountant(""));
        laborMarket.add(new Accountant(""));
        laborMarket.add(new Accountant(""));
        Office office = new Office();
        laborMarket.forEach(office::invitePeople);
        List<Accountant> accountants = office.accountants;
        assertEquals(1,  accountants.size());

    }

    private List<Object> getLabourMarketSecondParty() {


        List<Object> laborMarket = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            // TODO: 9/30/19 лучше убрать все эти столбы и наполнять списки laborMarket в циклах используя имена по рандому из константных списков,
            //  которые я добавил(их желательно расширить) и сделать так чтобы я мог задать кого и сколько мен нужно длля теста.
        }


        laborMarket.add(new Secretary("Маша"));
        laborMarket.add(new Secretary("Алла"));
        laborMarket.add(new Secretary("Анжелла"));
        laborMarket.add(new Secretary("Зина"));
        laborMarket.add(new Secretary("Марина"));
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
        laborMarket.add(new Accountant("Фекла8"));

        Collections.shuffle(laborMarket);
        return laborMarket;
    }
}

// TODO: 9/30/19 желательно вынести в отдельный класс и объединить с похожими в отдельный package
class Sluggard implements WantAWork {

    @Override
    public boolean passInterview() {
        return true;
    }

    public boolean isHired() {
        return false;
    }
}

