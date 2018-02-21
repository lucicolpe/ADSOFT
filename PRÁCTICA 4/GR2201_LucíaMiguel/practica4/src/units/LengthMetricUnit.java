package units;

import metricsystem.IMetricSystem;

/**
* Contiene los métodos de la clase LengthMetricUnit que hereda
* de MetricUnit.
* 
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class LengthMetricUnit extends MetricUnit {
	
	public LengthMetricUnit(String abbrev, double toBase, IMetricSystem metricSystem) {
		super(abbrev, toBase, Quantity.LENGTH, metricSystem);
	}
}
