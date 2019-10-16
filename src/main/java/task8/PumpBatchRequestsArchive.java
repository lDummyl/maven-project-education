package task8;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@NoArgsConstructor
public class PumpBatchRequestsArchive {

    public LocalDateTime firstCreated;
    public LocalDateTime lastCreated;
    public Integer pairsOverall;
    public List<PumpBatchRequest> requests = new ArrayList<>();

    public PumpBatchRequestsArchive(LocalDateTime firstCreated, LocalDateTime lastCreated, Integer pairsOverall) {
        this.firstCreated = firstCreated;
        this.lastCreated = lastCreated;
        this.pairsOverall = pairsOverall;
    }

    public int getPairsOverall() {
        Optional<Integer> qty = requests.stream().flatMap(Stream::of).map(i -> i.pairs.size()).reduce(Integer::sum);
        return qty.orElse(0);
    }
}
