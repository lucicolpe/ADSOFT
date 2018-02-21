/**
 * Esta aplicación toma un número arbitrario de parámetros y dice cuáles son primos y cuáles no.
 *
 * @author Miguel García Moya miguel.garciamoya@estudiante.uam.es
 * @author Lucía Colmenarejo Pérez lucia.colmenarejo@estudiante.uam.es
 */
public class Primos {
	/**
	* Este método calcula si el número dado como parámetro es primo o no.
	*
	* @param num Número que se quiere comprobar si es primo o no
	*/
	public static void es_primo(int num) {
		if (num < 0) {
			System.out.println(num + " es un número no válido");
			return;
		}
		if (num < 2) {
			System.out.println(num + " no es primo");
			return;
		}
		int raiz = (int)Math.sqrt(num);
		for (int i = 2; i <= raiz; i++) {
			if (num % i == 0) {
				System.out.println(num + " no es primo");
				return;
			}
		}
		System.out.println(num + " es primo");
	}
	/**
	* Punto de entrada a la aplicación.
	* 
	* Este método toma un número arbitrario de parámetros y calcula cúales son primos y cuáles no llamando a la función correspondiente
	*
	* @param args Los argumentos de la línea de comando. Se esperan números como parámetros
	*/
	public static void main(String[] args) {
		if (args.length<1) {
			System.out.println("Se espera al menos un número como parámetro.");
			return;
		}
		for (int i = 0; i < args.length; i++) {
			String arg = args[i];  
			int num = Integer.parseInt(arg);
			es_primo(num);
		}
	}
}
