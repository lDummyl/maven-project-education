package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

class Director {

    final Office myOffice;

    final int enoughCandidatesToDecide = 3;
    final int enoughAccountantsToDecide = 5;
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
