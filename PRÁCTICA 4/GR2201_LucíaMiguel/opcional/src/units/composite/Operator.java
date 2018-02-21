package units.composite;

/**
* Contiene los atributos y métodos de la enum Operator.
* 
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/
public enum Operator {
    MULT, DIV;

    @Override
    public String toString() {
        if (this == MULT) {
            return "*";
        } else {
            return "/";
        }
    }

}
