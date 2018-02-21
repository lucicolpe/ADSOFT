package eps.uam.ads.p2.autoescuela;

import eps.uam.ads.p2.alumnos.Alumno;
import eps.uam.ads.p2.alumnos.alumnos.Fecha;

/**
* Contiene los atributos y métodos de la clase ClasePractica
*
* @author Miguel García Moya y Lucía Colmenarejo
*
*/
public class ClasePractica {
	private int hora;
	private int precio;
	private int duracion;
	private int extra;
	private String recorrido;
	private boolean circuito;
	private boolean maniobras;
	private Alumno alumno1;
	private Alumno alumno2;
	
	public ClasePractica(int hora, int precio, int duracion, int extra, String recorrido, boolean circuito,
			boolean maniobras, Alumno alumno1, Alumno alumno2) {
		this.hora = hora;
		this.precio = precio;
		this.duracion = duracion;
		this.extra = extra;
		this.recorrido = recorrido;
		this.circuito = circuito;
		this.maniobras = maniobras;
		this.alumno1 = alumno1;
		this.alumno2 = alumno2;
	}

	/**
	* Devuelve la hora.
	* 
	* Este método devuelve la hora de la clase sobre la que se aplica.
	* 
	* @return Hora de la clase.
	*/
	public int getHora() {
		return hora;
	}

	/**
	* Cambia la hora.
	* 
	* Este método cambia la hora de la clase sobre la que se aplica.
	* 
	* @param Hora de la clase.
	*/
	public void setHora(int hora) {
		this.hora = hora;
	}

	/**
	* Devuelve el precio.
	* 
	* Este método devuelve el precio de la clase sobre la que se aplica.
	* 
	* @return Precio de la clase.
	*/
	public int getPrecio() {
		return precio;
	}

	/**
	* Cambia el precio.
	* 
	* Este método cambia el precio de la clase sobre la que se aplica.
	* 
	* @param Precio de la clase.
	*/
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/**
	* Devuelve la duración.
	* 
	* Este método devuelve la duración de la clase sobre la que se aplica.
	* 
	* @return Duración de la clase.
	*/
	public int getDuracion() {
		return duracion;
	}

	/**
	* Cambia la duración.
	* 
	* Este método cambia la duración de la clase sobre la que se aplica.
	* 
	* @param Duración de la clase.
	*/
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	/**
	* Devuelve el extra.
	* 
	* Este método devuelve el precio extra de la clase sobre la que se aplica.
	* 
	* @return Extra de la clase.
	*/
	public int getExtra() {
		return extra;
	}

	/**
	* Cambia el extra.
	* 
	* Este método cambia el precio extra de la clase sobre la que se aplica.
	* 
	* @param Extra de la clase.
	*/
	public void setExtra(int extra) {
		this.extra = extra;
	}

	/**
	* Devuelve el recorrido.
	* 
	* Este método devuelve el recorrido de la clase sobre la que se aplica.
	* 
	* @return Recorrido de la clase.
	*/
	public String getRecorrido() {
		return recorrido;
	}

	/**
	* Cambia el recorrido.
	* 
	* Este método cambia el recorrido de la clase sobre la que se aplica.
	* 
	* @param Recorrido de la clase.
	*/
	public void setRecorrido(String recorrido) {
		this.recorrido = recorrido;
	}

	/**
	* Devuelve true si la clase es circuito.
	* 
	* Este método devuelve true si la clase sobre la que se aplica es de circuito.
	* 
	* @return True si es circuito, false en caso contrario.
	*/
	public boolean isCircuito() {
		return circuito;
	}

	/**
	* Cambia el tipo de clase a circuito.
	* 
	* Este método cambia el tipo de la clase sobre la que se aplica a circuito.
	* 
	* @param Valor boolean de circuito de la clase.
	*/
	public void setCircuito(boolean circuito) {
		this.circuito = circuito;
	}

	/**
	* Devuelve true si la clase es maniobras.
	* 
	* Este método devuelve true si la clase sobre la que se aplica es de maniobras.
	* 
	* @return True si es maniobras, false en caso contrario.
	*/
	public boolean isManiobras() {
		return maniobras;
	}

	/**
	* Cambia el tipo de clase a maniobras.
	* 
	* Este método cambia el tipo de la clase sobre la que se aplica a maniobras.
	* 
	* @param Valor boolean de maniobras de la clase.
	*/
	public void setManiobras(boolean maniobras) {
		this.maniobras = maniobras;
	}

	/**
	* Devuelve el primer alumno.
	* 
	* Este método devuelve el primer alumno de la clase sobre la que se aplica.
	* 
	* @return Primer alumno de la clase.
	*/
	public Alumno getAlumno1() {
		return alumno1;
	}

	/**
	* Cambia el primer alumno.
	* 
	* Este método cambia el primer alumno de la clase sobre la que se aplica.
	* 
	* @param Primer alumno de la clase.
	*/
	public void setAlumno1(Alumno alumno1) {
		this.alumno1 = alumno1;
	}

	/**
	* Devuelve el segundo alumno.
	* 
	* Este método devuelve el segundo alumno de la clase sobre la que se aplica.
	* 
	* @return Segundo alumno de la clase.
	*/
	public Alumno getAlumno2() {
		return alumno2;
	}

	/**
	* Cambia el segundo alumno.
	* 
	* Este método cambia el segundo alumno de la clase sobre la que se aplica.
	* 
	* @param Segundo alumno de la clase.
	*/
	public void setAlumno2(Alumno alumno2) {
		this.alumno2 = alumno2;
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
	* Calcula el precio de una clase.
	* 
	* Este método calcula el precio de la clase sobre la que se aplica.
	* 
	* @return Precio de la clase.
	*/
	public int sumPrecioClase() {
		return this.precio + this.extra;
	}
}
