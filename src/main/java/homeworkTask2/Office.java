package homeworkTask2;

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
        List candidates = hr.invite(human);
        if (human instanceof Secretary) {
            secretary = (Secretary) director.select(candidates);
            if (secretary != null)
            {
                candidates.clear();
            }
        }
        else if (human instanceof Accountant) {
            accountant = (Accountant) director.select(candidates);
            if (accountant != null)
            {
                candidates.clear();
            }
        }
        else if (human instanceof Jurist)
        {
            jurist = (Jurist) director.select(candidates);
            if (jurist != null)
            {
                candidates.clear();
            }
        }
    }
}
