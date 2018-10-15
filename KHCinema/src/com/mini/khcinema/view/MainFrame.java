package com.mini.khcinema.view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		
		setSize(900, 600);
		setResizable(false);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		startPanel = new StartPanel();
		getContentPane().add(startPanel, BorderLayout.CENTER);
		
		//상영 중인 영화 버튼
		JButton nowMovieButton = new JButton("\uD604\uC7AC \uC0C1\uC601 \uC601\uD654");
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
		JButton reserveButton = new JButton("\uC601\uD654 \uC608\uB9E4");
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
		JButton foodButton = new JButton("\uC74C\uC2DD \uAD6C\uB9E4");
		panel.add(foodButton);
		
		
		//내 정보 버튼
		JButton myMenuButton = new JButton("\uB0B4 \uC815\uBCF4");
		panel.add(myMenuButton);
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
