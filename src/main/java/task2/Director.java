package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

class Director {

    final Office myOffice;                 //myOffice константа?
    Secretary secretary;
    Accountant accountant;
    Hr hr;
    boolean choiceSecretaryMade=false;
    boolean choiceAccountantMade=false;


    final int enoughSecretariesToDecide = 5;   //4
    final int enoughAccountantToDecide = 3;
    Random random = new Random();

    public Director(Office myOffice) {
        this.myOffice = myOffice;
    }

    public Secretary chooseSecretary(List<Secretary> currentCandidates) {

        if (currentCandidates.size() == enoughSecretariesToDecide && !choiceSecretaryMade) {

            System.out.println("currentCandidates (secr) - " + currentCandidates);
            System.out.println("currentCandidates.size() (secr) - " + currentCandidates.size());
            //   WantAWork wantAWork = currentCandidates.get(random.nextInt(currentCandidates.size()));

            secretary = currentCandidates.get(random.nextInt(currentCandidates.size()));

            //   Stream.of(currentCandidates).filter(x -> x != ((Secretary) wantAWork).isWorking).forEach(System.out::println);


            System.out.println("secretary (dir) - " + secretary);
            if (!secretary.hired) {
                secretary.hired = true;
                choiceSecretaryMade = true;
                System.out.println("choiceIsMade = true !!!");
                return secretary;
            } else {
                System.out.println(secretary + " is hired!!!");
                return null;
            }
            //      }
            //       else
            //          throw new RuntimeException("Что это вы, "+ myOffice.hr.name +",  мне подсовываете " + wantAWork.getClass() + " вместо " + Secretary.class); //иначе создается исключение(в виде ошибки).. срабатывает я так понял, если wantAWork и Secretary не совместимы
        }
        else
            return null;
    }

      public Accountant chooseAccountant(List<Accountant> currentCandidates) {       //Дир выбрает бухгалтера из списка Hr
          if (currentCandidates.size() == enoughAccountantToDecide && !choiceAccountantMade) {

              System.out.println("currentCandidates (Acc) - " + currentCandidates);
              System.out.println("currentCandidates.size() (Acc) - " + currentCandidates.size());

              accountant = currentCandidates.get(random.nextInt(currentCandidates.size()));

              System.out.println("accountant (dir) - " + accountant);

              if (!accountant.hired) {
                  accountant.hired = true;
                  choiceAccountantMade = true;
                  System.out.println("choiceIsMade = true !!!");
                  return accountant;
              } else {
                  System.out.println(accountant + " is hired!!!");
                  return null;
              }
          }
           else
              return null;


      }
    public boolean getChoiceSecretaryMade(){
        return choiceSecretaryMade;
    }

      public boolean getChoiceAccountantMade(){
        return choiceAccountantMade;
      }
}
