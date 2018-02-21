package units;

import metricsystem.IMetricSystem;

public class TimeMetricUnit extends MetricUnit {

	public TimeMetricUnit(String abbrev, double toBase, IMetricSystem metricSystem) {
		super(abbrev, toBase, Quantity.TIME, metricSystem);
	}
}
