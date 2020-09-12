package task2.model;

import java.util.Collection;
import java.util.List;

public class GoogleHR implements Hr {

    @Override
    public Collection<Secretary> addSecretaryCandidate(Object candidate) {
        List<SecretaryEmployee> secretaryEmployees = (List<SecretaryEmployee>) candidate;
        secretaryEmployees.sort((s1, s2) -> s2.getKpi() - s1.getKpi());
        return (Collection<Secretary>) candidate;
    }

}
