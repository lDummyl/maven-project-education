package task2;

import task1.Provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProviderEmployee {
    private Map<Class<?>, List<? extends Employee>> mapProvider = new HashMap<>();
    private int qty;

    public ProviderEmployee(int qty) {
        this.qty = qty;
    }


    public Map<Class<?>, List<? extends Employee>> provide() {
      Map<Class<?>, List<? extends Employee>> result = new HashMap<>();

		Provider<Secretary> secretaryProvider = Secretary::new;
		Provider<Lawyer> lawyerProvider = Lawyer::new;
		Provider<Security> securityProvider = Security::new;
		Provider<Accountant> accountantProvider = Accountant::new;

		result.put(Secretary.class, secretaryProvider.provide(qty));
		result.put(Lawyer.class, lawyerProvider.provide(qty));
		result.put(Security.class, securityProvider.provide(qty));
		result.put(Accountant.class, accountantProvider.provide(qty));

		return result;
    }


}