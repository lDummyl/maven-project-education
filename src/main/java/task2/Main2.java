package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import java.util.*;

public class Main2 {
    public static void main(String[] args) {

    }
}

class Secretary {
    String name;
    String surname;

    public Secretary(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Secretary{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

class Hr {
    public List<Secretary> chooseSecretary (List <Secretary> list){
        int sizeOfListHr = new Random().nextInt(list.size()+1);
        List choosen = new ArrayList<Secretary>();
        for (int i = 0; i < list.size(); i++) {
            choosen.add(list.get(i));
            if (choosen.size()==sizeOfListHr){
                break;
            }
        }

        return choosen;
    }
}

class Director {
    public Object finalChoose(List list){
        Secretary s = (Secretary) list.get(new Random().nextInt(list.size()));
            System.out.println(s);

        return s;
    }
}