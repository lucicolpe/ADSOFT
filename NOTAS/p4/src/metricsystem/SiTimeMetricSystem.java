/**
 * 
 */
package metricsystem;

import java.util.Arrays;
import java.util.Collection;

import converter.IMetricSystemConverter;
import converter.MetricSystemConverter;
import units.*;

/**
 * @author e340478
 *
 */
public enum SiTimeMetricSystem implements IMetricSystem {
	SYSTEM;
	
	public final static IPhysicalUnit SECOND = new TimeMetricUnit("s", 1, SYSTEM);
	public final static IPhysicalUnit MILISECOND = new TimeMetricUnit("ms", 0.001, SYSTEM);
	public final static IPhysicalUnit HOUR = new TimeMetricUnit("h", 3600, SYSTEM);

	@Override
	public IPhysicalUnit base() {
		return SECOND;
	}

	@Override
	public Collection<IPhysicalUnit> units() {
		Collection<IPhysicalUnit> c = Arrays.asList(SECOND, MILISECOND, HOUR);
		return c;
	}

    public static void registerConverter(IMetricSystemConverter converter) {
        if (SiTimeMetricSystem.SYSTEM == converter.sourceSystem()) {
            MetricSystemConverter.registerConverter(converter);
        }
    }

    @Override
    public IMetricSystemConverter getConverter(IMetricSystem to) {
        return MetricSystemConverter.getConverter(SYSTEM, to);
    }
}
