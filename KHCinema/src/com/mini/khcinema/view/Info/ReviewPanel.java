package com.mini.khcinema.view.Info;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mini.khcinema.controller.ReviewController;
import com.mini.khcinema.model.Movie;
import com.mini.khcinema.model.Review;

public class ReviewPanel extends JPanel {
	private JTextField commentField;
	private ArrayList<String> comments = new ArrayList<>();
	ReviewController rc = new ReviewController();

	public ReviewPanel(Movie movie) {
		setLayout(new BorderLayout(0, 0));
		setBackground(new Color(245, 245, 220));

		// 타이틀 패널
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(245, 245, 220));
		add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new BorderLayout(0, 0));

		JLabel reviewTitleLabel = new JLabel(movie.getTitle() + "의 후기");
		reviewTitleLabel.setFont(new Font("굴림", Font.PLAIN, 23));
		titlePanel.add(reviewTitleLabel, BorderLayout.CENTER);

		// 리뷰 패널
		JPanel commentPanel = new JPanel();
		add(commentPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_commentPanel = new GridBagLayout();
		gbl_commentPanel.columnWidths = new int[] { 364, 30, 64, 0 };
		gbl_commentPanel.rowHeights = new int[] { 23, 0 };
		gbl_commentPanel.columnWeights = new double[] { 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_commentPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		commentPanel.setLayout(gbl_commentPanel);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		// 리뷰가 달리는 testArea
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		panel.add(textArea);

		JScrollPane scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane);

		String filename = movie.getTitle() + "리뷰" + ".txt";
		// 리뷰 파일 열어서 정보 가져오기
		ArrayList<Review> reviews = rc.getComment(filename);

		// 리뷰 창에 추가
		for (Review r : reviews) {
			textArea.append(r.getComment() + "\t[" + r.getScore() + "점]\n");
		}

		// 댓글을 입력하는 textField
		commentField = new JTextField();

		GridBagConstraints gbc_commentField = new GridBagConstraints();
		gbc_commentField.fill = GridBagConstraints.BOTH;
		gbc_commentField.insets = new Insets(0, 0, 0, 5);
		gbc_commentField.gridx = 0;
		gbc_commentField.gridy = 0;
		commentPanel.add(commentField, gbc_commentField);
		commentField.setColumns(10);

		// 평점을 선택하는 콤보박스
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "10", "9", "8", "7", "6", "5", "4", "3", "2", "1", "0" }));
		comboBox.setMaximumRowCount(11);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		commentPanel.add(comboBox, gbc_comboBox);
		GridBagConstraints gbc_inputButton = new GridBagConstraints();

		// 댓글을 입력하고 엔터를 누르면 등록되도록 하는 이벤트
		commentField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!commentField.getText().equals("")) {
						String score = (String) comboBox.getSelectedItem();
						rc.inputComment(commentField.getText(), filename, score);
						textArea.append(commentField.getText() + "\t[" + score + "점]\n");
						commentField.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "댓글을 입력해주세요.");
					}
				}
			}

		});

		// 댓글을 입력하고 버튼을 누르면 등록되도록 하는 이벤트
		JButton inputButton = new JButton("입력");
		inputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!commentField.getText().equals("")) {
					String score = (String) comboBox.getSelectedItem();
					rc.inputComment(commentField.getText(), filename, score);
					textArea.append(commentField.getText() + "\t[" + score + "점]\n");
					commentField.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "댓글을 입력해주세요.");
				}
			}
		});

		gbc_inputButton.gridx = 2;
		gbc_inputButton.gridy = 0;
		commentPanel.add(inputButton, gbc_inputButton);

	}
}
