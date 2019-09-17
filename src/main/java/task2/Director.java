package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

class Director {

    final Office myOffice;
    Secretary secretary;
    Accountant accountant;

    boolean choiceSecretaryMade=false;
    boolean choiceAccountantMade=false;

    final int enoughSecretariesToDecide = 3;
    final int enoughAccountantToDecide = 3;
    Random random = new Random();

    public Director(Office myOffice) {
        this.myOffice = myOffice;
    }

    public Secretary chooseSecretary(List<Secretary> currentCandidates) {

        if (currentCandidates.size() == enoughSecretariesToDecide && !choiceSecretaryMade) {

            secretary = currentCandidates.get(random.nextInt(currentCandidates.size()));

            secretary.hired = true;          //секретарь занял рабочее место
            choiceSecretaryMade = true;      //дир сделал свой выбор по секретарю
            myOffice.setSecretary(secretary);
            return myOffice.getSecretary();
        }
        else
            return null;
    }

      public Accountant chooseAccountant(List<Accountant> currentCandidates) {                    //понимаю, что из этих двух методов нужно сделать один общий, постараюсь сделать в след заход
          if (currentCandidates.size() == enoughAccountantToDecide && !choiceAccountantMade) {

              accountant = currentCandidates.get(random.nextInt(currentCandidates.size()));

              accountant.hired = true;
              choiceAccountantMade = true;
              myOffice.setAccountant(accountant);
              return myOffice.getAccountant();
          }
           else
              return null;
      }
}
