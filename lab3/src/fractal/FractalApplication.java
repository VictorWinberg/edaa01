package fractal;

import koch.Koch;
import mountain.*;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[10];
		fractals[0] = new Koch(300);
		for(int i = 0; i < 5; i++)
			fractals[i+1] = new Mountain(new Point(10, 590), new Point(590, 590), new Point(400, 10), i * 25);
		for(int i = 0; i < 5; i++)
			fractals[i+5] = new Fucked(new Point(10, 590), new Point(590, 590), new Point(400, 10), i * 25);
		new FractalView(fractals, "Fraktaler");
	}
}