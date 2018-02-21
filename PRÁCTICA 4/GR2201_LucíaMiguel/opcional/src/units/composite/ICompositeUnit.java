package units.composite;

import units.IPhysicalUnit;

/**
* Contiene los métodos dedeclarados de la interfaz ICompositeUnit.
* 
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/
public interface ICompositeUnit extends IPhysicalUnit {
	
	/**
     * Devuelve el operador aritmético.
     * 
     * Este método devuelve el operador aritmético.
     * 
     * @return el operador aritmético.
     */
    Operator getOperator();
    
    /**
     * Devuelve la unidad de la izquierda.
     * 
     * Este método devuelve la unidad de la izquierda.
     * 
     * @return la unidad de la izquierda.
     */
    IPhysicalUnit getLeftUnit();
    
    /**
     * Devuelve la unidad de la derecha.
     * 
     * Este método devuelve la unidad de la derecha.
     * 
     * @return la unidad de la derecha.
     */
    IPhysicalUnit getRightUnit();
}
