package units;

import metricsystem.IMetricSystem;

public class LengthMetricUnit extends MetricUnit {
	
	public LengthMetricUnit(String abbrev, double toBase, IMetricSystem metricSystem) {
		super(abbrev, toBase, Quantity.LENGTH, metricSystem);
	}
}
