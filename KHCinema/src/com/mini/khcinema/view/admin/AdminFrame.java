package com.mini.khcinema.view.admin;

import java.awt.BorderLayout;
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

public class AdminFrame extends JFrame {
	AdminFrame admin = this;
	public AdminFrame() {
		setResizable(false);
		setLocationRelativeTo(null);
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setBackground(new Color(255, 228, 181));
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(new AdminMainPanel(this));
				
		setSize(235,365);
		setVisible(true);
	}
}
