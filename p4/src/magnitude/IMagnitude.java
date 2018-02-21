package magnitude;

import exceptions.*;
import units.IPhysicalUnit;

public interface IMagnitude {
	IMagnitude add(IMagnitude m) throws QuantityException;
	IMagnitude subs(IMagnitude m) throws QuantityException;
	IMagnitude transformTo(IPhysicalUnit c) throws QuantityException, UnknownUnitException;
	IPhysicalUnit getUnit();
	double getValue();
}
