package task2;

import task1.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

// TODO: 5/28/20 тут совсем generic не нужен. строго говоря без них прекрасно можно обойтись и в PersonProvider, кода будет столько
//  же, единственная функция дженериков это перевод runtime ошибок в compiletime ошибки. Все! По объему кода где-то 5% сокращает за счет потери downcast.
public abstract class OfficeWorker {

    boolean passInterview(){
        Random random = new Random();
        return random.nextBoolean();
    }
    Person person;

    public Person getPerson() {
        return person;
    }
}