package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Office {

	/*
	Secretary secretary;

	Director director;

	Hr hr;
	*/

    //претенденты идут по одному, когда их достаточно,
    // то диретор принимает решение и берет одного в штат

    static void invitePeople(Object human) {
              System.out.println("You are welcome, " + human);
        // TODO: 5/15/20 офис не создает секретарей, это работа для вселенной, бога или колледжа, офис только принимает
        //  и отбирает их
        // TODO: 5/15/20 не забываем дженерики для интерфейса и даймонд оператор для конструктора

    }

    public static void main(String[] args) {
        // TODO: 5/15/20 в классе Main уже есть метод, лучше в него перенести создание
        invitePeople(Director.finalChoose());


    }
}
