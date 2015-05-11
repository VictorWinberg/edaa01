package menu;

import java.awt.*;
import java.util.Random;

import javax.swing.*;

import shapes.*;

public class DrawPanel extends JPanel{
	
	MenuView view;
	Circle[] circles;
	private Color color;
	private Random random;
	private boolean pop;
	
	public DrawPanel(MenuView view, Circle[] circles) {
		this.view = view;
		this.circles = circles;
		random = new Random();
		setPreferredSize(new Dimension(600, 600));
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public void move(int dx, int dy) {
		for(Circle circle : circles)
			circle.move(dx, dy);
		repaint();
	}
	
	public void setPop(boolean pop) {
		this.pop = pop;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(pop) {
			Circle circle = circles[random.nextInt(circles.length)];
			g.setColor(randomColor());			
			g.fillOval(circle.getX(), circle.getY(), circle.getRadius(), circle.getRadius());
		} else {
			for(Circle circle : circles) {
				g.setColor(randomColor());			
				g.fillOval(circle.getX(), circle.getY(), circle.getRadius(), circle.getRadius());
			}
		}
	}

	public Color randomColor() {
		return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
	}
}
