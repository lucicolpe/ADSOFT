/**
 * Esta aplicación calcula las filas del triángulo de Tartaglia introducidas como primer parámetro.
 *
 * @author Miguel García Moya miguel.garciamoya@estudiante.uam.es
 * @author Lucía Colmenarejo Pérez lucia.colmenarejo@estudiante.uam.es
 */
public class TriTartaglia {
	/**
	* Este método imprime las filas del triángulo de Tartaglia que se introducen
	*
	* @param filas El número de filas que se desea calcular
	*/
	public static void tritartaglia(int filas) {
		int[][] triangulo =new int [filas+1][filas+1];
		triangulo[0][0] = 1;
		System.out.print(triangulo[0][0] + "\n");
		for(int i = 1; i <= filas; i++) {
			triangulo[i][0] = 1;
			System.out.print(triangulo[i][0] + " ");
			for(int j = 1; j < i; j++) {
				triangulo[i][j] = triangulo[i-1][j] + triangulo[i-1][j-1];
				System.out.print(triangulo[i][j] + " ");
			}
			triangulo[i][i] = 1;
			System.out.print(triangulo[i][i] + "\n");
		}
	}
	/**
	* Punto de entrada a la aplicación.
	* 
	* Este método imprime las filas del triángulo de Tartaglia que se introducen llamando a la función correspondiente, 
	* comprobando los parámetros de entrada
	*
	* @param args Los argumentos de la línea de comando. Se espera un número como primer parámetro
	*/
	public static void main(String[] args) {
		if (args.length<1) {
			System.out.println("Se espera un número como parámetro.");
			return;
		}
		String arg = args[0];  
		int filas= Integer.parseInt(arg); 
		if (filas < 0) {
			System.out.println("Introduzca un número natural.");
			return;
		}
		tritartaglia(filas);
	}
}
