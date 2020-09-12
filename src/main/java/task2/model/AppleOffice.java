package task2.model;

public class AppleOffice extends Office {

    public AppleOffice(Director director, Hr hr) {
        super(director, hr);
    }

    @Override
    public void invitePeople(Object human) {
        this.secretary = (Secretary) human;
    }

}
