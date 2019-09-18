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
        pumps.add(new PumpIMP("GHN 25/40-130", 40000., "-1/24x2 + 1/4x + 29/3", new Double[]{6.7, 0.7, 5.1}));
        pumps.add(new PumpIMP("GHN 32/120-180", 35000., "-13/96x2 + 5/2x - 83/24", new Double[]{9.9, 10.1, 10.3}));
        pumps.add(new PumpIMP("GHNMbasic II 40-70F", 32000., "", new Double[]{24.7, 15.2, 7.7}));
        pumps.add(new PumpIMP("SANMBASIC II", 28000., "", new Double[]{4.8, 12.1, 3.5}));
        pumps.add(new PumpIMP("CL 4 POLES", 24000., "", new Double[]{6.1, 16.6, 9.5}));
        pumps.add(new PumpIMP("GHN SOL", 20000., "", new Double[]{1.8, 3.3, 15.2}));
        pumps.add(new PumpIMP("GHNM", 18000., "", new Double[]{10., 14.4, 21.8}));
        pumps.add(new PumpIMP("NMT SAN PLUS", 11000., "", new Double[]{5.4, 8.3, 16.}));
        pumps.add(new PumpIMP("NMT SAN PLUS ER", 14000., "", new Double[]{3.2, 6.2, 11.8}));
        pumps.add(new PumpIMP("NMT MINI PRO", 10000., "", new Double[]{4., 9.5, 17.2}));
        pumps.add(new PumpIMP("NMTD PLUS", 9500., "", new Double[]{6., 10.2, 14.3}, new Double[]{412., 1322.5, 3654.7}));
        pumps.add(new PumpIMP("NMTD SMART", 9000., "", new Double[]{7.4, 8.9, 12.8}, new Double[]{547.2, 976.3, 2600.}));
        pumps.add(new PumpIMP("NMTD SMART C F", 8500., "", new Double[]{3.3, 5.5, 9.9}, new Double[]{279.9, 402.5, 1153.6}));
        pumps.add(new PumpIMP("NMTD MAX C", 8000., "", new Double[]{13.6, 16.3, 19.1}, new Double[]{3112.136, 5177.7, 8120.6}));
        pumps.add(new PumpIMP("GHNDBASIC II", 6000., "", new Double[]{2.8, 8.4, 11.6}, new Double[]{244.5, 610., 1524.7}));
    }

    public static List<PumpIMP> getPumps() {
        return pumps;
    }
}
