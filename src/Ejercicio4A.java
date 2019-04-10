import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;

public class Ejercicio4A {

	// procesar la l�nea para que al final
	// tengra registrado en alg�n sitio
	// el n�mero de veces que se repite cada
	// palabar sin tener en cuenta may�sculas
	// y min�sculas.
	public static void main(String[] args) {
		// InputStreamReader permite convertir cualquier InputStream en un Reader
		InputStream input;
		InputStreamReader isr;
		BufferedReader bf = null;
		Map<String, Integer> palabras = new TreeMap<>();
		String[] partes;

		try {
			input = Ejercicio4A.class.getResourceAsStream("El Quijote.txt");
			isr = new InputStreamReader(input);
			bf = new BufferedReader(isr);
			String linea;
			while ((linea = bf.readLine()) != null) {
				partes = linea.toLowerCase().split("[^a-zA-Z�-��-�����]+");
				for (String e : partes) {
					if (e.equals(""))
						continue;
					if (!palabras.containsKey(e)) {
						palabras.put(e, 1);
					} else {
						palabras.put(e, palabras.get(e) + 1);
					}
				}

			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bf != null)
					bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("ejercicio4.dat"));
			out.writeObject(palabras);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}