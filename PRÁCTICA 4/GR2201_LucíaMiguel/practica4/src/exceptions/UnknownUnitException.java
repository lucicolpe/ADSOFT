package exceptions;

/**
* Contiene el método de la clase UnknownUnitException que hereda
* de Exception.
* 
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class UnknownUnitException extends Exception {

	/**
	 * Lanza una excepción cuando no se conoce la unidad de transformación.
	 * 
	 * Este método lanza una excepción cuando no se conoce la unidad de transformación.
	 * 
	 * @param msg es el mensaje que queremos que nos notifique.
	 */
	
	public UnknownUnitException(String msg) {
		super(msg);
	}

}
