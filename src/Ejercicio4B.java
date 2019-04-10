import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio4B {

	// pedir palabras al usuario y mostrar el
	// número de veces que se repiten. El programa
	// finaliza cuando el usuario introcuzca la
	// palabra 'fin'. También se tiene que ver el
	// número de veces que se repite la palabra 'fin'.
	public static void main(String[] args) {
		Map<String, Integer> palabras;
		Scanner s = new Scanner(System.in);
		try {
			palabras = leerFichero("ejercicio4.dat");
			String palabra;
			do {
				System.out.println("Palabra: ");
				palabra = s.nextLine().toLowerCase();
				Integer n = palabras.get(palabra);
				if (n != null)
					System.out.println("Se repite " + n + " veces");
				else
					System.out.println("Esta palabra no se utiliza en el Quijote");
			} while (!palabra.equals("fin"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Map<String, Integer> leerFichero(String fichero)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		Map<String, Integer> palabras = null;

//		ObjectInputStream in = null;
//		try {
//			in = new ObjectInputStream(new FileInputStream(fichero));
//			palabras = (TreeMap<String, Integer>) in.readObject();
//		} finally {
//			if (in != null)
//				in.close();
//		}

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fichero))) {
			palabras = (TreeMap<String, Integer>) in.readObject();
		}

		return palabras;

	}

}
