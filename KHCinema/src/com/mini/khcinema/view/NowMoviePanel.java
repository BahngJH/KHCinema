package com.mini.khcinema.view;

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

	public NowMoviePanel(JPanel startPanel) {
		ArrayList<Movie> movies = new MovieController().getMovies();
		int size = movies.size();
		for (int i = 0; i < 6; i++) {
			if (size > i) {
				Movie movie = movies.get(i);
				ImageIcon ic = new ImageIcon(movie.getImagePath());
				Image ic1 = ic.getImage();

				Image changedlmg = ic1.getScaledInstance(280, 280, Image.SCALE_SMOOTH);
				ImageIcon icon = new ImageIcon(changedlmg);

				JButton image = new JButton(icon);
				image.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						startPanel.removeAll();
						startPanel.add(new MovieInfoPanel(movie));
						startPanel.revalidate();
						startPanel.repaint();
					}
				});
				add(image);
			}
			else {
				JButton image = new JButton("상영 중인 영화 없음");
				image.setEnabled(false);
				add(image);
			}
		}
		setLayout(new GridLayout(2, 3));

		setVisible(true);

	}
}
