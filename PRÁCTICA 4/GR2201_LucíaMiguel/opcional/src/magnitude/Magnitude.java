package magnitude;

import exceptions.QuantityException;
import exceptions.UnknownUnitException;
import units.*;

/**
* Contiene los atributos y métodos de la clase Magnitude que implementa la
* interfaz IMagnitude.
* 
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class Magnitude implements IMagnitude {

    double value;
    IPhysicalUnit unit;

    public Magnitude(double value, IPhysicalUnit unit) {
        this.value = value;
        this.unit = unit;
    }
    
    /**
     * Añade una nueva magnitud.
     * 
     * Este método añade la magnitud que se pasa como parámetro a la unidad de la magnitud que
     * recibe la invocación, realiza la operación, lo modifica y devuelve el objeto.
     * 
     * @param m es la magnitud que se va a transformar.
     * @throws  QuantityException lo devuelve si no se puede realizar correctamente la transformación.
     * @throws UnknownUnitException lo devuelve si la unidad no es conocida.
     * @return la magnitud pasada por parámetro pero modificada.
     */

    @Override
    public IMagnitude add(IMagnitude m) throws QuantityException, UnknownUnitException {
        if (!this.unit.canTransformTo(m.getUnit())) {
            throw new QuantityException("Quantites " + this.getUnit().getQuantity() + " and " + m.getUnit().getQuantity() + " are not compatible");
        }
        IMagnitude n = new Magnitude(m.getValue(), m.getUnit());
        /*Copiamos m para transformarla sin modificar la original*/
        n.transformTo(this.unit);
        this.value = this.value + n.getValue();
        return this;
    }

    /**
     * Resta una magnitud.
     * 
     * Este método resta	 la magnitud que se pasa como parámetro a la unidad de la magnitud que
     * recibe la invocación, realiza la operación, lo modifica y devuelve el objeto.
     * 
     * @param m es la magnitud que se va a transformar.
     * @throws  QuantityException lo devuelve si no se puede realizar correctamente la transformación.
     * @throws UnknownUnitException lo devuelve si la unidad no es conocida.
     * @return la magnitud pasada por parámetro pero modificada.
     */
    
    @Override
    public IMagnitude subs(IMagnitude m) throws QuantityException, UnknownUnitException {
        if (!this.unit.canTransformTo(m.getUnit())) {
            throw new QuantityException("Quantites " + this.getUnit().getQuantity() + " and " + m.getUnit().getQuantity() + " are not compatible");
        }
        IMagnitude n = new Magnitude(m.getValue(), m.getUnit());
        /*Copiamos m para transformarla sin modificar la original*/
        n.transformTo(this.unit);
        this.value = this.value - n.getValue();
        return this;
    }
    
    /**
     * Transforma la magnitud a otra unidad.
     * 
     * Este método tranforma la magnitud a otra unidad.
     * 
     * @param c es la unidad a la que vamos a transformar la magnitud.
     * @throws  QuantityException lo devuelve si no se puede realizar correctamente la transformación.
     * @throws UnknownUnitException lo devuelve si la unidad no es conocida.
     * @return la magnitud transformada a la nueva unidad.
     */

    @Override
    public IMagnitude transformTo(IPhysicalUnit c) throws QuantityException, UnknownUnitException {
        if (this.unit.getMetricSystem() == c.getMetricSystem()) {
            this.value = this.unit.transformTo(this.value, c);
            this.unit = c;
            return this;
        } else {
            if (!this.unit.canTransformTo(c)) {
                throw new QuantityException("Cannot transform " + this.getUnit() + " to " + c);
            }
            return this.unit.getMetricSystem().getConverter(c.getMetricSystem()).transformTo(this, c);
        }
    }
    
    /**
     * Devuelve la unidad de la magnitud.
     * 
     * Este método devuelve la unidad de la magnitud.
     * 
     * @return la unidad de la magnitud.
     */
    @Override
    public IPhysicalUnit getUnit() {
        return this.unit;
    }

    /**
     * Devuelve el valor de la magnitud.
     * 
     * Este método devuelve el valor de la magnitud.
     * 
     * @return el valor de la magnitud.
     */
    
    @Override
    public double getValue() {
        return this.value;
    }
    
    @Override
    public String toString() {
        return value + " [" + unit + "]";
    }

}
