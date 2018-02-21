package converter;

import exceptions.UnknownUnitException;
import magnitude.IMagnitude;
import metricsystem.IMetricSystem;
import units.IPhysicalUnit;

/**
* Contiene los métodos declarados de la interfaz IMetricSystemConverter.
* 
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public interface IMetricSystemConverter {
	/**
     * Devuelve el Sistema de origen de la conversión.
     * 
     * Este método devuelve el Sistema de origen de la conversión.
     * 
     * @return sistema de medida a partir del cual se quiere realizar la conversión.
     */
	IMetricSystem sourceSystem();
	
	/**
     * Devuelve el Sistema de destino de la conversión.
     * 
     * Este método devuelve el Sistema de destino de la conversión
     * 
     * @return sistema de medida al cual se quiere llegar desoués de realizar la conversión.
     */
	IMetricSystem targetSystem();
	
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
	IMagnitude transformTo(IMagnitude from, IPhysicalUnit to) throws UnknownUnitException;
	
	/**
     * Devuelve un conversor entre el sistema destino y el sistema fuente.
     * 
     * Este método devuelve un conversor entre el sistema destino y el sistema fuente.
     * 
     * @return el conversor entre el sistema destino y el sistema fuente.
     */
	IMetricSystemConverter reverse();
}
