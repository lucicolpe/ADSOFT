package converter;

import exceptions.QuantityException;
import exceptions.UnknownUnitException;
import java.util.ArrayList;
import java.util.List;
import magnitude.IMagnitude;
import magnitude.Magnitude;
import metricsystem.IMetricSystem;
import units.IPhysicalUnit;

public class MetricSystemConverter implements IMetricSystemConverter {

    private IMetricSystem source;
    private IMetricSystem target;
    private double multiplier;
    private IMetricSystemConverter reverse;
    private static List<IMetricSystemConverter> converters = new ArrayList<IMetricSystemConverter>();

    public MetricSystemConverter(IMetricSystem source, IMetricSystem target, double multiplier) {
        this.source = source;
        this.target = target;
        this.multiplier = multiplier;
    }

    @Override
    public IMetricSystem sourceSystem() {
        return source;
    }

    @Override
    public IMetricSystem targetSystem() {
        return target;
    }

    @Override
    public IMagnitude transformTo(IMagnitude from, IPhysicalUnit to) throws UnknownUnitException {
        IMagnitude mag = null;
        if (!source.units().contains(from.getUnit()) || !target.units().contains(to)) {
            throw new UnknownUnitException("Unknown unit");
        }
        try {
            mag = new Magnitude(from.transformTo(this.source.base()).getValue() * this.multiplier, this.target.base());
            mag = mag.transformTo(to);
        } catch (QuantityException qe) {
            System.out.println(qe);
        }
        return mag;
    }

    @Override
    public IMetricSystemConverter reverse() {
        if (reverse == null) {
            reverse = new MetricSystemConverter(target, source, 1 / multiplier);
        }
        return reverse;
    }

    public static void registerConverter(IMetricSystemConverter converter) {
        MetricSystemConverter.converters.add(converter);
        MetricSystemConverter.converters.add(converter.reverse());
    }

    public static IMetricSystemConverter getConverter(IMetricSystem from, IMetricSystem to) {
        for (IMetricSystemConverter msc : converters) {
            if (msc.targetSystem() == to) {
                return msc;
            }
        }
        return null;
    }

}
