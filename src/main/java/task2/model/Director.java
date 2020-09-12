package task2.model;

import java.util.Collection;

public interface Director  {

    Secretary chooseSecretary(Collection<Secretary> candidates);

}
