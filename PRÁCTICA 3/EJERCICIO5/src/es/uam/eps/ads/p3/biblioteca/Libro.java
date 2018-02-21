package es.uam.eps.ads.p3.biblioteca;

/**
 * Almacena los atributos y métodos de la clase Libro.
 * 
 * @author Miguel García Moya y Lucía Colmenarejo.
 *
 */
public class Libro extends Obra {
	private String editorial;
	private int nEdicion;
	
	public Libro(String titulo, String autor, int anyo, String editorial, int nEdicion) {
		super(titulo, autor, anyo);
		this.editorial = editorial;
		this.nEdicion = nEdicion;
	}

	public Libro(String titulo, String autor, int anyo) {
		super(titulo, autor, anyo);
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getnEdicion() {
		return nEdicion;
	}

	public void setnEdicion(int nEdicion) {
		this.nEdicion = nEdicion;
	}
	
	/**
	 * Devuelve el plazo de préstamo del libro.
	 * 
	 * Calcula el plazo de préstamo del libro a partir del
	 * número de préstamos y lo devuelve.
	 * 
	 * @return Días de plazo de préstamo del libro.
	 */
	public int plazoPrestamo() {
		int dias;
		dias = 25 - this.getNumPrestamos()/10;
		if(dias < 7) {
			return 7;
		}
		return dias;
	}
	
	@Override
	public String toString() {
		return ("[L: " + this.getTitulo() + ", " + this.getAutor() + " (" + this.getAnyo() + ") plazo:" + this.plazoPrestamo() + "]");
	}
	
}
