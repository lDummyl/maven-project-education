package task2;

import task1.Person;

import java.util.ArrayList;
import java.util.List;

// TODO: 5/28/20 как ты можешь наблюдать в PersonProvider, для дого чтобы generify метод, совсем не обязательно generify весь класс.
//  В данном случае уж точно не стоит создавать экземпляр HR под определенную профессию. Кроме того замени аггрегацию Person на наследование.
public class Hr2<T> { //Экспериментальный класс

    public static final int YEAR_OF_BIRTH = 2000;
    Person person;


    public Hr2(Person person) {
        this.person = person;
    }

    public List<T> filter(List<OfficeWorker> officeWorkers){
        List<T> approved = new ArrayList<>();
        for(int i = 0; i < officeWorkers.size(); i++){
            if(officeWorkers.get(i).getPerson().getAge().getYear() < YEAR_OF_BIRTH){
                approved.add((T) officeWorkers.get(i));
            }
        }
        return approved;
    }



}
