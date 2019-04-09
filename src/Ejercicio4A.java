import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Ejercicio4A {

	public static void main(String[] args) {
		//InputStreamReader permite convertir cualquier InputStream en un Reader
		InputStream input;
		InputStreamReader isr;
		BufferedReader bf = null;
		
		try {
			input= Ejercicio4A.class.getResourceAsStream("El Quijote.txt");
			isr= new InputStreamReader(input,"windows-1252");
			bf = new BufferedReader(isr);
			 String linea = bf.readLine();
			 while(linea != null) {
				 // procesar la l�nea para que al final
				 // tengra registrado en alg�n sitio
				 // el n�mero de veces que se repite cada
				 // palabar sin tener en cuenta may�sculas
				 // y min�sculas.
				 linea = bf.readLine();
			 }
			 // pedir palabras al usuario y mostrar el
			 // n�mero de veces que se repiten. El programa
			 // finaliza cuando el usuario introcuzca la
			 // palabra 'fin'. Tambi�n se tiene que ver el
			 // n�mero de veces que se repite la palabra 'fin'.
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (bf != null) 
					bf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
