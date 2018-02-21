package converter;

import exceptions.UnknownUnitException;
import magnitude.IMagnitude;
import metricsystem.IMetricSystem;
import units.IPhysicalUnit;

public interface IMetricSystemConverter {
	IMetricSystem sourceSystem();
	IMetricSystem targetSystem();
	IMagnitude transformTo(IMagnitude from, IPhysicalUnit to) throws UnknownUnitException;
	IMetricSystemConverter reverse();
}
