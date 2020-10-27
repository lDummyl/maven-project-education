package homeworkTask2;

import java.util.HashMap;

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
        Office office = this;
        HashMap candidates = hr.invite(human);
        if (candidates.get(human.getClass()) != null) {
            Object worker = director.select(candidates, human.getClass());
            if (worker != null)
            hr.init(office, worker);
        }
    }
}
