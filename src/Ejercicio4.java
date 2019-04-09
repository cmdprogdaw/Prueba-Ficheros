import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio4 {

	public static void main(String[] args) {
		//InputStreamReader permite convertir cualquier InputStream en un Reader
		InputStream input;
		InputStreamReader isr;
		BufferedReader bf;
		input = Ejercicio4.class.getResourceAsStream("El Quijote.txt");
		isr = new InputStreamReader(input);
		bf = new BufferedReader(isr); 
		try {
			String linea = bf.readLine();
			while(linea != null) {
				System.out.println(linea);
				linea = bf.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
