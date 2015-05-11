package menu;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MovePanel extends JPanel {
	
	public MovePanel(MenuView view) {
		setLayout(new BorderLayout());
		add(new MoveButton(view, KeyEvent.VK_UP), BorderLayout.NORTH);
		add(new MoveButton(view, KeyEvent.VK_RIGHT), BorderLayout.EAST);
		add(new MoveButton(view, KeyEvent.VK_LEFT), BorderLayout.WEST);
		add(new MoveButton(view, KeyEvent.VK_DOWN), BorderLayout.SOUTH);
		
		add(new ColorButton(view), BorderLayout.CENTER);
	}
}
