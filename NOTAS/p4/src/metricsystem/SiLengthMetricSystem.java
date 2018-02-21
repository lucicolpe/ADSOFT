/**
 *
 */
package metricsystem;

import java.util.Arrays;
import java.util.Collection;

import converter.IMetricSystemConverter;
import converter.MetricSystemConverter;
import java.util.ArrayList;
import java.util.List;
import units.*;

/**
 * @author e340478
 *
 */
public enum SiLengthMetricSystem implements IMetricSystem {
    SYSTEM;

    public final static IPhysicalUnit METER = new LengthMetricUnit("m", 1, SYSTEM);
    public final static IPhysicalUnit KILOMETER = new LengthMetricUnit("km", 1000, SYSTEM);
    public final static IPhysicalUnit MILIMETER = new LengthMetricUnit("mm", 0.001, SYSTEM);

    @Override
    public IPhysicalUnit base() {
        return METER;
    }

    @Override
    public Collection<IPhysicalUnit> units() {
        Collection<IPhysicalUnit> c = Arrays.asList(METER, KILOMETER, MILIMETER);
        return c;
    }

    public static void registerConverter(IMetricSystemConverter converter) {
        if (SiLengthMetricSystem.SYSTEM == converter.sourceSystem()) {
            MetricSystemConverter.registerConverter(converter);
        }
    }

    @Override
    public IMetricSystemConverter getConverter(IMetricSystem to) {
        return MetricSystemConverter.getConverter(SYSTEM, to);
    }

}
