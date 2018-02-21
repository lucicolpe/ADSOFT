package metricsystem;

import java.util.Collection;

import converter.IMetricSystemConverter;
import units.IPhysicalUnit;

public interface IMetricSystem {
	IPhysicalUnit base();
	Collection<IPhysicalUnit> units();
	IMetricSystemConverter getConverter(IMetricSystem to);
}
