package converter;

import metricsystem.ImperialLengthMetricSystem;
import metricsystem.SiLengthMetricSystem;

public class SiLength2ImperialConverter extends MetricSystemConverter {
	
	public SiLength2ImperialConverter() {
		super(SiLengthMetricSystem.SYSTEM, ImperialLengthMetricSystem.SYSTEM, 3.28);
	}
}
