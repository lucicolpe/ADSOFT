package eps.uam.ads.p2.alumnos;

/**
* Contiene los atributos y métodos de la clase Alumno
*
* @author Miguel García Moya y Lucía Colmenarejo
*
*/
public class Alumno extends Persona {
	private String direccion;
	private Fecha fechaMatricula;
	private Fecha fechaSupTeorico;
	private Fecha fechaSupPractico;

	
	public Alumno(int dni, String nombre, String apellidos, String direccion, int telefono, int i,
			int j, int k) {
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setTelefono(telefono);
		this.fechaMatricula = new Fecha(i,j,k);
	}

	/**
	* Devuelve la fecha de matrícula.
	* 
	* Este método devuelve la fecha de matrícula del alumno sobre el que se aplica.
	* 
	* @return Fecha de matrícula del alumno.
	*/
	public Fecha getFechaMatricula() {
		return this.fechaMatricula;
	}

	/**
	* Cambia la fecha de aprobado de teoría.
	* 
	* Este método cambia la fecha de aprobado de teoría del alumno sobre el que se aplica a la fecha introducida.
	* 
	* @param i Día de la fecha.
	* @param j Mes de la fecha.
	* @param k Año de la fecha.
	*/
	public void setFechaSupTeorico(int i, int j, int k) {
		this.fechaSupTeorico = new Fecha(i,j,k);
	}

	/**
	* Cambia la fecha de aprobado de práctica.
	* 
	* Este método cambia la fecha de aprobado de práctica del alumno sobre el que se aplica a la fecha introducida.
	* 
	* @param i Día de la fecha.
	* @param j Mes de la fecha.
	* @param k Año de la fecha.
	*/
	public void setFechaSupPractico(int i, int j, int k) {
		this.fechaSupPractico = new Fecha(i,j,k);
	}

	/**
	* Devuelve el nombre y apellidos de un alumno.
	* 
	* Este método devuelve el nombre y apellidos del alumno sobre el que se aplica.
	* 
	* @return Nombre y apellidos del alumno en una string.
	*/
	public String getNombreYApellidos() {
		return (this.getNombre() + " " + this.getApellidos());
	}
	
	/**
	* Devuelve la fecha de aprobado de teoría de un alumno.
	* 
	* Este método devuelve la fecha de aprobado de teoría del alumno sobre el que se aplica.
	* 
	* @return Fecha de aprobado de teoría del alumno.
	*/
	public Fecha getFechaSupTeorico() {
		return this.fechaSupTeorico;
	}
	
	/**
	* Devuelve la fecha de aprobado de práctica de un alumno.
	* 
	* Este método devuelve la fecha de aprobado de práctica del alumno sobre el que se aplica.
	* 
	* @return Fecha de aprobado de práctica del alumno.
	*/
	public Fecha getFechaSupPractico() {
		return this.fechaSupPractico;
	}
	
	/**
	* Comprueba si una fecha es válida.
	* 
	* Este método devuelve true si la fecha introducida es válida y false en caso contrario.
	* 
	* @param f Fecha a comprobar.
	* 
	* @return True si la fecha es válida, false en caso contrario.
	*/
	public boolean isFechaValida(Fecha f) {
		return f.isFechaValida();
	}
	
	
	/**
	* Devuelve los datos de un alumno para imprimir.
	* 
	* Este método devuelve los datos de un alumno en el formato para imprimir por pantalla.
	* 
	* @return Los datos del alumno en un formato para imprimir por pantalla.
	*/
	@Override
	public String toString() {
		return ("<dni: " + this.getDni() + ">\n\tNombre y apellidos: " + this.getNombre() + " " + this.getApellidos() + "\n\tDirección: " + this.direccion + "\n\tTeléfono: " + this.getTelefono() + "\n\tFecha de matriculación: " + this.getFechaMatricula().getFecha());
	}
}