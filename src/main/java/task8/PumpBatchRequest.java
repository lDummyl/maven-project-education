package task8;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class PumpBatchRequest {

    public LocalDateTime created;
    public List<Pair> pairs = new ArrayList<>();

    public PumpBatchRequest(LocalDateTime created) {
        this.created = created;
    }
}
