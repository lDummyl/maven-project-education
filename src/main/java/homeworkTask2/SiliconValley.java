package homeworkTask2;


import java.util.List;

public class SiliconValley {
    public static void main(String[] args) {
        PersonProvider personProvider = new PersonProvider();
        List<Secretary> secretaries = null;
        List <Accountant> accountants = null;
        List <Jurist> jurists = null;
        try {
            secretaries = personProvider.getSomePeople(Secretary.class,5);
            accountants = personProvider.getWorkers(Accountant.class, 5);
            jurists = personProvider.getWorkers(Jurist.class, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Director director = new Director(personProvider.getPerson(), 2);
        Hr hr = new Hr(personProvider.getPerson());
        Office office = new Office(director, hr);
       
        for (Secretary secretary : secretaries) {
            office.invitePerson(secretary);
        }
//        for (Accountant accountant : accountants) {
//            office.invitePerson(accountant);
//        }
//        for (Jurist jurist : jurists) {
//            office.invitePerson(jurist);
//        }

        System.out.println(office.secretary);
        System.out.println(office.accountant);
        System.out.println(office.jurist);

    }
}
