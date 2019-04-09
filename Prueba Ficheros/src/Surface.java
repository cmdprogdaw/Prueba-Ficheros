import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Surface extends JPanel {
	private BufferedImage image;
	
	public Surface(BufferedImage image) {
		this.image = image;
		setPreferredSize(new Dimension(image.getHeight(), image.getHeight()));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		double wp = getWidth();
		double wi = image.getWidth();
		double escala = wp / wi;
		((Graphics2D) g).scale(escala, escala); 
		g.drawImage(image, 0, 0, this);
	}
	
}
