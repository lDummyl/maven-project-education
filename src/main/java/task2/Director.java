package task2;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface Director  {

    SecretaryImpl chooseSecretary(Collection<SecretaryImpl> candidates);
    public Manager chooseManager(Map<Class<?>, List<Worker>> candidates);
    public void chooseGuard(Map<Class<?>, List<Worker>> candidates);
    public void chooseLawyer(Map<Class<?>, List<Worker>> candidates);
}
