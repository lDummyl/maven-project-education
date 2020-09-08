package task2;

import task1.Age;
import task1.Name;
import task1.PersonProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Office {
    private final Director director;
    private final Hr hr;
    Secretary secretary;

    public Office(Director director, Hr hr) {
        this.director = director;
        this.hr = hr;
    }

    // TODO: 6/8/20 добавлю условие: класс Office неизвеняемый, ему можно добавлять только приватные методы,
    //  ни новых публичных ни новых конструкторов ни добвалять и не модифицировать контракты существующих.
    //  Так же он не должен содержать main метода.

    void invitePeople(Object human) {
		List <Secretary> candidates = hr.invite(human);
		secretary = director.select(candidates);
    }

}


//претенденты идут по одному, когда их достаточно,
// то диретор принимает решение и берет одного в штат


