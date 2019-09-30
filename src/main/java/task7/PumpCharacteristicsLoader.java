package task7;

import task6.LagrangePolynomial;

import java.util.ArrayList;
import java.util.List;

public class PumpCharacteristicsLoader {

    // Apache Commons
    // Google Guava
    private static List<PumpIMP> pumps = new ArrayList<>();

    static {
        pumps.add(new PumpIMP("GHN 25/40-130", 40000., "-1/24x2 + 1/4x + 29/3",
                new LagrangePolynomial.SquareInterpolation(6.7, 0.7, 5.1)));
        pumps.add(new PumpIMP("GHN 32/120-180", 35000., "-13/96x2 + 5/2x - 83/24",
                new LagrangePolynomial.SquareInterpolation(9.9, 10.1, 10.3)));
        pumps.add(new PumpIMP("GHNMbasic II 40-70F", 32000., "",
                new LagrangePolynomial.SquareInterpolation(24.7, 15.2, 7.7)));
        pumps.add(new PumpIMP("SANMBASIC II", 28000., "",
                new LagrangePolynomial.SquareInterpolation(4.8, 12.1, 3.5)));
        pumps.add(new PumpIMP("CL 4 POLES", 24000., "",
                new LagrangePolynomial.SquareInterpolation(6.1, 16.6, 9.5)));
        pumps.add(new PumpIMP("GHN SOL", 20000., "",
                new LagrangePolynomial.SquareInterpolation(1.8, 3.3, 15.2)));
        pumps.add(new PumpIMP("GHNM", 18000., "",
                new LagrangePolynomial.SquareInterpolation(10., 14.4, 21.8)));
        pumps.add(new PumpIMP("NMT SAN PLUS", 11000., "",
                new LagrangePolynomial.SquareInterpolation(5.4, 8.3, 16.)));
        pumps.add(new PumpIMP("NMT SAN PLUS ER", 14000., "",
                new LagrangePolynomial.SquareInterpolation(3.2, 6.2, 11.8)));
        pumps.add(new PumpIMP("NMT MINI PRO", 10000., "",
                new LagrangePolynomial.SquareInterpolation(4., 9.5, 17.2)));
        pumps.add(new PumpIMP("NMTD PLUS", 9500., "",
                new LagrangePolynomial.SquareInterpolation(6., 412., 10.2, 1322.5, 14.3, 3654.7)));
        pumps.add(new PumpIMP("NMTD SMART", 9000., "",
                new LagrangePolynomial.SquareInterpolation(7.4, 547.2, 8.9, 976.3, 12.8, 2600.)));
        pumps.add(new PumpIMP("NMTD SMART C F", 8500., "",
                new LagrangePolynomial.SquareInterpolation(3.3, 279.9, 5.5, 402.5, 9.9, 1153.6)));
        pumps.add(new PumpIMP("NMTD MAX C", 8000., "",
                new LagrangePolynomial.SquareInterpolation(13.6, 3112.136, 16.3, 5177.7, 19.1, 8120.6)));
        pumps.add(new PumpIMP("GHNDBASIC II", 6000., "",
                new LagrangePolynomial.SquareInterpolation(2., 22., 4., 16., 6., 12.)));
    }

    public static List<PumpIMP> getPumps() {
        return pumps;
    }
}
