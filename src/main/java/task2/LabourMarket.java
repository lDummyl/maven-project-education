package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LabourMarket {
    Random random = new Random();


    public <T extends Employee> List<T> provideEmployee(int qty, Class<T> tClass) throws Exception {    //Т – это тип, который должен быть определён позже (при создании объекта класса)



        if (tClass == Accountant.class) {   //? действительно ли элемент из этого списка является экземпляром класса: if(accountant instanceof Accountant){}
            // TODO: 3/21/20 сделай N бухгалтеров и положи в этот лист
            List<T> accountantList = new ArrayList<>();

            for (int i = 0; i < qty; i++) {
                T accountant = (T) new Accountant(getRandomCollectionElement(randomNames), getRandom(18, 65), getRandom(800, 1500), getRandom(10, 40), getRandom(1, 20));
                 accountantList.add(accountant);  //доделать
            }

            return  accountantList;
        }

        if (tClass == Boss.class) {
            ArrayList<Boss> bossList = new ArrayList<>();
            for (int i = 0; i < qty; i++) {
                //   Boss boss = new Boss(); //доделать
                //  bossList.add(boss);
            }
            return (List<T>) bossList;
        }

        if (tClass == HR.class) {
            ArrayList<HR> HRlist = new ArrayList<>();
            for (int i = 0; i < qty; i++) {
                //  HR hr = new HR();  //доделать
                //  HRlist.add(hr);
            }
            return (List<T>) HRlist;
        }

        if (tClass == Manager.class) {
            ArrayList<Manager> managerList = new ArrayList<>();
            for (int i = 0; i < qty; i++) {
                //  Manager manager = new Manager();  //доделать
                //  managerList.add(manager);
            }
            return (List<T>) managerList;
        }

        if (tClass == Security.class) {
            ArrayList<Security> securityList = new ArrayList<>();
            for (int i = 0; i < qty; i++) {
                for (int j = 0; j < qty; j++) {
                    // Security security = new Security();  // доделать
                    //   securityList.add(security);
                }
            }
            return (List<T>) securityList;
        }

        // TODO: 3/21/20 по всем остальным классам аналогично

        throw new Exception("Введите класс-наследник Employee"); // TODO: 3/21/20 это заменить
    }

    private <T> T getRandomCollectionElement(List<T> list) {
        return list.get(random.nextInt(list.size()));
    }

    private int getRandom(int minBound, int maxBound) {
        return random.nextInt(maxBound - minBound) + minBound;
    }

    List<String> randomNames = Arrays.asList("Alla", "Zina", "Oleg", "Victor", "Olya", "Anna", "Semen", "Sasha");
    List<Integer> randomRates = Arrays.asList(1200, 800, 1000, 1250, 1050, 1220, 1075, 900);

    public static void main(String[] args) {
        Cat barsic = new Cat();
        barsic.name = "barsic";
        System.out.println(barsic.name);
        LabourMarket labourMarket = new LabourMarket();
        System.out.println(labourMarket.getRandomCollectionElement(labourMarket.randomRates));
    }
}

class Cat {
    String name;
}