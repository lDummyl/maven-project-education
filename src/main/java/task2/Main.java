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

        Director director =  new Director("asd", 2);
        Director director2 = new Director("qqwe", 56);
        Office office = new Office();
        Director steve = new Director("Steve", office);
//        office.appleDirector = steve;
//        office.amazonDirector = new Director("Jeffrey");
        office.hr = new Hr("Marina");

//        System.out.println(office.appleDirector.getBadBehavior());
//        System.out.println(office.amazonDirector.getGoodBehavior());
        AppleDirector appleDirector = new AppleDirector("",5);
        AmazonDirector amazonDirector = new AmazonDirector("", 6);
        appleDirector.makeChoice();
        amazonDirector.makeChoice();

        office.invitePeople(amazonDirector);



    }
}
