package es.uam.eps.ads.p3.biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.uam.eps.ads.p3.fechasimulada.FechaSimulada;

/**
 * Contiene los atributos y métodos de la clase Usuario.
 * 
 * @author Miguel García Moya y Lucía Colmenarejo
 *
 */
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
	
	/**
	 * Añade un préstamo al usuario.
	 * 
	 * Añade un préstamo introducido al usuario, calculando la fecha de
	 * préstamo y límite.
	 * 
	 * @param p Préstamo a añadir al usuario.
	 */
	public void anyadirPrestamo(Prestamo p) {
		long f = FechaSimulada.getHoy().toEpochDay();
		p.setFechaPrestamo(f);
		f = f + p.getEjemplar().getObra().plazoPrestamo();
		p.setFechaLimite(f);
		this.prestamos.add(p);
		p.getEjemplar().getObra().subirNumPrestamos();
		this.subirContadorPrestamosSinRetraso();
	}
	
	/**
	 * Elimina un préstamo del usuario.
	 * 
	 * @param p Préstamo a eliminar del usuario.
	 */
	public void eliminarPrestamo(Prestamo p) {
		this.prestamos.remove(p);
	}
	
	/**
	 * Devuelve el préstamo de un usuario correspondiente a un ejemplar.
	 * 
	 * Devuelve el préstamo de un usuario de un ejemplar introducido.
	 * Devuelve null si el ejemplar no está prestado por el usuario.
	 * 
	 * @param e Ejemplar cuyo préstamo se quiere.
	 * @return Préstamo del usuario y el ejemplar.
	 */
	public Prestamo getPrestamo(Ejemplar e) {
		for(Prestamo p: prestamos) {
			if(p.getEjemplar() == e) {
				return p;
			}
		}
		return null;
	}
	
	/**
	 * Devuelve la lista de préstamos del usuario.
	 * 
	 * @return Lista de préstamos del usuario.
	 */
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
