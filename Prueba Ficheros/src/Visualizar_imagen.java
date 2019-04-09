import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Visualizar_imagen {

	public static void main(String[] args) {
		DataInputStream in = null;
		try {
			InputStream is = Visualizar_imagen.class.getResourceAsStream("saltamontes.bmp");
			in = new DataInputStream(new BufferedInputStream(is)); //sin el buffered tarda mas
			String tipo = "";
			tipo += (char) in.read();
			tipo += (char) in.read();
			System.out.println("Tipo: " + tipo);
			System.out.println("Longitud del fichero: " + Integer.reverseBytes(in.readInt())); //pasa bigendiam a littleendiam
			in.skip(4);
			int offset = Integer.reverseBytes(in.readInt());
			System.out.println("Offset de la imagen: " + offset);
			System.out.println("Longitud cabecera de imagen: " + Integer.reverseBytes(in.readInt()));			
			int width = Integer.reverseBytes(in.readInt());
			System.out.println("Ancho de la imagen: " + width);
			int height = Integer.reverseBytes(in.readInt());
			System.out.println("Alto de la imagen: " + height);
			System.out.println("Planos: " + Short.reverseBytes(in.readShort()));
			int colorDepth = Short.reverseBytes(in.readShort());
			System.out.println("Profundidad de color: " + colorDepth);
			System.out.println("Compresion: " + Integer.reverseBytes(in.readInt()));
			System.out.println("Tamaño de la imagen: " + Integer.reverseBytes(in.readInt()));
			System.out.println("Resolucion horizontal: " + Integer.reverseBytes(in.readInt()));
			System.out.println("Resolucion vertical: " + Integer.reverseBytes(in.readInt()));
			System.out.println("Numero de colores: " + Integer.reverseBytes(in.readInt()));
			System.out.println("Numero de colores importantes: " + Integer.reverseBytes(in.readInt()));
			in.skip(offset - 54);
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			for (int f = height - 1; f >= 0; f--) {
				for (int c = 0; c < width; c++) {
					int pixel = 0;
					if(colorDepth == 24) {
						pixel |= in.read(); //componente de azul
						pixel |= in.read() << 8; //componente de verde
						pixel |= in.read() << 16; //componente de rojo
						pixel |= 0xff000000; //para que el alpha este en opaco 
					}
					else if (colorDepth == 32) {
						pixel = Integer.reverseBytes(in.readInt() << 8);
						pixel |= 0xff000000;
					}
					image.setRGB(c, f, pixel);
				}
				in.skip(width % 4); //para que la imagen se vea bien con las imagenes que no sean de profundidad 32 bits pq con esos no sirve
			}
			JFrame ventana = new JFrame("Visor de BMP");
			ventana.getContentPane().add(new Surface(image));
			ventana.pack();
			ventana.setLocationRelativeTo(null);
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			SwingUtilities.invokeLater(() -> {ventana.setVisible(true);});
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
