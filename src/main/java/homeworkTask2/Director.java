package homeworkTask2;

import java.util.*;

public class Director extends Person {
    int enoughCandidatesToDecide;

    public Director(Person person, int enoughCandidatesToDecide) {
        super(person.name, person.age);
        this.enoughCandidatesToDecide = enoughCandidatesToDecide;
    }


//    1. в классе SiliconValley формируются списки обьектов классов secretary, accountant, jurist.
//    2. данные списки передаются в класс Hr, в метод invite, в котором, проходя сортировку по принадлежности
//    к классам добавляются в HashMap, где ключ - класс, значение - список объектов этого класса
//    3. полученная map передается в класс Директор, который должен возвращать сотрудника методу
//    invitePerson класса Офис.
//    Проблема в том, что метод select класса Директор никогда не возвращает значение отличное от null,
//    хотя когда я проверяю выполнение этого метода в дебаггере присваивает объекту корректные класс и значение


    public <T extends Person> Object select(HashMap<Class<?>, List> map) {
        for (Map.Entry<Class<?>, List> entry : map.entrySet()) {
            Class clazz = entry.getKey();
            List list = entry.getValue();
            System.out.println(list);
            System.out.println(list.size());
            if (list.size() > enoughCandidatesToDecide) {
                Object obj = list.get(0);
               return clazz.cast(obj);
            }
        }
        return null;
    }
}
