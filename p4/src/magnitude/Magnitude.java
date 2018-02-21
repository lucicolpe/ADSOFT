package magnitude;

import exceptions.QuantityException;
import exceptions.UnknownUnitException;
import units.*;

public class Magnitude implements IMagnitude {

    double value;
    IPhysicalUnit unit;

    public Magnitude(double value, IPhysicalUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public IMagnitude add(IMagnitude m) throws QuantityException {
        if (!this.unit.canTransformTo(m.getUnit())) {
            throw new QuantityException("Quantites " + this.getUnit().getQuantity() + " and " + m.getUnit().getQuantity() + " are not compatible");
        }
        this.value = this.value + m.getUnit().transformTo(m.getValue(), this.unit);
        return this;
    }

    @Override
    public IMagnitude subs(IMagnitude m) throws QuantityException {
        if (!this.unit.canTransformTo(m.getUnit())) {
            throw new QuantityException("Quantites " + this.getUnit().getQuantity() + " and " + m.getUnit().getQuantity() + " are not compatible");
        }
        this.value = this.value - m.getUnit().transformTo(m.getValue(), this.unit);
        return this;
    }

    @Override
    public IMagnitude transformTo(IPhysicalUnit c) throws QuantityException, UnknownUnitException {
        if (!this.unit.canTransformTo(c)) {
            throw new QuantityException("Quantites " + this.getUnit().getQuantity() + " and " + c.getQuantity() + " are not compatible");
        }
        if (this.unit.getMetricSystem() == c.getMetricSystem()) {
            this.value = this.unit.transformTo(this.value, c);
            this.unit = c;
            return this;
        } else {
            return this.unit.getMetricSystem().getConverter(c.getMetricSystem()).transformTo(this, c);
        }
    }

    @Override
    public IPhysicalUnit getUnit() {
        return this.unit;
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return value + " [" + unit + "]";
    }

}
