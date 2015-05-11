package menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MoveButton extends JButton implements ActionListener{

	private MenuView view;
	private int key;
	
	public MoveButton(MenuView view, int key) {
		super(" ");
		addActionListener(this);
		this.view = view;
		this.key = key;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		view.move(key);
	}
}
