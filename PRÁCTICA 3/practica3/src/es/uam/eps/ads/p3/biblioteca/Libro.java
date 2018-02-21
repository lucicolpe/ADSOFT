package es.uam.eps.ads.p3.biblioteca;

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
