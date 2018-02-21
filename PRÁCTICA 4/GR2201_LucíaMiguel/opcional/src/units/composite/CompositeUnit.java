/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.composite;

import exceptions.QuantityException;
import exceptions.UnknownUnitException;
import metricsystem.IMetricSystem;
import units.IPhysicalUnit;
import units.Quantity;

/**
* Contiene los atributos y métodos de la clase CompositeUnit que implemeta
* la interfaz ICompositeUnit.
* 
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/
public class CompositeUnit implements ICompositeUnit {

    private Operator operator;
    private IPhysicalUnit left;
    private IPhysicalUnit right;
    private CompositeQuantity q;
    private IMetricSystem metricSystem;

    public CompositeUnit(IPhysicalUnit left, Operator operator, IPhysicalUnit right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
        this.q = new CompositeQuantity(left.getQuantity(), operator, right.getQuantity());
    }

    /**
     * Devuelve el operador aritmético.
     * 
     * Este método devuelve el operador aritmético.
     * 
     * @return el operador aritmético.
     */
    
    @Override
    public Operator getOperator() {
        return operator;
    }
    
    /**
     * Devuelve la unidad de la izquierda.
     * 
     * Este método devuelve la unidad de la izquierda.
     * 
     * @return la unidad de la izquierda.
     */

    @Override
    public IPhysicalUnit getLeftUnit() {
        return left;
    }
    
    /**
     * Devuelve la unidad de la derecha.
     * 
     * Este método devuelve la unidad de la derecha.
     * 
     * @return la unidad de la derecha.
     */

    @Override
    public IPhysicalUnit getRightUnit() {
        return right;
    }

    /**
     * Devuelve una unidad se puede convertir a otra.
     * 
     * Este método devuelve una unidad se puede convertir a otra si las unidades de la derecha y de la izquierda
     * se pueden traducir.
     * 
     * @return true si se pueden convertir o false si no se pueden convertir.
     */
    
    @Override
    public boolean canTransformTo(IPhysicalUnit u) {
        if (!q.equals(u.getQuantity())) {
            return false;
        }
        CompositeUnit cu = (CompositeUnit) u;
        return this.left.canTransformTo(cu.getLeftUnit()) && this.right.canTransformTo(cu.getRightUnit());

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
            throw new QuantityException("Quantites " + u.getQuantity() + " and " + this.getQuantity() + " are not compatible");
        }
        ICompositeUnit cu = (ICompositeUnit) u;
        if (operator == Operator.MULT) {
            return this.left.transformTo(d, cu.getLeftUnit()) * this.right.transformTo(1.0, cu.getRightUnit());
        } else {
            return this.left.transformTo(d, cu.getLeftUnit()) / this.right.transformTo(1.0, cu.getRightUnit());
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
        return left.abbrev() + " " + operator + " " + right.abbrev();
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
        return metricSystem;
    }

    @Override
    public String toString() {
        return this.abbrev();
    }
}
