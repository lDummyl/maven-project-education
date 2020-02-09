package task2;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HR extends CompanyEmployee {

    List<Secretary> successCandidates = new ArrayList<>();
    List<Loader> successLoadSec = new ArrayList<>();
    List<CompanyEmployee> loosers = new ArrayList<>();


    public HR(String name) {
        super(name);
    }

    @Override
    public boolean passInterview() {
        return true;
    }

    public void makeAuditionLoader(Loader candidate) {
//        boolean result = candidate.passInterview();
        if (candidate.name.contains("ina")) {
            System.out.println(candidate.name + ", Мы можем предложить Вам только вакансии юриста, бухгалтера или секретаря");
//            boolean result = candidate.passInterview();   Каким образом можно добавить этих кандидатов в список successAllCandidates
//            if(result){successAllCandidates.add(candidate);}
        } else {
            System.out.println(" Запишу Вас в список на пэту позицию");
            successLoadSec.add(candidate);
        }
    }

    public void makeAudition(Secretary candidate) {
        boolean result = candidate.passInterview();
        if (result) {
            System.out.println("Thank you " + candidate.name + " you will meet Director");
            successCandidates.add(candidate);
        } else {
            System.out.println("Thank you " + candidate.name + " we will call you back!");
        }
    }

    public void considerCandidate(CompanyEmployee candidate) {
        boolean result = candidate.passInterview();
        if (result) {
            if (candidate instanceof Secretary) {
                successCandidates.add((Secretary) candidate);
            }
            if (candidate instanceof Loader) {
                successLoadSec.add((Loader) candidate);
            }
        } else {
            loosers.add(candidate);
            System.out.println("Спасибо " + candidate.name + " Мы Вам перезвоним"); //При рандоме на ошибка
        }
    }
}

