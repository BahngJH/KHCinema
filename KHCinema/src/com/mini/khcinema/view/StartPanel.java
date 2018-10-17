package com.mini.khcinema.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mini.khcinema.controller.NowTimeController;
import java.awt.Font;
import javax.swing.SwingConstants;

public class StartPanel extends JPanel {
	public StartPanel() {
		setLayout(new BorderLayout(0, 0));
				
		JPanel panel = new JPanel();
		panel.setBackground(new Color(199, 240, 253));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblKh = new JLabel("\uC548\uB155\uD558\uC138\uC694 KH\uC2DC\uB124\uB9C8\uC785\uB2C8\uB2E4.");
		lblKh.setBounds(273, 54, 156, 15);
		panel.add(lblKh);
		
		JLabel TimeLabel = new JLabel("timelabel");
		TimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TimeLabel.setFont(new Font("Arial Black", Font.PLAIN, 25));
		TimeLabel.setBounds(257, 258, 313, 43);
		panel.add(TimeLabel);
		
		//TimeLabel.setFont(new Font("맑은 고딕",Font.BOLD,30));
		NowTimeController nowtime = new NowTimeController(TimeLabel);
		nowtime.start();
		
	}
	
}
