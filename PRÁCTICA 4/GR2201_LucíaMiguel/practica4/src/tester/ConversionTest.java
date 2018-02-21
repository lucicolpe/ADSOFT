package tester;

import converter.SiLength2ImperialConverter;
import exceptions.*;
import magnitude.*;
import metricsystem.*;

public class ConversionTest {

    public static void main(String[] args) throws QuantityException, UnknownUnitException {
        Magnitude m = new Magnitude(10, SiLengthMetricSystem.KILOMETER);
        IMagnitude enMillas = null;
        try {
            enMillas = m.transformTo(ImperialLengthMetricSystem.MILE);
        } catch (QuantityException e) {
            System.out.println(e);
        }
        SiLengthMetricSystem.registerConverter(new SiLength2ImperialConverter());
        // Registers the converter and the reverse
        enMillas = m.transformTo(ImperialLengthMetricSystem.MILE);
        System.out.println("En millas = " + enMillas);
        System.out.println("En m = " + enMillas.transformTo(SiLengthMetricSystem.METER));
    }
}
