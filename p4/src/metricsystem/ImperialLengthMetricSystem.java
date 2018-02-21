package metricsystem;

import java.util.Arrays;
import java.util.Collection;
import converter.IMetricSystemConverter;
import converter.MetricSystemConverter;
import java.util.ArrayList;
import java.util.List;
import units.*;

public enum ImperialLengthMetricSystem implements IMetricSystem {
    SYSTEM;

    public final static IPhysicalUnit FOOT = new LengthMetricUnit("ft", 1, SYSTEM);
    public final static IPhysicalUnit MILE = new LengthMetricUnit("ml", 5280, SYSTEM);

    @Override
    public IPhysicalUnit base() {
        return FOOT;
    }

    @Override
    public Collection<IPhysicalUnit> units() {
        Collection<IPhysicalUnit> c = Arrays.asList(FOOT,MILE);
        return c;
    }

    public static void registerConverter(IMetricSystemConverter converter) {
        if (ImperialLengthMetricSystem.SYSTEM == converter.sourceSystem()) {
            MetricSystemConverter.registerConverter(converter);
        }
    }

    @Override
    public IMetricSystemConverter getConverter(IMetricSystem to) {
        return MetricSystemConverter.getConverter(SYSTEM, to);
    }

}
