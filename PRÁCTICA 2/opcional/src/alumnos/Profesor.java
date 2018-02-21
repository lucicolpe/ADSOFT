package eps.uam.ads.p2.alumnos;

import eps.uam.ads.p2.autoescuela.Actividad;
import eps.uam.ads.p2.autoescuela.Autoescuela;
import eps.uam.ads.p2.autoescuela.ClasePractica;

/**
* Contiene los atributos y métodos de la clase Profesor
*
* @author Miguel García Moya y Lucía Colmenarejo
*
*/
public class Profesor extends Persona {
	private int seguridaSocial;
	private int antiguedad;
	private int sueldoMin;
	private Actividad[] actividades;
	private int numActividades;
	private ClasePractica[] clases;
	private int numClasesPracticas;

	public Profesor(int dni, String nombre, String apellidos, int telefono, int seguridaSocial, int antiguedad,
			int sueldoMin) {
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setTelefono(telefono);
		this.seguridaSocial = seguridaSocial;
		this.antiguedad = antiguedad;
		this.sueldoMin = sueldoMin;
		this.actividades = new Actividad[10];
		this.numActividades = 0;
		this.clases = new ClasePractica[20];
		this.numClasesPracticas = 0;
	}

	/**
	* Devuelve el n. de seguridad social.
	* 
	* Este método devuelve el n. de seguridad social del profesor sobre el que se aplica.
	* 
	* @return N. de seguridad social del profesor.
	*/
	public int getSeguridaSocial() {
		return seguridaSocial;
	}

	/**
	* Cambia el n. de seg. social.
	* 
	* Este método cambia el n. de seg. social del profesor sobre el que se aplica.
	* 
	* @param N. de seg. social del profesor.
	*/
	public void setSeguridaSocial(int seguridaSocial) {
		this.seguridaSocial = seguridaSocial;
	}

	/**
	* Devuelve la antigüedad.
	* 
	* Este método devuelve la antigüedad del profesor sobre el que se aplica.
	* 
	* @return Antigüedad del profesor.
	*/
	public int getAntiguedad() {
		return antiguedad;
	}

	/**
	* Cambia la antigüedad.
	* 
	* Este método cambia la antigüedad del profesor sobre el que se aplica.
	* 
	* @param Antigüedad del profesor.
	*/
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	/**
	* Devuelve el sueldo mínimo.
	* 
	* Este método devuelve el sueldo mínimo del profesor sobre el que se aplica.
	* 
	* @return Sueldo mínimo del profesor.
	*/
	public int getSueldoMin() {
		return sueldoMin;
	}

	/**
	* Cambia el sueldo mínimo.
	* 
	* Este método cambia el sueldo mínimo del profesor sobre el que se aplica.
	* 
	* @param Sueldo mínimo del profesor.
	*/
	public void setSueldoMin(int sueldoMin) {
		this.sueldoMin = sueldoMin;
	}

	/**
	* Cambia la autoescuela.
	* 
	* Este método cambia la autoescuela del profesor sobre el que se aplica.
	* 
	* @param Autoescuela del profesor.
	* @param Fecha del cambio.
	*/
	public void cambiarAutoescuela(Autoescuela autoescuela, Fecha fecha) {
		if(this.numActividades != 0) {
			(this.actividades[this.numActividades-1]).setFechaFinActividad(fecha);
		}
		this.actividades[this.numActividades] = new Actividad(autoescuela, fecha);
		this.numActividades++;
	}
	
	/**
	* Añade una clase.
	* 
	* Este método añade una clase al profesor sobre el que se aplica.
	* 
	* @param Clase a añadir.
	*/
	public void añadirClase(ClasePractica clase) {
		this.clases[this.numClasesPracticas] = clase;
		this.numActividades = this.numActividades + 1;
	}
	
	/**
	* Devuelve el sueldo.
	* 
	* Este método calcula y devuelve el sueldo del profesor sobre el que se aplica.
	* 
	* @return Sueldo del profesor.
	*/
	public int obtenerSueldoProfesor() {
		return this.sueldoMin + 20*this.numClasesPracticas;
	}
	
	/**
	* Devuelve el n. de clases prácticas.
	* 
	* Este método devuelve el n. de clases prácticas del profesor sobre el que se aplica.
	* 
	* @return N. de clases prácticas del profesor.
	*/
	public int numeroClasesPracticas() {
		return this.numClasesPracticas;
	}
	
	/**
	* Devuelve la actividad de un profesor en una autoescuela.
	* 
	* Este método devuelve la actividad del profesor sobre el que se aplica en una autoescuela.
	* 
	* @param Autoescuela.
	* @return Actividad del profesor en la autoescuela.
	*/
	public Actividad obtenerActividadEnAutoescuela(Autoescuela a) {
		for(int i = 0; i < this.numActividades; i++) {
			if(this.actividades[i].getAutoescuela() == a) {
				return this.actividades[i];
			}
		}
	return null;
	}
}
