package task2.model;

public abstract class Office {

    Secretary secretary;

    Director director;

    Hr hr;

    public Office(Director director, Hr hr) {
        this.director = director;
        this.hr = hr;
    }

    //претенденты идут по одному, когда их достаточно,
    // то директор принимает решение и берет одного в штат

    public abstract void invitePeople(Object human);
}
