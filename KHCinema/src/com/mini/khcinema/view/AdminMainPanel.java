package com.mini.khcinema.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import com.mini.khcinema.controller.MovieController;
import com.mini.khcinema.model.Movie;

public class AdminMainPanel extends JPanel {
	public AdminMainPanel(JFrame admin) {
		MovieController mc = new MovieController();
		ArrayList<Movie> movies = mc.getMovies();
		
		String [] titles = new String[movies.size()];
		
		for(int i=0;i<movies.size();i++) {
			titles[i] = movies.get(i).getTitle();
		}
		
		setBackground(new Color(255, 228, 196));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("현재 상영 중인 영화 수 : ");
		lblNewLabel.setBounds(25, 10, 161, 18);
		add(lblNewLabel);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		
		JLabel movieCountLabel = new JLabel(movies.size() +"개");
		movieCountLabel.setBounds(183, 10, 22, 18);
		add(movieCountLabel);
		movieCountLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		
		JList<String> movieList = new JList<String>(titles);
		movieList.setBackground(new Color(240, 248, 255));
		movieList.setBounds(25, 38, 180, 223);
		add(movieList);
		movieList.setFont(new Font("굴림", Font.PLAIN, 14));
		movieList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton movieDeleteButton = new JButton("선택한 영화 삭제");
		movieDeleteButton.setBackground(new Color(255, 182, 193));
		movieDeleteButton.setBounds(25, 271, 180, 23);
		add(movieDeleteButton);
		
		JButton addButton = new JButton("영화 추가하기");	
		addButton.setBackground(new Color(255, 192, 203));
		addButton.setBounds(25, 304, 180, 23);
		add(addButton);
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				admin.getContentPane().removeAll();
				admin.getContentPane().add(new movieInputPanel(admin));
				admin.revalidate();
				admin.repaint();
			}
			
		});
		movieDeleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int sel = movieList.getSelectedIndex();
				//movieList.remove(sel);
				movies.remove(sel);
				DefaultListModel<String> dlm = new DefaultListModel<>();
				
				for(int i=0; i<movies.size();i++) {
					dlm.addElement(movies.get(i).getTitle());
				}
				
				movieList.setModel(dlm);
				movieCountLabel.setText(movies.size() +"개");
								
				mc.saveMovies(movies);
			}
		});
	}
}
