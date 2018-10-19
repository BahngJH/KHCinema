package com.mini.khcinema.view.Info;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.mini.khcinema.controller.MovieController;
import com.mini.khcinema.model.Movie;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class MovieInfoPanel extends JPanel {
	JPanel infoPanel;
	public MovieInfoPanel(Movie movie) {
		setLayout(new BorderLayout(0, 0));
		JPanel btnPanel = new JPanel();
		btnPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnPanel.setBackground(new Color(255,242,230));
		add(btnPanel, BorderLayout.NORTH);
				
		//영화 정보 버튼
		JButton btnMovieInfo = new JButton("\uC601\uD654 \uC815\uBCF4");
		btnMovieInfo.setBackground(new Color(192, 192, 192));
		btnMovieInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				infoPanel.removeAll();
				infoPanel.add(new InfoPanel(movie));
				revalidate();
				repaint();
			}
			
		});
		btnPanel.add(btnMovieInfo);
		
		//영화 리뷰 버튼
		JButton btnReview = new JButton("\uC601\uD654 \uD6C4\uAE30");
		btnReview.setBackground(new Color(192, 192, 192));
		btnReview.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				infoPanel.removeAll();
				infoPanel.add(new ReviewPanel(movie));
				revalidate();
				repaint();
			}			
		});
		btnPanel.add(btnReview);
				
		infoPanel = new InfoPanel(movie);
		infoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(infoPanel, BorderLayout.CENTER);
	}
}
