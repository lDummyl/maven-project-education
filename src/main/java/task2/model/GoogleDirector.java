package task2.model;

import java.util.Collection;
import java.util.List;

public class GoogleDirector implements Director{

    @Override
    public Secretary chooseSecretary(Collection<Secretary> candidates) {
        return ((List<Secretary>) candidates).get(0);
    }

}
