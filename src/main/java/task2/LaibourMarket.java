package task2;

import java.util.ArrayList;
import java.util.List;

public class LaibourMarket  {

    public <T extends Employee> List<T> provideEmployee(int qty, Class<T> tClass) {
        if (tClass == Accountant.class) {
            // TODO: 3/21/20 сделай N бухгалтеров и положи в этот лист
            return new ArrayList<>();
        }

        // TODO: 3/21/20 по всем остальным классам аналогично

        return null; // TODO: 3/21/20 это заменить
    }
}
