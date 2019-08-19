package task2;

import java.util.List;
import java.util.Random;

class Director {

    final Office myOffice;                 //myOffice константа?
    //	final DataMy constant = new DataMy(6);
    final int enoughCandidatesToDecide = 4;
    Random random = new Random();

    public Director(Office myOffice) {
        this.myOffice = myOffice;
    }

    public Secretary chooseSecretary(List<WantAWork> currentCandidates) {       //Дир выбрает секретаря из списка Hr
        if (currentCandidates.size() < enoughCandidatesToDecide) return null;    //если список Hr меньше достаточного кол-ва кандидатов, то возвращаем null
//		constant.i = 10;

        WantAWork wantAWork = currentCandidates.get(random.nextInt(currentCandidates.size()));    //создаем объект WantAWork и присваеваем ему случайно выбранного кандидата из списка Hr

        if (wantAWork instanceof Secretary) {     //проверяем на совместимость типа к объкту wantAWork
            return (Secretary) wantAWork;         //тогда возвращаем wantAWork приведенный к типу Secretary
        } else {
            throw new RuntimeException("Что это вы, "+ myOffice.hr.name +",  мне подсовываете " + wantAWork.getClass() + " вместо " + Secretary.class); //иначе создается исключение(в виде ошибки).. срабатывает я так понял, если wantAWork и Secretary не совместимы
        }
    }

}
