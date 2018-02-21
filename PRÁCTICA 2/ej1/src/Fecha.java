package eps.uam.ads.p2.autoescuela.ej1;

/**
* Contiene los atributos y métodos de la clase Fecha
*
* @author Miguel García Moya y Lucía Colmenarejo
*
*/
public class Fecha {
	private int dia;
	private int mes;
	private int anyo;
	
	public Fecha(int a, int b, int c) {
		dia = a;
		mes = b;
		anyo = c;
	}
	
	/**
	* Comprueba si una fecha es válida.
	* 
	* Este método devuelve true si la fecha sobre la que se aplica es válida y false en caso contrario.
	* 
	* @param f Fecha a comprobar.
	* 
	* @return True si la fecha es válida, false en caso contrario.
	*/
	public boolean isFechaValida() {
		if(this.dia < 1 | this.dia > 31) {
			return false;
		}
		if(this.mes < 1 | this.mes > 12) {
			return false;
		}
		return true;
	}
	
	/**
	* Devuelve una fecha en formato dd/mm/aaaa.
	* 
	* Este método devuelve una fecha en formato dia/mes/año.
	* 
	* @return String con la fecha en el formato dia/mes/año.
	*/
	public String getFecha() {
		return (this.dia + "/" + this.mes + "/" + this.anyo);
	}

}
