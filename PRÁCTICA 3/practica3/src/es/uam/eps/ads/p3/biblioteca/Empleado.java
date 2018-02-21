package es.uam.eps.ads.p3.biblioteca;

public class Empleado extends Usuario {
	private double sancion;
	
	public Empleado(String nombre) {
		super(nombre);
		this.sancion = 0;
	}
	
	public int getNumMaxPrestamos() {
		return 20;
	}
	
	public void sancionarPorRetraso(long dias) {
		if(dias <= 4) {
			return;
		}
		else {
			this.sancion = this.sancion + 2.5*dias;
		}
	}
	
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
