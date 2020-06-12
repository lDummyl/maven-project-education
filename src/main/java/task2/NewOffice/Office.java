package task2.NewOffice;


public class Office {

    public Hr hr = new Hr("Victoria");
    public Director director = new Director("Steve", this);
    public Secretary secretary;

    public String companyName;

    public Office(String companyName) {
        this.companyName = companyName;
    }

    public void invitePeople(Object visitor) {
        if (visitor instanceof ApplyingForAJob && ((ApplyingForAJob) visitor).passAnInterview())
            secretary = (Secretary) visitor;
    }

}
