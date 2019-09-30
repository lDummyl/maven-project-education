package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

class Director {

    final Office myOffice;

    final int enoughCandidatesToDecide = 3;


    // TODO: 9/30/19  небольшое недопопнимание. Директору чтобы принять решение о найме одного сотрудника нужно чтобы было из кого выбрать
    //  он считает что достаточно 3х кандидатов чтобы принять одного сотрудника. Если есть 3е, то он принимает решение и один выходит из списка. В списке теперь
    //  2 кандидата
    //  чтобы нанять еще одного нужно чтобы их стало снова 3 то есть еще один, и мы снова готовы выбрать, потому что есть из кого и кандидатов достаточно
    //  и так еще раз и итого мы наняли 3 их из 5ти при том что у нас критерий выбора одного из 3х. Но это не значит, что нам следует заводить отдельную константу 5 и
    //  нанимать их всех скопом, потому что принцип все или ничего не самый конструктивный, когда тебе нужно 3 бухгалтера иметь 2х лучше чем ни одного если в рынке
    //  недостаточно кандидатов для всех 3их но хватает для 2их.



    final int enoughAccountantsToDecide = 5;

    // TODO: 9/30/19 это поле будет лучше если будет инкапсулировать офис, а не директор.
    final int accountantsRequired = 3;


    Random random = new Random();

    public Director(Office myOffice) {
        this.myOffice = myOffice;
    }

    public WantAWork chooseOneCandidate(List<? extends WantAWork> currentCandidates) {
        WantAWork candidate = null;
        if(currentCandidates.size() >= enoughCandidatesToDecide){
            candidate = currentCandidates.get(random.nextInt(currentCandidates.size()));
        }
        return candidate;
    }

    public void chooseSecretary(List<Secretary> currentCandidates) {
        if(myOffice.secretary == null) {
            Secretary secretary = (Secretary) chooseOneCandidate(currentCandidates);
            if(secretary != null) {
                myOffice.setSecretary(secretary);
                secretary.hired = true;
            }
        }
    }

    public void chooseAccountant(List<Accountant> currentCandidates) {

        // TODO: 9/27/19 то есть если кандитов пришло больше то мы их не рассматриваем?
        if(myOffice.accountants.isEmpty() && currentCandidates.size()== enoughAccountantsToDecide) {
        List<Accountant> accountants = new ArrayList<>();

            // TODO: 9/27/19 немного странно получается 3 кандидата нужно ля того чтобы принять решение о найме одного,
            //  но так же трех кандидатов достаточно чтобы нанаять сразу всех 3их. Что-то не сходится. Нужно 5ть чтобы нанаять 3их из этой логики
            //  и я бы использовал тот же механизм найма только несколько раз. Тесты тесты тесты и  все будет нагядно, сосредоточься на них.

                for (int i = 0; i < enoughAccountantsToDecide; i++) {
            Accountant accountant = (Accountant) chooseOneCandidate(currentCandidates);

                if (accountant != null && !accountant.hired) {
                    accountant.hired = true;
                    accountants.add(accountant);
                    myOffice.setAccountant(accountants);
                }
                if(accountants.size() == accountantsRequired)
                    break;
            }
        }
    }
}
