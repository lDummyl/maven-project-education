package task2;

import org.junit.Test;
import task1.Name;
import task1.PersonProvider;

import java.util.List;
import java.util.stream.Collectors;


public class OfficeTest {

    private Director director;
    private Hr hr;


    @Test
    public void invitePeople() {
        PersonProvider personProvider = new PersonProvider();
        List<Secretary> secretaries = personProvider.getSecretaries(100);
        List<String> collect = secretaries.stream()
                .map(secretary -> secretary.name.firstName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(collect);
        Office office = new Office(director, hr);

    }

    @Test
    public void inviteLambda() {
        DoStuff doStuff = new DoStuff() {
            @Override
            public String saySomething(String name) {
                return "Hi!";
            }
        };
        DoStuff doStuff1 = (String name) -> {
            System.out.println("Bla-bla");
            return "Hi!, " + name;
        };

        DoStuff doStuff2 = (String name) -> "Hi!, " + name;

        DoStuff doStuff3 =  name -> "Hi!, " + name;

        DoStuff doStuff4 = OfficeTest::say;

        String s = doStuff.saySomething("Ivan");
        System.out.println("s = " + s);

    }

    public static String say(String s){
        return "Bye-bye";
    }

}

interface DoStuff {

    String saySomething(String name);

}