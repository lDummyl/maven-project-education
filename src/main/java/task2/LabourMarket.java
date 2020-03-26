package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LabourMarket  {


    public <T extends Employee> List<T> provideEmployee(int qty, Class<T> tClass) {    //Т – это тип, который должен быть определён позже (при создании объекта класса)

        Random random = new Random();
        List<String> randomNames = Arrays.asList("Alla", "Zina", "Oleg", "Victor", "Olya", "Anna", "Semen", "Sasha");
        List<Integer> randomAges = Arrays.asList(34, 25, 55, 61, 33, 26, 45, 52);
        List<Integer> randomRates = Arrays.asList(1200, 800, 1000, 1250, 1050, 1220, 1075, 900);
        List<Integer> randomWorkingHours = Arrays.asList(35, 26, 40, 38, 37, 36, 25, 16);
        List<Integer> randomOvertimeHours = Arrays.asList(4, 14, 8, 18, 10, 12, 15, 16);
        ArrayList<Accountant> accountantList = new ArrayList<>();

        if (tClass == Accountant.class) {   //? действительно ли элемент из этого списка является экземпляром класса: if(accountant instanceof Accountant){}
            // TODO: 3/21/20 сделай N бухгалтеров и положи в этот лист

            for (int i = 0; i < qty; i++) {
                 Accountant accountant = new Accountant(randomNames.get(random.nextInt(randomNames.size()-1)), randomAges.get(random.nextInt(randomAges.size()-1)), randomRates.get(random.nextInt(randomRates.size()-1)), randomWorkingHours.get(random.nextInt(randomWorkingHours.size()-1)), randomOvertimeHours.get(random.nextInt(randomOvertimeHours.size()-1)));
                 accountantList.add(accountant);
            }

            return new ArrayList<>();
        }

        // TODO: 3/21/20 по всем остальным классам аналогично

        return null; // TODO: 3/21/20 это заменить
    }
}
