package task7;

import java.util.ArrayList;
import java.util.List;

public class PumpCharacteristicsLoader {

    // Apache Commons
    // Google Guava
    private static List<PumpIMP> pumps = new ArrayList<>();

    // TODO: 9/15/19 следует всеже добавить цену, это важный критерий подбора, проще всего отсортировав насосы
    //  по цене двигаться от меньшего к большему и выбрать первый оказавшийся подходящим по тех параметрам.


    static {
        pumps.add(new PumpIMP("GHN 25/40-130", "-1/24x2 + 1/4x + 29/3", new Double[]{-0.042, 0.25, 9.67}));
        pumps.add(new PumpIMP("GHN 32/120-180", "-13/96x2 + 5/2x - 83/24", new Double[]{-0.135, 2.5, 3.46}));
        pumps.add(new PumpIMP("GHNMbasic II 40-70F", "", new Double[]{-0.042, 0.25, 9.67}));
        pumps.add(new PumpIMP("SANMBASIC II", "", new Double[]{-0.042, 0.25, 9.67}));
        pumps.add(new PumpIMP("CL 4 POLES", "", new Double[]{-0.042, 0.25, 9.67}));
        pumps.add(new PumpIMP("GHN SOL", "", new Double[]{-0.042, 0.25, 9.67}));
        pumps.add(new PumpIMP("GHNM", "", new Double[]{-0.042, 0.25, 9.67}));
        pumps.add(new PumpIMP("NMT SAN PLUS", "", new Double[]{5.4, 8.3, 16.}));
        pumps.add(new PumpIMP("NMT SAN PLUS ER", "", new Double[]{3.2, 6.2, 11.8}));
        pumps.add(new PumpIMP("NMT MINI PRO", "", new Double[]{4., 9.5, 17.2}));
    }

    public static List<PumpIMP> getPumps() {
        return pumps;
    }
}
