package task2;

import java.util.ArrayList;
import java.util.List;

public class Office {

    private Secretary secretary;
    private SecurityOfficer security;
    private Lawyer lawyer;
    private List<Accountant> accountants = new ArrayList<>();

    // чтож пора нанять еще людей по тому же принципу, пусть будут еще 2 бухгалтера, охранник и юрист. Эх, добавится работы ХРу ну и директору.

    private Director director = new Director(this);
    private Hr hr = new Hr();

    //претенденты идут по одному, когда их достаточно,
    // то диретор принимает решение и берет одного в штат

    void invitePeaople(ArrayList<Object> candidates) {
        for (Object candidate : candidates) {
            if (candidate instanceof WantAJob) {
                hr.interview((WantAJob) candidate);
            }
        }
        hr.selectCandidates();
        director.makeDecision();
    }

    public Hr getHr() {
        return hr;
    }

    public Secretary getSecretary() {
        return secretary;
    }

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }

    public SecurityOfficer getSecurity() {
        return security;
    }

    public void setSecurity(SecurityOfficer security) {
        this.security = security;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }

    public List<Accountant> getAccountants() {
        return accountants;
    }

    public void setAccountants(List<Accountant> accountants) {
        this.accountants = accountants;
    }
}
