package task2;

import task1.Person;

import java.util.ArrayList;
import java.util.List;

// TODO: 5/28/20 тут совсем generic не нужен. строго говоря без них прекрасно можно обойтись и в PersonProvider, кода будет столько
//  же, единственная функция дженериков это перевод runtime ошибок в compiletime ошибки. Все! По объему кода где-то 5% сокращает за счет потери downcast.
public abstract class OfficeWorker<T>  {

    Person person;

    public Person getPerson() {
        return person;
    }
}
