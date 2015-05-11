package mountain;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import fractal.*;

public class Mountain extends Fractal {
	private Point a, b, c;
	private double dev;
	private LinkedList<Side> sides;

	/** Creates an object that handles Koch's fractal. 
	 * @param length the length of the triangle side
	 */
	public Mountain(Point a, Point b, Point c, double dev) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.dev = dev;
		sides = new LinkedList<Side>();
	}

	/**
	 * Returns the title.
	 * @return the title
	 */
	public String getTitle() {
		return "Mountains triangel with " + dev + " dev";
	}

	/** Draws the fractal.  
	 * @param turtle the turtle graphic object
	 */
	public void draw(TurtleGraphics turtle) {
		fractalTriangle(turtle, order, a, b, c, dev);
	}

	/* Reursive method: Draws a recursive line of the triangle. */
	private void fractalTriangle(TurtleGraphics turtle, int order, Point a, Point b, Point c, double dev) {
		if(order == 0) {
			turtle.moveTo(a.getX(), a.getY());
			turtle.forwardTo(b.getX(), b.getY());
			turtle.forwardTo(c.getX(), c.getY());
			turtle.forwardTo(a.getX(), a.getY());
		}
		else {
			Point ab = getMid(a, b, dev);
			Point bc = getMid(b, c, dev);
			Point ac = getMid(a, c, dev);
			fractalTriangle(turtle, order - 1, ab, bc, ac, dev/2);
			fractalTriangle(turtle, order - 1, a, ab, ac, dev/2);
			fractalTriangle(turtle, order - 1, b, ab, bc, dev/2);
			fractalTriangle(turtle, order - 1, c, bc, ac, dev/2);
		}
	}
	
	private Point getMid(Point a, Point b, double dev) {
		Side s = new Side(a, b, null);
		Iterator<Side> itr = sides.iterator();
		while(itr.hasNext()) {
			Side temp = itr.next();
			if(temp.equals(s)) {
				sides.remove(temp);
				return temp.getMid();
			}
		}
		Point mid = new Point((a.getX()+b.getX())/2, (a.getY()+b.getY())/2 - RandomUtilities.randFunc(dev));
		sides.add(new Side(a, b, mid));
		return mid;
	}
}
