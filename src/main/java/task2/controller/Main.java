package task2.controller;

import task2.model.*;
import task2.util.CandidateGenerator;

import java.util.List;

/**
 * Создать 2 офиса Apple и Google и трудоустроить в них секретарей на конкурсной основе, не модифицируя существующий код.
 * Создать 2 имплементации директора и столько же для HR с разным поведеинем, выраженным количественно. все объекты созадются в Main.
 * для создания кандидатов нужно использовать код из 1 й задачи без переноса и копирования, доработка 1 задачи преветствуется.
 */

public class Main {

    public static void main(String[] args) {
        CandidateGenerator sg = new CandidateGenerator();
        List<Secretary> applicant = sg.generate();

        Hr googleHr = new GoogleHR();
        Hr appleHr = new AppleHR();

        Director googleDirector = new GoogleDirector();
        Director appleDirector = new AppleDirector();

        Secretary googleSecretary = googleDirector.chooseSecretary(googleHr.addSecretaryCandidate(applicant));
        Secretary appleSecretary = appleDirector.chooseSecretary(appleHr.addSecretaryCandidate(applicant));

        Office google = new GoogleOffice(googleDirector, googleHr);
        Office apple = new AppleOffice(appleDirector, appleHr);

        google.invitePeople(googleSecretary);
        apple.invitePeople(appleSecretary);
    }

}
