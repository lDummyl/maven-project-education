package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hr {
	private List<WantAJob> candidates = new ArrayList<>();

	public void interview(WantAJob candidate) {
		if (candidate.passInterview()) {
			candidates.add(candidate);
		}
	}

	public List<Object> selectCandidates(Class<? extends Object> clazz) {



		List<Object> pertain = new ArrayList<>();
		for (WantAJob candidate : candidates) {
            if (clazz.isInstance(candidate)) {
                pertain.add(candidate);
            }
		}
		return pertain;
	}


    // TODO: 8/14/19 so you cant call new Hr().offerRequestedCandidates(Coffee.class)
	public<T extends WantAJob> List<T> offerRequestedCandidates(Class<T> clazz) {
        // TODO: 8/14/19 а тут финт ушами
//        Map<? extends Class<?>, List<Object>> candidatesByClass = candidates.stream().collect(Collectors.groupingBy(Object::getClass));
        Map<Class<?>, List<WantAJob>> candidatesByClass = candidates.stream().collect(Collectors.groupingBy(Object::getClass));
        return (List<T>) candidatesByClass.get(clazz);
    }

    // это так нахальненько и не очень чисто, но уж больго лаконично, из более тривиальных вариантов, все-таки я имел в виду что HR будет инкапулировать в себе листы кандидатов и по требованию директора  их выдавать уже отфильтрованные

    List<Secretary> secretaries;
    List<Lawyer> lawyers;

    // и тд.

	public List<WantAJob> getCandidates() {
		return candidates;
	}
}
