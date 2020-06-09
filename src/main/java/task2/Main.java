package task2;

import task1.PersonProvider;

public class Main {

    public static void main(String[] args) {

//        apple.director = new Director("Steve Jobs");

//        hr
//        PersonProvider personProvider = new PersonProvider();
//        Set<? extends Person> secretaries = personProvider.getSecretaries(10);
//        for (Person person : secretaries) {
//            apple.invitePeople(person);
//        }
//        boolean b = apple.secretary == null;
//        System.out.println("b = " + b);


        Director director =  new Director("Steve", 7);
        Director director2 =  new Director("Jeffrey", 6);


        new Office("Apple",director);
        new Office("Amazon",director2);




    }
}
