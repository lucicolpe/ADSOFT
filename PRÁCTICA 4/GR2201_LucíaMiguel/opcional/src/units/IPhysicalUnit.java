package units;

import exceptions.QuantityException;
import metricsystem.IMetricSystem;

/**
* Contiene los métodos declarados de la interfaz IPhysicalUnit.
* 
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public interface IPhysicalUnit {
	
	/**
     * Devuleve si se puede o no transformar a la unidad que se pasa como parámetro.
     * 
     * Este método devuleve si se puede o no transformar a la unidad que se pasa como parámetro.
     * 
     * @param u es la unidad a transformar.
     * @return true si se puede transformar o false si no se puede.
     */
	boolean canTransformTo(IPhysicalUnit u);
	
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
	double transformTo(double d, IPhysicalUnit u) throws QuantityException;
	
	/**
     * Devuelve la cantidad de la unidad.
     * 
     * Este método devuelve la cantidad de la unidad.
     * 
     * @return la cantidad de la unidad.
     */
	Quantity getQuantity();
	
	/**
     * Devuelve la abreviatura de la unidad.
     * 
     * Este método devuelve la abreviatura de la unidad.
     * 
     * @return la abreviatura.
     */
	String abbrev();
	
	/**
     * Devuelve el sistema métrico.
     * 
     * Este método devuelve el sistema métrico.
     * 
     * @return el sistema metrico.
     */
	IMetricSystem getMetricSystem();
}
