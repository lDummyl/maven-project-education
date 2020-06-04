package task2;

import task1.PersonProvider;

public class Main {

    public static void main(String[] args) {
        Office apple = new Office();
//        apple.director = new Director("Steve Jobs");

//        hr
//        PersonProvider personProvider = new PersonProvider();
//        Set<? extends Person> secretaries = personProvider.getSecretaries(10);
//        for (Person person : secretaries) {
//            apple.invitePeople(person);
//        }
//        boolean b = apple.secretary == null;
//        System.out.println("b = " + b);

//        apple.hr =

        Office office = new Office();
        Director steve = new Director("Steve", office);
//        office.appleDirector = steve;
//        office.amazonDirector = new Director("Jeffrey");
        office.hr = new Hr("Marina");

//        System.out.println(office.appleDirector.getBadBehavior());
//        System.out.println(office.amazonDirector.getGoodBehavior());

        System.out.println(office.hr.selectedPeople(8));
        steve.sendMail(new Mail("qwe"));

    }
}
