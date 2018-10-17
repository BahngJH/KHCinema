package com.mini.khcinema.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {
	MainFrame mainFrame = this;
	//화면 전환이 되는 패널
	private JPanel startPanel;
	
	public JPanel getStartPanel() {
		return startPanel;
	}

	public void setStartPanel(JPanel startPanel) {
		this.startPanel = startPanel;
	}

	public MainFrame() {
		
		setSize(951, 600);
		setResizable(false);
		setTitle("KH Cinema");
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		startPanel = new StartPanel();
		getContentPane().add(startPanel, BorderLayout.CENTER);
		
		//상영 중인 영화 버튼
		ImageIcon ic = new ImageIcon("Images/nowMovie.png");
		Image originImg = ic.getImage();
		Image changedImg = originImg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ic = new ImageIcon(changedImg);
		
		JButton nowMovieButton = new JButton("  \uD604\uC7AC \uC0C1\uC601 \uC601\uD654", ic);
		nowMovieButton.setHorizontalAlignment(SwingConstants.LEFT);
		nowMovieButton.setBackground(new Color(179,228,227));
		nowMovieButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//화면 전환
				startPanel.removeAll();
				startPanel.add(new NowMoviePanel(startPanel));
				revalidate();
				repaint();
			}
		});
		panel.add(nowMovieButton);
		
		//영화 예매 버튼
		ic = new ImageIcon("Images/rserv.png");
		originImg = ic.getImage();
		changedImg = originImg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ic = new ImageIcon(changedImg);		
		
		JButton reserveButton = new JButton("  \uC601\uD654 \uC608\uB9E4", ic);
		reserveButton.setHorizontalAlignment(SwingConstants.LEFT);
		reserveButton.setBackground(new Color(210,251,239));
		reserveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//화면 전환
				startPanel.removeAll();
				startPanel.add(new ChoicePanel(startPanel));
				revalidate();
				repaint();
			}
		});
		panel.add(reserveButton);
		
		//음식 구매 버튼
		ic = new ImageIcon("Images/pop.png");
		originImg = ic.getImage();
		changedImg = originImg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ic = new ImageIcon(changedImg);	
		JButton foodButton = new JButton("  \uC74C\uC2DD \uAD6C\uB9E4", ic);
		foodButton.setHorizontalAlignment(SwingConstants.LEFT);
		foodButton.setBackground(new Color(179,228,200));
		panel.add(foodButton);
		
		
		//내 정보 버튼
		ic = new ImageIcon("Images/my.png");
		originImg = ic.getImage();
		changedImg = originImg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ic = new ImageIcon(changedImg);	
		JButton myMenuButton = new JButton("  \uB0B4 \uC815\uBCF4", ic);
		myMenuButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startPanel.removeAll();
				startPanel.add(new One(startPanel));
				revalidate();
				repaint();
				
			}
		});
		myMenuButton.setHorizontalAlignment(SwingConstants.LEFT);
		myMenuButton.setBackground(new Color(199,253,207));
		panel.add(myMenuButton);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
