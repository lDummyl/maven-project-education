package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

class Director {

    final Office myOffice;                 //myOffice константа?
    Hr hr;

    final int enoughSecretariesToDecide = 4;   //4
    final int enoughAccountantToDecide = 3;
    Random random = new Random();

    public Director(Office myOffice) {
        this.myOffice = myOffice;
    }

    public Secretary chooseSecretary(List<Secretary> currentCandidates) {       //Дир выбрает секретаря из списка Hr

        if (currentCandidates.size() < enoughSecretariesToDecide) return null;    //если список Hr меньше достаточного кол-ва кандидатов, то возвращаем null

        WantAWork wantAWork = currentCandidates.get(random.nextInt(currentCandidates.size()));

     //   Stream.of(currentCandidates).filter(x -> x != ((Secretary) wantAWork).isWorking).forEach(System.out::println);

           if (wantAWork instanceof Secretary) {      //проверяем на совместимость типа к объкту wantAWork
            if(!((Secretary) wantAWork).hired)
                return (Secretary) wantAWork;         //тогда возвращаем wantAWork приведенный к типу Secretary
            else
                return null;
        }
         else
            throw new RuntimeException("Что это вы, "+ myOffice.hr.name +",  мне подсовываете " + wantAWork.getClass() + " вместо " + Secretary.class); //иначе создается исключение(в виде ошибки).. срабатывает я так понял, если wantAWork и Secretary не совместимы
    }

      public Accountant chooseAccountant(List<Accountant> currentCandidates) {       //Дир выбрает бухгалтера из списка Hr
        if (currentCandidates.size() < enoughAccountantToDecide) return null;

          WantAWork wantAWork = currentCandidates.get(random.nextInt(currentCandidates.size()));

              if (wantAWork instanceof Accountant) {
                  if(!((Accountant) wantAWork).hired)
                      return (Accountant) wantAWork;
                  else
                      return null;
              }
              else
                  throw new RuntimeException("Что это вы, "+ myOffice.hr.name +",  мне подсовываете " + wantAWork.getClass() + " вместо " + Accountant.class); //иначе создается исключение(в виде ошибки).. срабатывает я так понял, если wantAWork и Secretary не совместимы

    }

}
