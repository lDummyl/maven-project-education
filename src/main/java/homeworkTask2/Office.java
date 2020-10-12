package homeworkTask2;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Office {
    Director director;
    Hr hr;
    Secretary secretary;
    Accountant accountant;
    Jurist jurist;

    public Office(Director director, Hr hr) {
        this.director = director;
        this.hr = hr;
    }

    public void invitePerson (Object human)
    {
        HashMap candidates = hr.invite(human);
        director.select(candidates);
    }
}
