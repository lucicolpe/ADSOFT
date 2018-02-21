package es.uam.eps.ads.p3.biblioteca;

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

	public void subirContadorPrestamosSinRetraso() {
		this.contadorPrestamosSinRetraso = this.contadorPrestamosSinRetraso + 1;
		if(this.contadorPrestamosSinRetraso > this.numMaxPrestamos) {
			this.numMaxPrestamos = this.numMaxPrestamos + 1;
			this.contadorPrestamosSinRetraso = 1;
		}
	}
	
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
