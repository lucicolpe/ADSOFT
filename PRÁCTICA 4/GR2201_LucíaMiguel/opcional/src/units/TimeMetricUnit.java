package units;

import metricsystem.IMetricSystem;

/**
* Contiene los métodos de la clase TimeMetricUnit que hereda
* de MetricUnit.
* 
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class TimeMetricUnit extends MetricUnit {

	public TimeMetricUnit(String abbrev, double toBase, IMetricSystem metricSystem) {
		super(abbrev, toBase, Quantity.TIME, metricSystem);
	}
}
