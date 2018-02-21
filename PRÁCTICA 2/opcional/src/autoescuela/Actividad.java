package eps.uam.ads.p2.autoescuela;

import eps.uam.ads.p2.alumnos.Fecha;

/**
* Contiene los atributos y métodos de la clase Actividad
*
* @author Miguel García Moya y Lucía Colmenarejo
*
*/
public class Actividad {
	private Autoescuela autoescuela;
	private Fecha fechaIniActividad;
	private Fecha fechaFinActividad;
	
	public Actividad(Autoescuela autoescuela, Fecha fechaIniActividad) {
		super();
		this.autoescuela = autoescuela;
		this.fechaIniActividad = fechaIniActividad;
	}

	/**
	* Devuelve la autoescuela.
	* 
	* Este método devuelve la autoescuela de la actividad sobre la que se aplica.
	* 
	* @return Autoescuela de la actividad.
	*/
	public Autoescuela getAutoescuela() {
		return autoescuela;
	}

	/**
	* Cambia la autoescuela.
	* 
	* Este método cambia la autoescuela de la actividad sobre la que se aplica.
	* 
	* @param Autoescuela de la actividad.
	*/
	public void setAutoescuela(Autoescuela autoescuela) {
		this.autoescuela = autoescuela;
	}

	/**
	* Devuelve la fecha de inicio.
	* 
	* Este método devuelve la fecha de inicio de la actividad sobre la que se aplica.
	* 
	* @return Fecha de inicio de la actividad.
	*/
	public Fecha getFechaIniActividad() {
		return fechaIniActividad;
	}

	/**
	* Cambia la fecha de inicio.
	* 
	* Este método cambia la fecha de inicio de la actividad sobre la que se aplica.
	* 
	* @param Fecha de inicio de la actividad.
	*/
	public void setFechaIniActividad(Fecha fechaIniActividad) {
		this.fechaIniActividad = fechaIniActividad;
	}

	/**
	* Devuelve la fecha de fin.
	* 
	* Este método devuelve la fecha de fin de la actividad sobre la que se aplica.
	* 
	* @return Fecha de fin de la actividad.
	*/
	public Fecha getFechaFinActividad() {
		return fechaFinActividad;
	}

	/**
	* Cambia la fecha de fin.
	* 
	* Este método cambia la fecha de fin de la actividad sobre la que se aplica.
	* 
	* @param Fecha de fin de la actividad.
	*/
	public void setFechaFinActividad(Fecha fechaFinActividad) {
		this.fechaFinActividad = fechaFinActividad;
	}
	
	

}
