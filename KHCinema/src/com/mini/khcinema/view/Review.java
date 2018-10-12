package com.mini.khcinema.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.mini.khcinema.model.Movie;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class Review extends JPanel {
	private JTextField commentField;
	private ArrayList<String> comments = new ArrayList<>();

	public Review(Movie movie) {
		setLayout(new BorderLayout(0, 0));

		JPanel titlePanel = new JPanel();
		add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new BorderLayout(0, 0));

		JLabel reviewTitleLabel = new JLabel(movie.getTitle() + "의 후기");
		reviewTitleLabel.setFont(new Font("굴림", Font.PLAIN, 23));
		titlePanel.add(reviewTitleLabel, BorderLayout.CENTER);
		
		

		JPanel commentPanel = new JPanel();
		add(commentPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_commentPanel = new GridBagLayout();
		gbl_commentPanel.columnWidths = new int[] { 384, 64, 0 };
		gbl_commentPanel.rowHeights = new int[] { 23, 0 };
		gbl_commentPanel.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_commentPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		commentPanel.setLayout(gbl_commentPanel);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		panel.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane);
		String filename = movie.getTitle() + "리뷰" + ".txt";
		// 리뷰 파일 열어서 정보 가져오기
		getComment(filename);
		
		// 리뷰 창에 추가
		for (String s : comments) {
			textArea.append(s+"\n");
		}

		commentField = new JTextField();
		commentField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					inputComment(commentField.getText(), filename);
					textArea.append(commentField.getText()+"\n");
					commentField.setText("");
				}
			}

		});
		GridBagConstraints gbc_commentField = new GridBagConstraints();
		gbc_commentField.fill = GridBagConstraints.BOTH;
		gbc_commentField.insets = new Insets(0, 0, 0, 5);
		gbc_commentField.gridx = 0;
		gbc_commentField.gridy = 0;
		commentPanel.add(commentField, gbc_commentField);
		commentField.setColumns(10);

		JButton inputButton = new JButton("입력");
		inputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == inputButton) {
					inputComment(commentField.getText(), filename);
					textArea.append(commentField.getText()+"\n");
					commentField.setText("");
				}
			}
		});
		GridBagConstraints gbc_inputButton = new GridBagConstraints();

		gbc_inputButton.gridx = 1;
		gbc_inputButton.gridy = 0;
		commentPanel.add(inputButton, gbc_inputButton);
		
		

	}

	public void inputComment(String comment, String filename) {
		if (!comment.equals("")) {
			comments.add(comment);

			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
				oos.writeObject(comments);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void getComment(String filename) {
		File file = new File(filename);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			comments = (ArrayList<String>) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
