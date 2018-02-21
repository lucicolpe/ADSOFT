package units.composite;

import java.util.Objects;
import units.Quantity;

/**
* Contiene los atributos y métodos de la clase CompositeQuantity que hereda
* de Quantity.
* 
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class CompositeQuantity extends Quantity {
    private Operator operator;
    private Quantity left;
    private Quantity right;

    public CompositeQuantity(Quantity left, Operator operator, Quantity right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public String toString() {
        return "[" + left + operator + right + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CompositeQuantity)) {
            return false;
        }
        CompositeQuantity cq = (CompositeQuantity) obj;
        if (this.operator != cq.operator || this.left != cq.left || this.right != cq.right) {
            return false;
        }
        return true;
    }
    
    
}
