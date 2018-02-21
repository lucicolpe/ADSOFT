package exceptions;

/**
* Contiene el método de la clase QuantityException que hereda
* de Exception.
* 
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class QuantityException extends Exception {
	
	/**
	 * Lanza una excepción cuando no se puede relizar la transformación de una unidad a otra.
	 * 
	 * Este método lanza una excepción cuando no se puede relizar la transformación de una unidad a otra.
	 * 
	 * @param msg es el mensaje que queremos que nos notifique.
	 */
	
	public QuantityException(String msg) {
		super(msg);
	}
}
