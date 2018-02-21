package converter;

import exceptions.QuantityException;
import exceptions.UnknownUnitException;
import java.util.ArrayList;
import java.util.List;
import magnitude.IMagnitude;
import magnitude.Magnitude;
import metricsystem.IMetricSystem;
import units.IPhysicalUnit;


/**
* Contiene los atributos y métodos de la clase MetricSystemConverter que implementa
* la interfaz IMetricSystemConverter.
* 
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

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

    /**
     * Devuelve el Sistema de origen de la conversión.
     * 
     * Este método devuelve el Sistema de origen de la conversión.
     * 
     * @return sistema de medida a partir del cual se quiere realizar la conversión.
     */
    
    @Override
    public IMetricSystem sourceSystem() {
        return source;
    }
    
    /**
     * Devuelve el Sistema de destino de la conversión.
     * 
     * Este método devuelve el Sistema de destino de la conversión
     * 
     * @return sistema de medida al cual se quiere llegar desoués de realizar la conversión.
     */

    @Override
    public IMetricSystem targetSystem() {
        return target;
    }
    
    /**
     * Devuelve una magnitud después de realizar la conversión.
     * 
     * Este método devuelve una magnitud después de realizar la conversión del sistema fuente a una unidad
     * del sistema destino.
     * 
     * @param from es la magnitud del sistema fuente que se quiere convertir.
     * @param to es el sistema destino al cual se quiere convertir.
     * @throws UnknownUnitException lo devuelve si la unidad no es conocida.
     * @return la nueva magnitud tras la conversión.
     */

    @Override
    public IMagnitude transformTo(IMagnitude from, IPhysicalUnit to) throws UnknownUnitException {
        if (!source.units().contains(from.getUnit())) {
            throw new UnknownUnitException("Can't transform from unit " + from.getUnit());
        } else if (!target.units().contains(to)) {
            throw new UnknownUnitException("Can't transform to unit " + to);
        }
        try {
            IMagnitude m = new Magnitude(from.transformTo(this.source.base()).getValue() * this.multiplier, this.target.base());
            m = m.transformTo(to);
            from = m;
        } catch (QuantityException qe) {
            System.out.println(qe);
        }
        return from;
    }

    /**
     * Devuelve un conversor entre el sistema destino y el sistema fuente.
     * 
     * Este método devuelve un conversor entre el sistema destino y el sistema fuente.
     * 
     * @return el conversor entre el sistema destino y el sistema fuente.
     */
    
    @Override
    public IMetricSystemConverter reverse() {
        if (reverse == null) {
            reverse = new MetricSystemConverter(target, source, 1 / multiplier);
        }
        return reverse;
    }

    /**
     * Se almacena en un registro los conversores de un sistema métrico determinado.
     * 
     * ESte método almacena en un registro los conversores de un sstema métrico determinado.
     * 
     * @param converter es el conversor que queremos almacenar y a partir del cual obtendremos el conversor 
     * entre el sistema destino y el fuente y lo guardaremos en el registro también.
     */
    
    public static void registerConverter(IMetricSystemConverter converter) {
        MetricSystemConverter.converters.add(converter);
        MetricSystemConverter.converters.add(converter.reverse());
    }
    
    /**
     * Obtiene el conversor de un sistema métrico determinado.
     * 
     * Este método obtiene el conversor de un sistema métrico determianado.
     * 
     * @param from es el sistema métrico fuente.
     * @param to es el sistema métrico destino.
     * @return el conversor del sistema métrico fuente al de destino.
     */

    public static IMetricSystemConverter getConverter(IMetricSystem from, IMetricSystem to) {
        for (IMetricSystemConverter msc : converters) {
            if (msc.targetSystem() == to) {
                return msc;
            }
        }
        return null;
    }

}
