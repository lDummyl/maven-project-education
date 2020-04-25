package task1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        first();
        second();

    }

    public static void first(){
        // TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего

        Person person1 = new Person();
        person1.age = new Age();
        person1.name = new Name();
        person1.name.firstName = "John";
        person1.name.lastName = "Jones";
        person1.age.year = 1970;
        person1.age.month = 11;
        person1.age.day = 11;

        Person person2 = new Person();
        person2.age = new Age();
        person2.name = new Name();
        person2.name.firstName = "Dick";
        person2.name.lastName = "Philips";
        person2.age.year = 1971;
        person2.age.month = 12;
        person2.age.day = 12;

        Person person3 = new Person();
        person3.age = new Age();
        person3.name = new Name();
        person3.name.firstName = "Rick";
        person3.name.lastName = "Dempsey";
        person3.age.year = 1971;
        person3.age.month = 12;
        person3.age.day = 12;

        Person person4 = new Person();
        person4.age = new Age();
        person4.name = new Name();
        person4.name.firstName = "Esther";
        person4.name.lastName = "Nash";
        person4.age.year = 1975;
        person4.age.month = 11;
        person4.age.day = 11;

        Person person5 = new Person();
        person5.age = new Age();
        person5.name = new Name();
        person5.name.firstName = "Carol";
        person5.name.lastName = "Miyaki";
        person5.age.year = 1978;
        person5.age.month = 10;
        person5.age.day = 10;

        //declare variable that will store oldest person
        Person oldestPerson = null;

        //assume person1 is oldestPerson, then compare with next person and reassign if needed
        Person personInFocus = person1;
        try{
            Date bday = personInFocus.age.getBirthday();
            oldestPerson = personInFocus;
        }catch (Exception ex){
            System.out.println("Error parsing birthday for person: " + personInFocus.name.lastName);
        }

        try {
            personInFocus = person2;
            if (personInFocus.age.getBirthday().compareTo(oldestPerson.age.getBirthday()) < 0) {
                oldestPerson = personInFocus;
            }
            personInFocus = person3;
            if (personInFocus.age.getBirthday().compareTo(oldestPerson.age.getBirthday()) < 0) {
                oldestPerson = personInFocus;
            }
            personInFocus = person4;
            if (personInFocus.age.getBirthday().compareTo(oldestPerson.age.getBirthday()) < 0) {
                oldestPerson = personInFocus;
            }
            personInFocus = person5;
            if (personInFocus.age.getBirthday().compareTo(oldestPerson.age.getBirthday()) < 0) {
                oldestPerson = personInFocus;
            }
        }catch (Exception ex){
            System.out.println("Error parsing birthday for person: " + personInFocus.name.lastName);
        }

        System.out.println("Olderst person: " + oldestPerson.name.lastName);
        return;
    }

    public static void second(){
        // TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.

        ArrayList fName = new ArrayList();
        fName.add("John");
        fName.add("Dick");
        fName.add("Rick");

        ArrayList lName = new ArrayList();
        lName.add("Jones");
        lName.add("Philips");
        lName.add("Dempsey");

        int randomFNameIndex;
        int randomLNameIndex;
        int randomMonth;
        int randomDay;
        int randomYear;


        ArrayList list = new ArrayList();
        Person person = null;

        for (int i = 0; i<10; i++){
            randomFNameIndex = getRandomIntegerBetweenRange (0, 2);
            randomLNameIndex =getRandomIntegerBetweenRange (0, 2);
            randomMonth = getRandomIntegerBetweenRange (1, 12);
            randomDay = getRandomIntegerBetweenRange (1, 28);
            randomYear = getRandomIntegerBetweenRange (1970, 1980);

            try {
                person = createPerson((String)fName.get(randomFNameIndex), (String)lName.get(randomLNameIndex), randomMonth, randomDay, randomYear);
                list.add(person);
            }catch (Exception ex){
                System.out.println("Can not add person to collection, will skip it.");
            }
        }

        Iterator it = list.iterator();
        while (it.hasNext()){
            Person p = (Person)it.next();
            try {
                System.out.println(p.name.firstName + ", " + p.name.lastName + ", " + p.age.getBirthday().toString());
            }catch (Exception ex){
            }
        }




    }

    public static Person createPerson(String fName, String lName, int month, int day, int year) throws java.text.ParseException {
        Person person = new Person();
        person.age = new Age();
        person.name = new Name();
        person.name.firstName = fName;
        person.name.lastName = lName;
        person.age.year = year;
        person.age.month = month;
        person.age.day = day;

        //validate bday
        try {
            Date bday = person.age.getBirthday();
        } catch (java.text.ParseException ex) {
            System.out.println("Error parsing birthday for person: " + lName);
            throw ex;
        }

        return person;
    }

    public static int getRandomIntegerBetweenRange(int min, int max){
        int x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

}


class Name {

    String firstName;
    String lastName;

}

class Age {

    int year;
    int month;
    int day;

    public Date getBirthday() throws java.text.ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
        String dateInString = new Integer(month).toString() + "/" +
                new Integer(day).toString() + "/" +
                new Integer(year).toString();
        return sdf.parse(dateInString);
    }

}

class Person {

    Name name;
    Age age;

}