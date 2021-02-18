package task2;

import java.util.Collection;

public interface Director  {

    Secretary chooseSecretary(Collection<Secretary> candidates);

}
