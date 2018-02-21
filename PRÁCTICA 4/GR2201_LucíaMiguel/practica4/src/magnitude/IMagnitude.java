package magnitude;

import exceptions.*;
import units.IPhysicalUnit;

/**
* Contiene los métodos declarados de la interfaz IMagnitude.
* 
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/
public interface IMagnitude {
	
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
	IMagnitude add(IMagnitude m) throws QuantityException, UnknownUnitException;
	
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
	IMagnitude subs(IMagnitude m) throws QuantityException, UnknownUnitException;
	
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
	IMagnitude transformTo(IPhysicalUnit c) throws QuantityException, UnknownUnitException;
	
	/**
     * Devuelve la unidad de la magnitud.
     * 
     * Este método devuelve la unidad de la magnitud.
     * 
     * @return la unidad de la magnitud.
     */
	IPhysicalUnit getUnit();
	
	/**
     * Devuelve el valor de la magnitud.
     * 
     * Este método devuelve el valor de la magnitud.
     * 
     * @return el valor de la magnitud.
     */
	double getValue();
}
