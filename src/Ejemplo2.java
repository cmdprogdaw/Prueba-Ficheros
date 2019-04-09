import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class Ejemplo2 {
	public static void main(String[] args) {
		DataInputStream in = null;
		try {
			in = new DataInputStream(new FileInputStream("C:\\Users\\aula9\\Desktop\\datos"));
//			int i = (in.read() << 24) + (in.read() << 16) + (in.read() << 8) + in.read(); //el int son 4 bytes
//			long l = ((long)in.read() << 56) + ((long)in.read() << 48) + ((long)in.read() << 40) 
//						+ ((long)in.read() << 32) + ((long)in.read() << 24) + (in.read() << 16) 
//							+ (in.read() << 8) + in.read();
			int i = in.readInt();
			long l = in.readLong();
			boolean b1 = in.read() != 0;
			boolean b2 = in.read() != 0;
			System.out.println(i);
			System.out.println(l);
			System.out.println(b1);
			System.out.println(b2);
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
