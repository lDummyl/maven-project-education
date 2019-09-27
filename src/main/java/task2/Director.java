package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

class Director {

    final Office myOffice;

    final int enoughCandidatesToDecide = 3;
    final int enoughAccountants = 3;

    Random random = new Random();

    public Director(Office myOffice) {
        this.myOffice = myOffice;
    }

    public WantAWork chooseOneCandidate(List<? extends WantAWork> currentCandidates) {
        WantAWork candidate = null;
        if(currentCandidates.size() == enoughCandidatesToDecide){
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

        if(myOffice.accountants.isEmpty() && currentCandidates.size()==enoughCandidatesToDecide) {
        List<Accountant> accountants = new ArrayList<>();

            while(accountants.size() != enoughAccountants){        //крутим пока дир не выберет трех бухгалтеров
            Accountant accountant = (Accountant) chooseOneCandidate(currentCandidates);

                if (accountant != null && !accountant.hired) {
                    accountant.hired = true;
                    accountants.add(accountant);
                    myOffice.setAccountant(accountants);
                }
            }
        }
    }

  /*  public void chooseAccountant(List<Accountant> currentCandidates) {
        if(myOffice.accountants.isEmpty() && currentCandidates.size()==enoughCandidatesToDecide) {
            List<Accountant> accountants = myOffice.getAccountant();

            for (int i = 0; i < currentCandidates.size(); i++) {
                Accountant accountant = (Accountant) chooseOneCandidate(currentCandidates);
                if(accountant!=null && !accountant.hired) {
                    accountant.hired=true;
                    accountants.add(accountant);

                    if (accountants.size() == 3) {
                        myOffice.setAccountant(accountants);
                        break;
                    }
                }
            }
        }
    }
   */
}
