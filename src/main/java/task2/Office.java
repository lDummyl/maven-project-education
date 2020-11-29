package task2;

import java.util.Optional;

public class Office {

    Director director;

    Hr hr;

    Secretary secretary;
    Lawyer lawyer;
    Security security;
    Accountant firstAccountant;
    Accountant secondAccountant;

    public Office(Director director, Hr hr) {
        this.director = director;
        this.hr = hr;
    }

    //претенденты идут по одному, когда их достаточно,
    // то диретор принимает решение и берет одного в штат


    void invitePeople(Object human) {
        hr.checkEmployee(human);
        getOptionalEmployee(Secretary.class).ifPresent(val -> secretary = val);
        getOptionalEmployee(Security.class).ifPresent(val -> security = val);
        getOptionalEmployee(Lawyer.class).ifPresent(val -> lawyer = val);

        // если не делать проверку на null, то второй бухгалтер не присвоится т.к. по сути мы каждый проход переприсваиваем
        // значение переменной и удаляем его из листа. В итоге второму бухгалтеру просто не достается значения.

        if (firstAccountant == null) {
            getOptionalEmployee(Accountant.class).ifPresent(val -> firstAccountant = val);
        }
        getOptionalEmployee(Accountant.class).ifPresent(val -> secondAccountant = val);


    }

    private <T extends Employee> Optional<T> getOptionalEmployee(Class<T> t) {
        return director.chooseEmployee(hr.getListEmployee(), t);
    }


}
