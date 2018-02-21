package es.uam.eps.ads.p3.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Contiene los atributos y metodos de la clase BibliotecaSingleton.
 * 
 * @author Miguel García Moya y Lucía Colmenarejo Pérez
 *
 */

public class BibliotecaSingleton {
	private static BibliotecaSingleton instance;
	private List<Prestamo> prestamosHistoricos = new ArrayList<Prestamo>(); 
	private List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Obra> obras = new ArrayList<Obra>();
	
	private BibliotecaSingleton() {
	}
	
	/**
	 * Devuelve la biblioteca. 
	 * 
	 * @return la biblioteca
	 */
	
	public static BibliotecaSingleton getInstance(){
		if(instance == null){
			instance = new BibliotecaSingleton();
		}
		return instance;
	}
	
	/**
	 * Añade un prestamo ya devuelto a la lista de historicos. 
	 * 
	 * @param p
	 */
	
	public void anyadirPrestamo (Prestamo p){
		if(p.getFechaDevolucion() == -1){
			return;
		}else{
			prestamosHistoricos.add(p);
		}
	}
	
	/**
	 * Añade un ejemplar a la lista de ejemplares.
	 * 
	 * @param e
	 */
	
	public void anyadirEjemplar(Ejemplar e){
		ejemplares.add(e);
	}
	
	/**
	 * Añade un usuario a la lista de ususarios.
	 * 
	 * @param u
	 */
	
	public void anyadirUsuario(Usuario u){
		usuarios.add(u);
	}
	
	/**
	 * Añade una obra a la lista de obras.
	 * 
	 * @param o
	 */
	
	public void anyadirObra(Obra o){
		obras.add(o);
	}
	
	/**
	 * Elimina un ejemplar de la lista de ejemplares.
	 * 
	 * @param e
	 */
	public void eliminarEjemplar(Ejemplar e){
		ejemplares.remove(e);
	}
	
	/**
	 * Elimina una obra de la lista de obras y todos los ejemplares de dicha obra.
	 * 
	 * @param o
	 */
	public void eliminarObra (Obra o){
		obras.remove(o);
		for (Ejemplar e: ejemplares){
			if(e.getObra().equals(o)){
				eliminarEjemplar(e);
			}
		}
	}
}
