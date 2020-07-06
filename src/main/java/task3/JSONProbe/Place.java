package task3.JSONProbe;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Place {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
