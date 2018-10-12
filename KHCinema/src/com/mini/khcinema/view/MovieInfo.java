package com.mini.khcinema.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.mini.khcinema.controller.MovieController;
import com.mini.khcinema.model.Movie;

public class MovieInfo extends JPanel {
	JPanel infoPanel;
	public MovieInfo(Movie movie) {
		setLayout(new BorderLayout(0, 0));
				
		JPanel btnPanel = new JPanel();
		add(btnPanel, BorderLayout.NORTH);
				
		//영화 정보 버튼
		JButton btnMovieInfo = new JButton("\uC601\uD654 \uC815\uBCF4");
		btnMovieInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				infoPanel.removeAll();
				infoPanel.add(new Info(movie));
				revalidate();
				repaint();
			}
			
		});
		btnPanel.add(btnMovieInfo);
		
		//영화 리뷰 버튼
		JButton btnReview = new JButton("\uC601\uD654 \uD6C4\uAE30");
		btnReview.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				infoPanel.removeAll();
				infoPanel.add(new Review(movie));
				revalidate();
				repaint();
			}			
		});
		btnPanel.add(btnReview);
				
		infoPanel = new Info(movie);
		add(infoPanel, BorderLayout.CENTER);
	}
}
