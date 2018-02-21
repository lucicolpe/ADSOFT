package units;

import exceptions.QuantityException;
import exceptions.UnknownUnitException;
import metricsystem.IMetricSystem;

/**
* Contiene los métodos y atributos de la clase MetricUnit que implementa
* la interfaz IPhysicalUnit.
* 
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

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

    /**
     * Devuleve si se puede o no transformar a la unidad que se pasa como parámetro.
     * 
     * Este método devuleve si se puede o no transformar a la unidad que se pasa como parámetro.
     * 
     * @param u es la unidad a transformar.
     * @return true si se puede transformar o false si no se puede.
     */
    
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
    
    /**
     * Transforma la unidad.
     * 
     * Este método tranforma la unidad a otra unidad.
     * 
     * @param d valor de la unidad.
     * @param u es la unidad a la que la vamos a transformar.
     * @throws  QuantityException lo devuelve si no se puede realizar correctamente la transformación.
     * @return el valor de la unidad transformada a la nueva unidad.
     */

    @Override
    public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
        if (!canTransformTo(u)) {
            if (this.getQuantity() == u.getQuantity()) {
                throw new QuantityException("Cannot transform " + this + " to " + u);
            } else {
                throw new QuantityException("Quantites " + u.getQuantity() + " and " + this.getQuantity() + " are not compatible");
            }
        } else {
            return d * this.toBase / ((MetricUnit) u).toBase;
        }
    }
    
    /**
     * Devuelve la cantidad de la unidad.
     * 
     * Este método devuelve la cantidad de la unidad.
     * 
     * @return la cantidad de la unidad.
     */

    @Override
    public Quantity getQuantity() {
        return q;
    }
    
    /**
     * Devuelve la abreviatura de la unidad.
     * 
     * Este método devuelve la abreviatura de la unidad.
     * 
     * @return la abreviatura.
     */

    @Override
    public String abbrev() {
        return this.abbrev;
    }
    
    /**
     * Devuelve el sistema métrico.
     * 
     * Este método devuelve el sistema métrico.
     * 
     * @return el sistema metrico.
     */

    @Override
    public IMetricSystem getMetricSystem() {
        return this.metricSystem;
    }

    @Override
    public String toString() {
        return (this.abbrev + " " + q);
    }

}
