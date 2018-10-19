package com.mini.khcinema.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.mini.khcinema.controller.NowTimeController;

public class StartPanel extends JPanel {
	public StartPanel() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		// panel.setBackground(new Color(204, 0, 51));
		panel.setLayout(null);
		panel.setBounds(100, 100, 2000, 2000);
		add(panel);
		
		SimpleDateFormat timeform = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date time = new Date();
		
		String nowTime = timeform.format(time);
		
		JLabel TimeLabel = new JLabel(nowTime);
		TimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TimeLabel.setFont(new Font("Arial Black", Font.PLAIN, 25));
		TimeLabel.setBounds(219, 180, 313, 43);
		panel.add(TimeLabel);

		NowTimeController nowtime = new NowTimeController(TimeLabel);
		nowtime.start();

		ImageIcon icon1 = new ImageIcon("Images/mainlogo.png");
		Image ic1 = icon1.getImage();
		Image changedlmg = ic1.getScaledInstance(700, 200, Image.SCALE_SMOOTH);
		ImageIcon icon2 = new ImageIcon(changedlmg);

		JLabel jl = new JLabel(icon2);
		jl.setSize(700, 200);
		jl.setLocation(39, -10);
		panel.add(jl);

		String imgPath = "Images/mainlogo";
		ImageIcon originIcon = new ImageIcon(imgPath);

		/*
		 * ImageIcon icon3 = new ImageIcon("Images/4444.png"); Image
		 * ic2=icon3.getImage(); Image changedlmg1=ic2.getScaledInstance(800, 300,
		 * Image.SCALE_SMOOTH); ImageIcon icon4=new ImageIcon(changedlmg1); JLabel jl1 =
		 * new JLabel(icon4); jl1.setSize(800, 300); jl1.setLocation(-14, -20);
		 * panel.add(jl1);
		 */

		ImageIcon icon5 = new ImageIcon("Images/cgv.png");
		Image ic3 = icon5.getImage();
		Image changedlmg2 = ic3.getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
		ImageIcon icon6 = new ImageIcon(changedlmg2);
		JLabel jl2 = new JLabel(icon6);
		jl2.setSize(1200, 600);
		jl2.setLocation(-178, -206);
		panel.add(jl2);

		ImageIcon icon7 = new ImageIcon("Images/jj.png");
		Image ic4 = icon7.getImage();
		Image changedlmg3 = ic4.getScaledInstance(1100, 525, Image.SCALE_SMOOTH);
		ImageIcon icon8 = new ImageIcon(changedlmg3);
		
		JLabel jl4 = new JLabel(icon8);
		jl4.setSize(1100, 525);
		jl4.setLocation(-100, 135);
		panel.add(jl4);
		

	}

}
