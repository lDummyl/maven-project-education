package homeworkTask2;

import java.util.List;

public class Office {
    Director director;
    Hr hr;
    Secretary secretary;
    Accountant accountant;

    public Office(Director director, Hr hr) {
        this.director = director;
        this.hr = hr;
    }

    public void invitePerson (Object human)
    {
        List secretaries = hr.invite(human);
        secretary = director.select(secretaries);
    }
}
