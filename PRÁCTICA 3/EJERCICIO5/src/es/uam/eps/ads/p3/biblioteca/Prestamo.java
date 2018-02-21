package es.uam.eps.ads.p3.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.uam.eps.ads.p3.fechasimulada.FechaSimulada;

/**
 * Contiene los atributos y métodos de la clase Prestamo.
 * 
 * @author Miguel García Moya y Lucía Colmenarejo.
 *
 */
public class Prestamo {
	private Ejemplar ejemplar;
	private Usuario usuario;
	private long fechaPrestamo;
	private long fechaLimite;
	private long fechaDevolucion;

	/**
	 * Número de préstamos históricos.
	 */
	private static int nHistoricos;

	/**
	 * Lista de préstamos pendientes.
	 */
	private static List<Prestamo> pendientes = new ArrayList<Prestamo>();

	public Prestamo(Ejemplar ejemplar, Usuario usuario) {
		this.ejemplar = ejemplar;
		this.usuario = usuario;
		this.fechaDevolucion = -1;
		nHistoricos++;
		pendientes.add(this);
	}

	public Ejemplar getEjemplar() {
		return ejemplar;
	}

	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public long getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(long fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public long getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(long fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public long getFechaDevolucion() {
		return fechaDevolucion;
	}

	/**
	 * Devuelve un préstamo.
	 * 
	 * Devuelve el ejemplar de un préstamo, asignando la fecha de devolución.
	 * Falla si el préstamo no está en la lista de préstamos pendientes.
	 * 
	 * @return true si se ejecuta correctamente, false si falla.
	 */
	public boolean devolver() {
		this.fechaDevolucion = FechaSimulada.getHoy().toEpochDay();
		if (pendientes.remove(this)) {
			this.ejemplar.devolver();
			return true;
		}
		return false;
	}

	/**
	 * Devuelve el número de préstamos históricos.
	 * 
	 * @return Número de préstamos históricos.
	 */
	public static int numPrestamosHistoricos() {
		return nHistoricos;
	}

	/**
	 * Devuelve el número de préstamos pendientes.
	 * 
	 * @return Número de préstamos pendientes.
	 */
	public static int numPrestamosPendientes() {
		return pendientes.size();
	}

	/**
	 * Elimina el préstamo de la lista de pendientes.
	 * 
	 * @param p
	 *            Préstamo a eliminar de la lista de pendientes.
	 */
	public static void reducirPendientes(Prestamo p) {
		pendientes.remove(p);
	}

	/**
	 * Devuelve la lista de préstamos que vencen hoy.
	 * 
	 * Devuelve la lista de préstamos cuya fecha límite es hoy.
	 * 
	 * @return Lista de préstamos que vencen hoy.
	 */
	public static List<Prestamo> conVencimientoHoy() {
		List<Prestamo> vencenHoy = new ArrayList<Prestamo>();
		for (Prestamo p : pendientes) {
			if (p.fechaLimite == FechaSimulada.getHoy().toEpochDay()) {
				vencenHoy.add(p);
			}
		}
		return Collections.unmodifiableList(vencenHoy);
	}

	/**
	 * Devuelve la lista de préstamos vencidos.
	 * 
	 * Devuelve la lista de préstamos cuya fecha límite ya ha pasado.
	 * 
	 * @return Lista de préstamos vencidos.
	 */
	public static List<Prestamo> pasadosDeVencimiento() {
		List<Prestamo> vencidos = new ArrayList<Prestamo>();
		for (Prestamo p : pendientes) {
			if (p.fechaLimite < FechaSimulada.getHoy().toEpochDay()) {
				vencidos.add(p);
			}
		}
		return Collections.unmodifiableList(vencidos);
	}

	@Override
	public String toString() {
		if (this.fechaDevolucion == -1) {
			return (this.ejemplar + " prestado a " + this.usuario + " hasta " + LocalDate.ofEpochDay(this.fechaLimite));
		} else {
			return (this.ejemplar + " prestado a " + this.usuario + " hasta " + LocalDate.ofEpochDay(this.fechaLimite)
					+ " devuelto " + LocalDate.ofEpochDay(this.fechaDevolucion));
		}

	}

}
