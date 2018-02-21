package es.uam.eps.ads.p3.biblioteca;

/**
 * Contiene los atributos y métodos de la clase Empleado.
 * 
 * @author Miguel García Moya y Lucía Colmenarejo
 *
 */
public class Empleado extends Usuario {
	private double sancion;
	
	public Empleado(String nombre) {
		super(nombre);
		this.sancion = 0;
	}
	
	public int getNumMaxPrestamos() {
		return 20;
	}
	
	/**
	 * Sanciona por retraso a un empleado.
	 * 
	 * Añade a la sanción actual del empleado la sanción correspondiente al
	 * número de días introducidos.
	 * 
	 * @param dias Días de retraso de la devolución del préstamo sancionada.
	 */
	public void sancionarPorRetraso(long dias) {
		if(dias <= 4) {
			return;
		}
		else {
			this.sancion = this.sancion + 2.5*dias;
		}
	}
	
	/**
	 * Elimina las sanciones acumuladas por el empleado.
	 * 
	 * Restaura las sanciones del empleado sobre el que se aplica.
	 * 
	 */
	public void eliminarSancion() {
		this.sancion = 0;
	}
	
	@Override
	public String toString() {
		if(this.sancion == 0) {
			return ("[E: " + this.getNombre() + "]");
		}
		else {
			return ("[E: " + this.getNombre() + " $" + this.sancion + "]");
		}
		
	}
}