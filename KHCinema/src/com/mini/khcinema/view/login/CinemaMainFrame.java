package com.mini.khcinema.view.login;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CinemaMainFrame extends JFrame {

	public CinemaMainFrame(String theaterName) {
		super(theaterName);

		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("Images/mainlogosmall.png");
		setIconImage(img);

		JPanel pan = new JPanel();
		getContentPane().add(pan);
		pan.setLayout(new BorderLayout(0, 0));

		JPanel loginPan = new LoginPanel(this);
		pan.add(loginPan);
		
		
		
		
		

		setVisible(true);

	}

}
