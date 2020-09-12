package task2.model;

public class GoogleOffice extends Office {

    public GoogleOffice(Director director, Hr hr) {
        super(director, hr);
    }

    @Override
    public void invitePeople(Object human) {
        this.secretary = (Secretary) human;
    }
}
