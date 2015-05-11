package fractal;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

public class DrawingPanel extends JPanel {
	FractalView view;

	public DrawingPanel(FractalView view) {
		this.view = view;
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	public Dimension getPreferredSize() {
		return new Dimension(600,600);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Fractal fractal = view.getFractal();
		if(fractal.getOrder() > 8) {
			BufferedImage image = null;
			try {
				if(fractal.getTitle().contains("Mountains"))
					image = ImageIO.read(new File("resources/mountain.jpg"));
				else if (fractal.getTitle().contains("Kochs"))
					image = ImageIO.read(new File("resources/snowflake.jpg"));
				else
					image = ImageIO.read(new File("resources/fucked.jpg"));
			} catch (IOException e) {
				throw new NoSuchElementException("File not found");
			}
			g.drawImage(image, 0, 0, null);
			return;
		}
		g.drawString(fractal.toString(), 10, 20);
		g.setClip(0, 0, (int) getSize().getWidth(), (int) getSize().getHeight());
		fractal.draw(new TurtleGraphics(g));
	}  
}
