package es.uam.eps.ads.p3.biblioteca;

import es.uam.eps.ads.p3.fechasimulada.FechaSimulada;

public class Ejemplar {
	private int id;
	private Obra obra;
	private Usuario portador;
	
	private static int maxid;
	
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
