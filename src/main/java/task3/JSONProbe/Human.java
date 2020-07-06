package task3.JSONProbe;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

// Данный класс нужен исключительно для попыток понимания работы с JSON. Потом удалю.
@JsonAutoDetect
public class Human {
    private String message;
    private Place place;



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public void say() {
        System.out.println();
        System.out.println(getMessage() + " , " + getPlace().getName() + "!");
    }
}
