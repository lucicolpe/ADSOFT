package units;

import exceptions.QuantityException;
import metricsystem.IMetricSystem;

public abstract class MetricUnit implements IPhysicalUnit {

    private String abbrev;
    private double toBase;
    private Quantity q;
    private IMetricSystem metricSystem;

    public MetricUnit(String abbrev, double toBase, Quantity q, IMetricSystem metricSystem) {
        this.abbrev = abbrev;
        this.toBase = toBase;
        this.q = q;
        this.metricSystem = metricSystem;
    }

    @Override
    public boolean canTransformTo(IPhysicalUnit u) {
        if (this.metricSystem == u.getMetricSystem()) {
            return true;
        } else {
            if (this.getMetricSystem().getConverter(u.getMetricSystem()) != null) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
        if (!canTransformTo(u)) {
            throw new QuantityException("Quantites " + u.getQuantity() + " and " + this.getQuantity() + " are not compatible");
        } else {
            return d * this.toBase / ((MetricUnit) u).toBase;
        }
    }

    @Override
    public Quantity getQuantity() {
        return q;
    }

    @Override
    public String abbrev() {
        return this.abbrev;
    }

    @Override
    public IMetricSystem getMetricSystem() {
        return this.metricSystem;
    }

    @Override
    public String toString() {
        return (this.abbrev + " " + q);
    }

}
