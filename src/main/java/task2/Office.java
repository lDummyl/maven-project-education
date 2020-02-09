package task2;

import java.util.*;

public class Office {


    //претенденты идут по одному, когда их достаточно,
    // то диретор принимает решение и берет одного в штат

    Map<String, CompanyEmployee> companyEmployeeMap = new HashMap<>();

    Secretary secretary;
    AllCandidate allCandidate;
    Loader loader;
    Director director = new Director("Big Boss", 4);
    HR hr = new HR("Elena");

    public void inviteSecretary(Secretary candidate) {

        if (this.secretary != null) {
            System.out.println("Sorry no vacancy!");
            return;
        }
        hr.makeAudition(candidate);
        Secretary secretary = director.considerCandidates(hr.successCandidates);
        this.secretary = secretary;
    }

    public void inviteAllCandidate(AllCandidate candidate) {
        if (this.allCandidate != null) {
            System.out.println(candidate.name + " Нет вакансий на данный момент");
            return;
        }
//        hr.makeAudition2(candidate);
//        AllCandidate allCandidate = director.considerCandidates2(hr.successAllCandidates);
        this.allCandidate = allCandidate;
    }

    public void InviteLoader(Loader candidate) {
        if (this.loader != null) {
            System.out.println(candidate.name + " Нет вакансии грузчика, попробуйте себя в охране");
            return;
        }
        hr.makeAuditionLoader(candidate);
        Loader loader = director.considerCandidateLoader(hr.successLoadSec);
        this.loader = loader;
    }

    public void invite(CompanyEmployee companyEmployee) {
        hr.considerCandidate(companyEmployee);
    }
}
