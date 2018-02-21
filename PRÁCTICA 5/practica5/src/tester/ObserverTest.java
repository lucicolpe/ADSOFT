package tester;

import observer.ObservableTime;

public class ObserverTest {

	public static void main(String[] args) {
		ObservableTime o1 = new ObservableTime(1);
		ObservableTime o2 = new ObservableTime(10);
		System.out.println("Valores iniciales:");
		System.out.println(o1);
		System.out.println(o2);
		System.out.printf("\n");
		o1.addProperty(o2);
		System.out.println("La primera propiedad observa a la segunda, aumentando su valor:");
		System.out.println(o1);
		System.out.println(o2);
		System.out.printf("\n");
		o1.incrementTime(12);
		System.out.println("La primera propiedad aumenta su valor, la segunda no cambia:");
		System.out.println(o1);
		System.out.println(o2);
		System.out.printf("\n");
		o2.incrementTime(10);
		System.out.println("La segunda propiedad aumenta su valor, la primera cambia con ella:");
		System.out.println(o1);
		System.out.println(o2);
		System.out.printf("\n");
		o1.removeProperty(o2);
		System.out.println("La primera propiedad deja de observar a la segunda, disminuyendo su valor:");
		System.out.println(o1);
		System.out.println(o2);
	}

}
