package units;

/**
* Contiene los atributos y métodos de la clase Quantity 
* 
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public class Quantity {
    public static final Quantity LENGTH = new Quantity();
    public static final Quantity TIME = new Quantity();
	
        @Override
	public String toString() {
		if(this == LENGTH) {
			return "L";
		} else {
			return "t";
		}
	}
}
