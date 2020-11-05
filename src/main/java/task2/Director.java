package task2;

import java.util.Collection;

public interface Director  {

    SecretaryImpl chooseSecretary(Collection<SecretaryImpl> candidates);
}
