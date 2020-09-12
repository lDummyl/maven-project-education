package task2.model;

import lombok.Data;

@Data
public class SecretaryEmployee implements Secretary {

    private Integer kpi;

    public SecretaryEmployee(Integer kpi) {
        this.kpi = kpi;
    }

    @Override
    public void sayHelloTo(Object o) {
    }
}
