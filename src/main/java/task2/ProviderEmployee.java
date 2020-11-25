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
		provide(Secretary.class);
		provide(Security.class);
		provide(Lawyer.class);
		provide(Accountant.class);
    }


    /*public Map<Class<?>, List<? extends Employee>> provide() {
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
    }*/

    private <T extends Employee> void provide(Class<T> clz) {
        Provider<T> provider = () -> {
            try {
                return clz.newInstance();  //sonar почему то говорит что этот метод деприкейт(опять говнокод написал?)
            } catch (Exception e) {
                throw new RuntimeException("Something went wrong");
            }
        };
        mapProvider.put(clz, provider.provide(this.qty));
    }

    public Map<Class<?>, List<? extends Employee>> getMapProvider() {
        return mapProvider;
    }

    public static void main(String[] args) {
        ProviderEmployee providerEmployee = new ProviderEmployee(2);
        System.out.println(providerEmployee.getMapProvider());
    }
}