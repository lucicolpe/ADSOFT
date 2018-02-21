
package metricsystem;

import java.util.Arrays;
import java.util.Collection;

import converter.IMetricSystemConverter;
import converter.MetricSystemConverter;
import java.util.ArrayList;
import java.util.List;
import units.*;

/**
* Contiene los atributos y métodos de la enum SiLengthMetricSystem que implementa
* de IMetricSystem.
* 
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/
public enum SiLengthMetricSystem implements IMetricSystem {
    SYSTEM;

    public final static IPhysicalUnit METER = new LengthMetricUnit("m", 1, SYSTEM);
    public final static IPhysicalUnit KILOMETER = new LengthMetricUnit("km", 1000, SYSTEM);
    public final static IPhysicalUnit MILIMETER = new LengthMetricUnit("mm", 0.001, SYSTEM);

    /**
     * Devuelve la unidad de base.
     * 
     * Este método devuelve la unidad de base del sistema métrico de longitud.
     * 
     * @return la unidad de base del sistema métrico de longitud.
     */
    
    @Override
    public IPhysicalUnit base() {
        return METER;
    }
    
    /**
     * Devuelve la lista de unidades.
     * 
     * Este método devuelve la lista de unidades del sistema métrico de longitud.
     * 
     * @return la lista de unidades del sistema métrico de longitud.
     */

    @Override
    public Collection<IPhysicalUnit> units() {
        Collection<IPhysicalUnit> c = Arrays.asList(METER, KILOMETER, MILIMETER);
        return c;
    }
    
    /**
     * Se almacena en un registro los conversores de un sistema métrico determinado.
     * 
     * ESte método almacena en un registro los conversores de un sistema métrico determinado.
     * 
     * @param converter es el conversor que queremos almacenar y a partir del cual obtendremos el conversor 
     * entre el sistema destino y el fuente y lo guardaremos en el registro también.
     */

    public static void registerConverter(IMetricSystemConverter converter) {
        if (SiLengthMetricSystem.SYSTEM == converter.sourceSystem()) {
            MetricSystemConverter.registerConverter(converter);
        }
    }
    
    /**
     * Obtiene el conversor de un sistema métrico determinado.
     * 
     * Este método obtiene el conversor de un sistema métrico determianado.
     * 
     * @param to es el sistema métrico destino.
     * @return el conversor del sistema métrico fuente al de destino.
     */

    @Override
    public IMetricSystemConverter getConverter(IMetricSystem to) {
        return MetricSystemConverter.getConverter(SYSTEM, to);
    }

}
