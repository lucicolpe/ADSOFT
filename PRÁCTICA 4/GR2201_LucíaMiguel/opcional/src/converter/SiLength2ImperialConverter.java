package converter;

import metricsystem.ImperialLengthMetricSystem;
import metricsystem.SiLengthMetricSystem;

/**
* Contiene los métodos de la clase SiLength2ImperialConverter que hereda
* de MetricSystemConverter.
* 
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class SiLength2ImperialConverter extends MetricSystemConverter {
		
	public SiLength2ImperialConverter() {
		super(SiLengthMetricSystem.SYSTEM, ImperialLengthMetricSystem.SYSTEM, 3.28);
	}
}
