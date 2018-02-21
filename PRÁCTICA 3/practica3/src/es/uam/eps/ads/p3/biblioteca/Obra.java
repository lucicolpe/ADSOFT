package es.uam.eps.ads.p3.biblioteca;

public abstract class Obra {
	private String titulo;
	private String autor;
	private int anyo;
	private int numPrestamos;
	
	public Obra(String titulo, String autor, int anyo) {
		this.titulo = titulo;
		this.autor = autor;
		this.anyo = anyo;
		this.numPrestamos = 0;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getAnyo() {
		return anyo;
	}
	
	public int getNumPrestamos() {
		return numPrestamos;
	}
	
	public int plazoPrestamo() {
		return -1;
	}
	
	public void subirNumPrestamos() {
		this.numPrestamos = this.numPrestamos + 1;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Obra) {
			Obra o = (Obra) obj;
			if(this.titulo == o.titulo && this.autor == o.autor) {
				return true;
			}
		}
		return false;
	}
	
	

}

