package metricsystem;

import java.util.Collection;

import converter.IMetricSystemConverter;
import units.IPhysicalUnit;

/**
* Contiene los  métodos declarados de la interfaz IMetricSystem.
* 
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public interface IMetricSystem {
	
	 /**
     * Devuelve la unidad de base.
     * 
     * Este método devuelve la unidad de base del sistema métrico Imperial de longitud.
     * 
     * @return la unidad de base del sistema métrico Imperial de longitud.
     */
	IPhysicalUnit base();
	
	/**
     * Devuelve la lista de unidades.
     * 
     * Este método devuelve la lista de unidades del sistema métrico Imperial de longitud.
     * 
     * @return la lista de unidades del sistema métrico Imperial de longitud.
     */
	Collection<IPhysicalUnit> units();
	
	/**
     * Obtiene el conversor de un sistema métrico determinado.
     * 
     * Este método obtiene el conversor de un sistema métrico determianado.
     * 
     * @param to es el sistema métrico destino.
     * @return el conversor del sistema métrico fuente al de destino.
     */
	IMetricSystemConverter getConverter(IMetricSystem to);
}
