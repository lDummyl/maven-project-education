package task2;

import java.util.Set;

public class Office {



    public Secretary secretary;

    public Director director;

    public Hr hr;



    //претенденты идут по одному, когда их достаточно,
    // то диретор принимает решение и берет одного в штат
    // TODO: 5/22/20

//
//    public Office(String companyName, Director director) {
//        this.companyName = companyName;
//        this.director = director;
//        invitePeople(director);
//    }

    public void invitePeople(Object visitor) {
        hr.invite(visitor);
        Set<Secretary> candidates = hr.secretaries;
        director.makeChoice(candidates);



    }
}

