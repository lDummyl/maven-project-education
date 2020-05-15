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
        // TODO: 5/15/20 параметер должен использоваться

        // TODO: 5/15/20 офис не создает секретарей, это работа для вселенной, бога или колледжа, офис только принимает и отбирает их
        // TODO: 5/15/20 не забываем дженерики для интерфейса и даймонд оператор для конструктора
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


        // TODO: 5/15/20 это же касается и директора
        new Director().finalChoose(new Hr().chooseSecretary(list));;
    }

    public static void main(String[] args) {
        // TODO: 5/15/20 в классе Main уже есть метод, лучше в него перенести создание
    new Office().invitePeople(new Object());


    }
}
