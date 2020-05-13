package task2;

import java.util.ArrayList;
import java.util.List;

public class Office {

	/*
	Secretary secretary;

	Director director;

	Hr hr;
	*/

    //претенденты идут по одному, когда их достаточно,
    // то диретор принимает решение и берет одного в штат

    void invitePeople(Object human) {
        List list = new ArrayList<Secretary>();
        Secretary secretary = new Secretary("Nina", "I");
        Secretary secretary2 = new Secretary("Masha", "O");
        Secretary secretary3 = new Secretary("Sergey", "M");
        Secretary secretary4 = new Secretary("Ivan", "K");
        Secretary secretary5 = new Secretary("Vasily", "S");
        Secretary secretary6 = new Secretary("Ruslan", "Z");
        Secretary secretary7 = new Secretary("Irina", "P");

        list.add(secretary);
        list.add(secretary2);
        list.add(secretary3);
        list.add(secretary4);
        list.add(secretary5);
        list.add(secretary6);
        list.add(secretary7);


        new Director().finalChoose(new Hr().chooseSecretary(list));;
    }

    public static void main(String[] args) {
    new Office().invitePeople(new Object());


    }
}
