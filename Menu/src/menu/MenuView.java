package menu;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import shapes.*;

public class MenuView {
	
	private MovePanel movePanel;
	private DrawPanel drawPanel;
	
	public MenuView(String title) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		movePanel = new MovePanel(this);
		
		Circle[] circles = new Circle[15];
		for (int i = 0; i < circles.length; i++)
			circles[i] = new Circle((int)(Math.random() * 200)+200, (int)(Math.random() * 200)+200, (int)(Math.random() * 50) + 50);
		
		drawPanel = new DrawPanel(this, circles);
		
		frame.add(movePanel, BorderLayout.SOUTH);
		frame.add(drawPanel, BorderLayout.CENTER);
		
		JMenu menuMenu = new JMenu("Menu");
		JMenuItem[] menuItems = new JMenuItem[2];
		for (int i = 0; i < 2; i++) {
			menuItems[i]  = new JMenuItem("Pop is " + i);
			menuItems[i].addActionListener(new MenuListener(i));
			menuMenu.add(menuItems[i]);
		}
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menuMenu);
		frame.setJMenuBar(menuBar);
		
		frame.pack();
		frame.setVisible(true);	
	}

	public void drawUpdate() {
		drawPanel.repaint();
	}

	public void move(int key) {
		int dx = 0, dy = 0;
		switch(key) {
		case KeyEvent.VK_UP : dy = -10; break;
		case KeyEvent.VK_DOWN : dy = 10; break;
		case KeyEvent.VK_LEFT : dx = -10; break;
		case KeyEvent.VK_RIGHT : dx = 10; break;
		}
		drawPanel.move(dx, dy);
	}
	
	class MenuListener implements ActionListener {
		private boolean pop;

		public MenuListener(int nbr) {
			if(nbr == 1)
				pop = true;
			else
				pop = false;
		}

		public void actionPerformed(ActionEvent e) {
			drawPanel.setPop(pop);
			drawUpdate();
		}
	}
}
