package task2;

import task1.Provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProviderEmployee {
    private final Map<Class<?>, List<? extends Employee>> mapProvider = new HashMap<>();
    private final int qty;

    public ProviderEmployee(int qty) {
        this.qty = qty;
        provide();
    }


    private void provide() {
        Provider<Secretary> secretaryProvider = Secretary::new;
        Provider<Lawyer> lawyerProvider = Lawyer::new;
        Provider<Security> securityProvider = Security::new;
        Provider<Accountant> accountantProvider = Accountant::new;

        mapProvider.put(Secretary.class, secretaryProvider.provide(qty));
        mapProvider.put(Lawyer.class, lawyerProvider.provide(qty));
        mapProvider.put(Security.class, securityProvider.provide(qty));
        mapProvider.put(Accountant.class, accountantProvider.provide(qty));
    }

    public Map<Class<?>, List<? extends Employee>> getMapProvider() {
        return mapProvider;
    }
}