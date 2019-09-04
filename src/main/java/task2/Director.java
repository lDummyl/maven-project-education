package task2;

import java.util.List;
import java.util.Random;

class Director {

    final Office myOffice;                 //myOffice константа?

    final int enoughCandidatesToDecide = 4;
    final int enoughAccountantToDecide = 4;
    Random random = new Random();

    public Director(Office myOffice) {
        this.myOffice = myOffice;
    }

    public Secretary chooseSecretary(List<WantAWork> currentCandidates) {       //Дир выбрает секретаря из списка Hr
        if (currentCandidates.size() < enoughCandidatesToDecide) return null;    //если список Hr меньше достаточного кол-ва кандидатов, то возвращаем null

        WantAWork wantAWork = currentCandidates.get(random.nextInt(currentCandidates.size()));    //создаем объект WantAWork и присваеваем ему случайно выбранного кандидата из списка Hr

        if (wantAWork instanceof Secretary) {      //проверяем на совместимость типа к объкту wantAWork
            ((Secretary) wantAWork).isWorking = true;
            return (Secretary) wantAWork;         //тогда возвращаем wantAWork приведенный к типу Secretary
        }
         else
            throw new RuntimeException("Что это вы, "+ myOffice.hr.name +",  мне подсовываете " + wantAWork.getClass() + " вместо " + Secretary.class); //иначе создается исключение(в виде ошибки).. срабатывает я так понял, если wantAWork и Secretary не совместимы

    }

      public Accountant chooseAccountant(List<WantAWork> currentCandidates) {       //Дир выбрает бухгалтера из списка Hr
        if (currentCandidates.size() < enoughAccountantToDecide) return null;

          WantAWork wantAWork = currentCandidates.get(random.nextInt(currentCandidates.size()));

              if (wantAWork instanceof Accountant) {
                  ((Accountant) wantAWork).isWorking = true;
                  return (Accountant) wantAWork;
              }
              else
                  throw new RuntimeException("Что это вы, "+ myOffice.hr.name +",  мне подсовываете " + wantAWork.getClass() + " вместо " + Accountant.class); //иначе создается исключение(в виде ошибки).. срабатывает я так понял, если wantAWork и Secretary не совместимы

    }

}
