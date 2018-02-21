package eps.uam.ads.p2.autoescuela;

import eps.uam.ads.p2.alumnos.Profesor;

/**
* Contiene los atributos y métodos de la clase Autoescuela
*
* @author Miguel García Moya y Lucía Colmenarejo
*
*/
public class Autoescuela {
	private int codigoInterno;
	private String nombre;
	private String direccion;
	private String encargado;
	private Profesor[] profesores;
	private int numProfesores;

	public Autoescuela(int codigoInterno, String nombre, String direccion, String encargado) {
		super();
		this.codigoInterno = codigoInterno;
		this.nombre = nombre;
		this.direccion = direccion;
		this.encargado = encargado;
		this.numProfesores = 0;
	}

	/**
	* Devuelve el código interno.
	* 
	* Este método devuelve el código interno de la autoescuela sobre la que se aplica.
	* 
	* @return Código interno de la autoescuela.
	*/
	public int getCodigoInterno() {
		return codigoInterno;
	}

	/**
	* Cambia el código interno.
	* 
	* Este método cambia el código interno de la autoescuela sobre el que se aplica.
	* 
	* @param Código interno de la autoescuela.
	*/
	public void setCodigoInterno(int codigoInterno) {
		this.codigoInterno = codigoInterno;
	}

	/**
	* Devuelve el nombre.
	* 
	* Este método devuelve el nombre de la autoescuela sobre la que se aplica.
	* 
	* @return Nombre de la autoescuela.
	*/
	public String getNombre() {
		return nombre;
	}

	/**
	* Cambia el nombre.
	* 
	* Este método cambia el nombre de la autoescuela sobre el que se aplica.
	* 
	* @param Nombre de la autoescuela.
	*/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	* Devuelve la dirección.
	* 
	* Este método devuelve la dirección de la autoescuela sobre la que se aplica.
	* 
	* @return Dirección de la autoescuela.
	*/
	public String getDireccion() {
		return direccion;
	}

	/**
	* Cambia el dirección.
	* 
	* Este método cambia el dirección de la autoescuela sobre el que se aplica.
	* 
	* @param Dirección de la autoescuela.
	*/
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	* Devuelve el encargado.
	* 
	* Este método devuelve el nombre del encargado de la autoescuela sobre la que se aplica.
	* 
	* @return Encargado de la autoescuela.
	*/
	public String getEncargado() {
		return encargado;
	}

	/**
	* Cambia el encargado.
	* 
	* Este método cambia el encargado de la autoescuela sobre el que se aplica.
	* 
	* @param Encargado de la autoescuela.
	*/
	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}
	
	/**
	* Devuelve el número de profesores.
	* 
	* Este método devuelve el número de profesores de la autoescuela sobre la que se aplica.
	* 
	* @return Código interno de la autoescuela.
	*/
	public int getNumProfesores() {
		return numProfesores;
	}

	/**
	* Añade un profesor.
	* 
	* Este método añade un profesor a la autoescuela sobre el que se aplica.
	* 
	* @param Profesor a añadir.
	*/
	public void añadirProfesor(Profesor p) {
		this.profesores[this.numProfesores] = p;
		this.numProfesores++;
	}
	
	
}

