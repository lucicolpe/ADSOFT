package es.uam.eps.ads.p3.biblioteca;

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
	
	public int plazoPrestamo() {
		return 2;
	}
	
	@Override
	public String toString() {
		return ("[P: " + this.getTitulo() + ", " + this.getAutor() + " (" + this.getAnyo() + ") plazo:" + this.plazoPrestamo() + "]");
	}

}








