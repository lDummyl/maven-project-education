package CollectionWork;

import java.time.Duration;

public class Timer implements Comparable<Timer>{
    String type;
    Integer size;
    Duration timeToAdd;

    public Timer(String type, Integer size, Duration timeToAdd) {
        this.type = type;
        this.size = size;
        this.timeToAdd = timeToAdd;
    }

    @Override
    public int compareTo(Timer o) {
        return this.timeToAdd.compareTo(o.timeToAdd);
    }
}
