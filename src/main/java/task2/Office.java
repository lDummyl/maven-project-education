package task2;

public class Office {

    public Office(Director director, Hr hr) {
        this.director = director;
        this.hr = hr;
    }

    Secretary secretary;

    Director director;

    Hr hr;

    public Office() {

    }

    //претенденты идут по одному, когда их достаточно,
    // то директор принимает решение и берет одного в штат

    void invitePeaople(Object human) {

    }
}
