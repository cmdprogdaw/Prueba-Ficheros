import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejemplo1 {
	
	public static void main(String[] args) {
		DataOutputStream out = null; //se inicializa aqui para poder cerrar el fichero con el siguiente finally
		//el constuctor de FileOutputStream puede lanzar una excepcion checked
		try { //si se abre con exito el fichero sin exepciones se ejecuta el try
			out = new DataOutputStream(new FileOutputStream("C:\\Users\\aula9\\Desktop\\datos")); //crea un fichero con contenido binario en donde le dijiste con lo de abajo (se puede leer con HxD)
			out.writeInt(43291);
			out.writeLong(2123547892394663463L);
			out.writeBoolean(true);
			out.writeBoolean(false);
//		} catch (FileNotFoundException e) { //FileNotFoundException hereda de IOException (podemos prescindir de FileNotFoundException)
//			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
