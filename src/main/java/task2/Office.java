package task2;


import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Office {

    // TODO: 5/21/20 ну что ж похоже нам предстоит организовать энергичное расширение нашего офиса,
    //  пожалуй не помешает добавить юриста, охранника, и бухгалтеров(в одном офисе 2х с другом 3х).

    Director director;

    Hr hr;

    public Office(Director director, Hr hr) {
        this.director = director;
        this.hr = hr;
    }

    public Office() {
    }

    List<Secretary> secretaries = new ArrayList();
    List<Security> securities = new ArrayList();
    List<Jurist> jurists = new ArrayList();
    List<Accountant> accountants = new ArrayList();

    // TODO: 6/11/20 так не пойдет
//    List<OfficeWorker> officeWorkers = new ArrayList<>();

    public void setOfficeWorkers(OfficeWorker officeWorker){
        this.officeWorkers.add(officeWorker);
    }

    // TODO: 6/11/20 убери все эти сеттеры они тебе не нужны на данном этапе


    // TODO: 6/11/20 тогда тут все делают свою офисную работу секретари варят, юристы судятся, бухгалтеры сводят баланс
    public void listWorkers(){
        System.out.println(director);
        System.out.println(hr);
        System.out.println(officeWorkers);
        }

        //претенденты идут по одному, когда их достаточно,
        // то диретор принимает решение и берет одного в штат

        void invitePeaople(Object human) {

        }




}

