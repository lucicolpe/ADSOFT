package es.uam.eps.ads.p3.biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.uam.eps.ads.p3.fechasimulada.FechaSimulada;

public abstract class Usuario {
	private String nombre;
	private List<Prestamo> prestamos;

	public Usuario(String nombre) {
		this.nombre = nombre;
		this.prestamos = new ArrayList<Prestamo>();
	}

	public String getNombre() {
		return nombre;
	}
	
	public void anyadirPrestamo(Prestamo p) {
		long f = FechaSimulada.getHoy().toEpochDay();
		p.setFechaPrestamo(f);
		f = f + p.getEjemplar().getObra().plazoPrestamo();
		p.setFechaLimite(f);
		this.prestamos.add(p);
		p.getEjemplar().getObra().subirNumPrestamos();
		this.subirContadorPrestamosSinRetraso();
	}
	
	public void eliminarPrestamo(Prestamo p) {
		this.prestamos.remove(p);
	}
	
	public Prestamo getPrestamo(Ejemplar e) {
		for(Prestamo p: prestamos) {
			if(p.getEjemplar() == e) {
				return p;
			}
		}
		return null;
	}
	
	public List<Prestamo> getPrestamos() {
		return Collections.unmodifiableList(prestamos);
	}

	public void sancionarPorRetraso(long dias) {
		
	}
	
	public void eliminarSancion() {
		
	}
	
	public int getNumMaxPrestamos() {
		return -1;
	}
	
	public void subirContadorPrestamosSinRetraso() {
		
	}
}
