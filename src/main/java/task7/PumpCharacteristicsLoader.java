package task7;

import task6.LagrangePolynomial;

import java.util.ArrayList;
import java.util.List;

public class PumpCharacteristicsLoader {

    // Apache Commons
    // Google Guava
    private static List<PumpIMP> pumps = new ArrayList<>();

    static {
        pumps.add(new PumpIMP("GHN 25/40-130", 40000.,
                new LagrangePolynomial.SquareInterpolation(6.7, 0.7, 5.1)));
        pumps.add(new PumpIMP("GHN 32/120-180", 35000.,
                new LagrangePolynomial.SquareInterpolation(9.9, 10.1, 10.3)));
        pumps.add(new PumpIMP("GHNMbasic II 40-70F", 32000.,
                new LagrangePolynomial.SquareInterpolation(24.7, 15.2, 7.7)));
        pumps.add(new PumpIMP("SANMBASIC II", 28000.,
                new LagrangePolynomial.SquareInterpolation(4.8, 12.1, 3.5)));
        pumps.add(new PumpIMP("CL 4 POLES", 24000.,
                new LagrangePolynomial.SquareInterpolation(6.1, 16.6, 9.5)));
        pumps.add(new PumpIMP("GHN SOL", 20000.,
                new LagrangePolynomial.SquareInterpolation(1.8, 98., 3.3, 64., 15.2, 39.)));
        pumps.add(new PumpIMP("GHNM", 18000.,
                new LagrangePolynomial.SquareInterpolation(10., 890., 14.4, 280., 21.8, 61.)));
        pumps.add(new PumpIMP("NMT SAN PLUS", 11000.,
                new LagrangePolynomial.SquareInterpolation(5.4, 8.3, 16.)));
        pumps.add(new PumpIMP("NMT SAN PLUS ER", 14000.,
                new LagrangePolynomial.SquareInterpolation(3.2, 27.4, 6.2, 20.1, 9.8, 14.6)));
        pumps.add(new PumpIMP("NMT MINI PRO", 10000.,
                new LagrangePolynomial.SquareInterpolation(4., 9.5, 17.2)));
        pumps.add(new PumpIMP("NMTD PLUS", 9500.,
                new LagrangePolynomial.SquareInterpolation(6., 14.2, 10.2, 13.3, 14.3, 12.6)));
        pumps.add(new PumpIMP("NMTD SMART", 9000.,
                new LagrangePolynomial.SquareInterpolation(7.4, 17.4, 8.9, 14.6, 12.8, 11.2)));
        pumps.add(new PumpIMP("NMTD SMART C F", 8500.,
                new LagrangePolynomial.SquareInterpolation(3.3, 25.5, 5.5, 21.1, 9.9, 17.7)));
        pumps.add(new PumpIMP("NMTD MAX C", 8000.,
                new LagrangePolynomial.SquareInterpolation(13.6, 44., 16.3, 37., 19.1, 29.)));
        pumps.add(new PumpIMP("GHNDBASIC II", 6000.,
                new LagrangePolynomial.SquareInterpolation(2., 22., 4., 16., 6., 12.)));
    }

    public static List<PumpIMP> getPumps() {
        return pumps;
    }
}
