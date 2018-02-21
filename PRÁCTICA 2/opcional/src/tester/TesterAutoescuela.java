package eps.uam.ads.p2.tester;

import eps.uam.ads.p2.autoescuela.Autoescuela;
import eps.uam.ads.p2.autoescuela.Actividad;
import eps.uam.ads.p2.alumnos.Fecha;
import eps.uam.ads.p2.alumnos.Profesor;

/**
* Tester el apartado opcional de la P2
* @author Miguel García y Lucía Colmenarejo
*/ 
public class TesterAutoescuela {
	public static void main(String[] args) {
		Autoescuela a1 = new Autoescuela(1, "Arenal", "NaN","Pepe");
		Autoescuela a2 = new Autoescuela(2, "Gala", "NaN","asdf");
		Profesor p1 = new Profesor(2504, "Antonio", "Pérez García", 978456123, 123, 1, 900);
		p1.cambiarAutoescuela(a1, new Fecha(2,3,2017));
		p1.cambiarAutoescuela(a2, new Fecha(10,7,2018));
		Actividad act = p1.obtenerActividadEnAutoescuela(a1);
		System.out.println("El profesor " + p1.getNombre() + " " + p1.getApellidos() + " trabajó en la autoescuela " + a1.getNombre() + " desde el " + act.getFechaIniActividad().getFecha() + " hasta el " + act.getFechaFinActividad().getFecha());
	}
}
