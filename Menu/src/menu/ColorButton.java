package menu;

import java.awt.event.*;
import javax.swing.*;

public class ColorButton extends JButton implements ActionListener{
	
	private MenuView view;
	
	public ColorButton(MenuView view) {
		super(" ");
		this.view = view;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		view.drawUpdate();
	}
}
