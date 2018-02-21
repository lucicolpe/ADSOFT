package es.uam.eps.ads.p3.biblioteca;

import es.uam.eps.ads.p3.fechasimulada.FechaSimulada;

/**
 * Contiene los atributos y métodos de la clase Ejemplar.
 * 
 * @author Miguel García Moya y Lucía Colmenarejo
 *
 */
public class Ejemplar {
	private int id;
	private Obra obra;
	private Usuario portador;
	
	/**
	 * Almacena el mayor id de los ejemplares.
	 */
	private static int maxid = 0;
	
	public Ejemplar(Obra obra) {
		maxid++;
		this.id = maxid;
		this.obra = obra;
		this.portador = null;
	}
	
	public int getId() {
		return id;
	}

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}
	
	/**
	 * Presta un ejemplar a un usuario.
	 * 
	 * Crea un préstamo y lo añade al usuario introducido. Falla si el usuario
	 * no puede tomar más préstamos, si el ejemplar ya está prestado o si el
	 * usuario ya tiene un ejemplar de la misma obra.
	 * 
	 * @param u Usuario al que prestar el ejemplar.
	 * @return Préstamo creado, null si no se puede prestar el ejemplar al usuario.
	 */
	public Prestamo prestar(Usuario u) {
		if(u.getPrestamos().size() >= u.getNumMaxPrestamos()) {
			return null;
		}
		if(this.portador != null) {
			return null;
		}
		for(Prestamo aux: u.getPrestamos()) {
			if(this.obra.equals(aux.getEjemplar().obra)) {
				return null;
			}
		}
		Prestamo p = new Prestamo(this, u);
		u.anyadirPrestamo(p);
		obra.subirNumPrestamos();
		this.portador = u;
		return p;
	}
	
	/**
	 * Devuelve el ejemplar, sancionando por retraso si es necesario.
	 * 
	 * Calcula si hay retraso de la devolución y sanciona al usuario si es así.
	 * Tras eso, elimina el préstamo del ejemplar y del usuario.
	 * 
	 */
	public void devolver() {
		Usuario u = this.portador;
		Prestamo p = u.getPrestamo(this);
		long exceso = FechaSimulada.getHoy().toEpochDay() - p.getFechaLimite();
		if(exceso > 0) {
			u.sancionarPorRetraso(exceso);
		}
		u.eliminarPrestamo(p);
		this.portador = null;
		Prestamo.reducirPendientes(p);
	}
	
	@Override
	public String toString() {
		String s;
		if (portador == null) {
			s = "(disponible)}";
		} else {
			s = "(prestado)}";
		}
		return ("{" + this.id + this.obra + s);
	}
	
}
