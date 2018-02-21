package es.uam.eps.ads.p3.biblioteca;

/**
 * Contiene los atributos y métodos de la clase Pelicula.
 * 
 * @author Miguel García Moya y Lucía Colmenarejo.
 *
 */
public class Pelicula extends Obra {
	private Genero genero;

	public Pelicula(String titulo, String autor, int anyo, Genero genero) {
		super(titulo, autor, anyo);
		this.genero = genero;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	/**
	 * Devuelve el plazo de préstamo de la película.
	 * 
	 * @return Días de plazo de préstamo de la película.
	 */
	public int plazoPrestamo() {
		return 2;
	}
	
	@Override
	public String toString() {
		return ("[P: " + this.getTitulo() + ", " + this.getAutor() + " (" + this.getAnyo() + ") plazo:" + this.plazoPrestamo() + "]");
	}

}
