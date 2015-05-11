package fractal;
import javax.swing.*;

import java.awt.event.*;

public class OrderDownButton extends JButton implements ActionListener {
	private FractalView view;

	public OrderDownButton(FractalView view) {
		super("<");
		this.view = view;
		addActionListener(this);
		this.setToolTipText("minskar fraktalens ordning.");
	}

	public void actionPerformed(ActionEvent ae) {
		Fractal fractal = view.getFractal();
		try {
			fractal.setOrder(fractal.getOrder() - 1);
		} catch(IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null,
					e.getMessage(), "Fractal",
					JOptionPane.ERROR_MESSAGE);
			fractal.setOrder(fractal.getOrder() + 1);
		}
		view.updateDrawing();
	}

}
