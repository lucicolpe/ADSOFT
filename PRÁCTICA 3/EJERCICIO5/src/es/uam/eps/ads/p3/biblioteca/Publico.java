package es.uam.eps.ads.p3.biblioteca;

/**
 * Contiene los atributos y métodos de la clase Publico.
 * 
 * @author Miguel García Moya y Lucía Colmenarejo.
 *
 */
public class Publico extends Usuario {
	private int numMaxPrestamos;
	private int contadorPrestamosSinRetraso;
	
	public Publico(String nombre) {
		super(nombre);
		this.numMaxPrestamos = 2;
		this.contadorPrestamosSinRetraso = 0;
	}

	public int getNumMaxPrestamos() {
		return numMaxPrestamos;
	}

	public int getContadorPrestamosSinRetraso() {
		return contadorPrestamosSinRetraso;
	}

	/**
	 * Sube el contador de préstamos sin retraso.
	 * 
	 * Sube el contador de préstamos devueltos sin retraso, aumentando
	 * el número máximo de préstamos y reiniciando el contador si es preciso.
	 * 
	 */
	public void subirContadorPrestamosSinRetraso() {
		this.contadorPrestamosSinRetraso = this.contadorPrestamosSinRetraso + 1;
		if(this.contadorPrestamosSinRetraso > this.numMaxPrestamos) {
			this.numMaxPrestamos = this.numMaxPrestamos + 1;
			this.contadorPrestamosSinRetraso = 1;
		}
	}
	
	/**
	 * Sanciona por retraso a un usuario público.
	 * 
	 * Reduce el contador de préstamos sin retraso según el número de días
	 * del retraso y resetea el número máximo de préstamos del usuario.
	 * 
	 * @param dias Días de retraso de la devolución del préstamo sancionada.
	 */
	public void sancionarPorRetraso(long dias) {
		this.contadorPrestamosSinRetraso = this.contadorPrestamosSinRetraso - (int) dias;
		if(this.contadorPrestamosSinRetraso < 0) {
			this.contadorPrestamosSinRetraso = 0;
		}
		this.numMaxPrestamos = 2;
	}
	
	@Override
	public String toString() {
		return ("[P: " + this.getNombre() + ",ppb: " + (/*this.getPrestamos().size()+*/this.contadorPrestamosSinRetraso) + ",ps: " + this.numMaxPrestamos + "]");
	}
	
}
