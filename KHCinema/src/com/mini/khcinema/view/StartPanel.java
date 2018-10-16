package com.mini.khcinema.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPanel extends JPanel {
	public StartPanel() {
		setLayout(new BorderLayout(0, 0));
				
		JPanel panel = new JPanel();
		panel.setBackground(new Color(199, 240, 253));
		add(panel, BorderLayout.CENTER);
		
		JLabel lblKh = new JLabel("\uC548\uB155\uD558\uC138\uC694 KH\uC2DC\uB124\uB9C8\uC785\uB2C8\uB2E4.");
		panel.add(lblKh);
	}

}
