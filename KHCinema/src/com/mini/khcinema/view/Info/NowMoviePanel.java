package com.mini.khcinema.view.Info;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.mini.khcinema.controller.MovieController;
import com.mini.khcinema.model.Movie;

public class NowMoviePanel extends JPanel {
	JPanel startPanel;
	JPanel nmp;
	
	public NowMoviePanel(JPanel startPanel) {
		this.startPanel = startPanel;
		nmp = this;
		
		setLayout(new GridLayout(2, 3));
		
		ArrayList<Movie> movies = new MovieController().getMovies();
		int size = movies.size();
		for (int i = 0; i < 6; i++) {
			if (size > i) {
				JButton image = new JButton();
				image.setBackground(new Color(245, 245, 220));
				add(image);
				
				ImageThread inputT = new ImageThread(image, movies.get(i));
				inputT.start();
			}
			else {
				JButton image = new JButton("상영 중인 영화 없음");
				image.setBackground(new Color(245, 245, 220));
				image.setEnabled(false);
				add(image);
			}
		}
		
		setVisible(true);
	}
	
	public class ImageThread extends Thread{
		JButton button;
		Movie movie;
		public ImageThread(JButton button, Movie movie) {
			this.button = button;
			this.movie = movie;
		}
		
		@Override
		public void run() {
			ImageIcon ic = new ImageIcon(movie.getImagePath());
			Image ic1 = ic.getImage();

			Image changedlmg = ic1.getScaledInstance(280, 280, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(changedlmg);

			button.setIcon(icon);
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					startPanel.removeAll();
					startPanel.add(new MovieInfoPanel(movie));
					startPanel.revalidate();
					startPanel.repaint();
				}
			});
		}
	}
}
