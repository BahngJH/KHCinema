package com.mini.khcinema.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mini.khcinema.controller.MovieController;

public class movieInputPanel extends JPanel {
	private JTextField tfTitle;
	private JTextField tfActors;
	private JTextField tfDirector;
	private JTextField tfpremier;
	private JTextField tfRuntime;
	private File f = null;

	public movieInputPanel(JFrame admin) {
		setBackground(new Color(255, 228, 196));
		setLayout(null);
		setSize(235, 334);

		JLabel lblNewLabel = new JLabel("영화 제목");
		lblNewLabel.setBounds(12, 10, 57, 15);
		add(lblNewLabel);

		tfTitle = new JTextField();
		tfTitle.setBounds(111, 7, 116, 21);
		add(tfTitle);
		tfTitle.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("출연진");
		lblNewLabel_1.setBounds(12, 35, 57, 15);
		add(lblNewLabel_1);

		tfActors = new JTextField();
		tfActors.setBounds(111, 32, 116, 21);
		add(tfActors);
		tfActors.setColumns(10);

		JLabel label = new JLabel("감독");
		label.setBounds(12, 63, 57, 15);
		add(label);

		tfDirector = new JTextField();
		tfDirector.setColumns(10);
		tfDirector.setBounds(111, 60, 116, 21);
		add(tfDirector);

		JLabel label_1 = new JLabel("개봉일");
		label_1.setBounds(12, 91, 57, 15);
		add(label_1);

		tfpremier = new JTextField();
		tfpremier.setColumns(10);
		tfpremier.setBounds(111, 88, 116, 21);
		add(tfpremier);

		JLabel label_2 = new JLabel("상영시간");
		label_2.setBounds(12, 119, 57, 15);
		add(label_2);

		tfRuntime = new JTextField();
		tfRuntime.setColumns(10);
		tfRuntime.setBounds(111, 116, 116, 21);
		add(tfRuntime);

		JLabel label_3 = new JLabel("줄거리");
		label_3.setBounds(12, 144, 57, 15);
		add(label_3);

		JTextPane tfSummary = new JTextPane();
		tfSummary.setBounds(111, 147, 116, 178);
		add(tfSummary);

		JFileChooser fc = new JFileChooser("C:");
		fc.setMultiSelectionEnabled(false);

		JButton btnImageAdd = new JButton("사진 선택");
		btnImageAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 파일 이름 텍스트.txt가 디폴트값
				// FileNameExtensionFilter filter = new FileNameExtensionFilter("텍스트", );
				// 위 내용 적용
				fc.setFileFilter(new FileFilter() {

					@Override
					public String getDescription() {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public boolean accept(File f) {
						String filename = f.getName();
						if (filename.indexOf(".jpg") != -1) {
							return true;
						} else if (f.isDirectory()) {
							return true;
						}

						return false;
					}
				});
				// 다이어로그 생성
				int result = fc.showOpenDialog(admin);
				// 예 확인시
				if (result == JFileChooser.APPROVE_OPTION) {
					// 파일 선택
					f = fc.getSelectedFile();
					btnImageAdd.setText(f.getName());
				}
			}
		});
		btnImageAdd.setFont(new Font("굴림", Font.PLAIN, 11));
		btnImageAdd.setBounds(0, 169, 99, 47);
		add(btnImageAdd);

		JButton btnAdd = new JButton("영화 추가");

		btnAdd.setBounds(0, 278, 97, 23);
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (String.valueOf(tfTitle.getText()).equals("")) {
					JOptionPane.showMessageDialog(admin, "제목을 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
				} else if (String.valueOf(tfActors.getText()).equals("")) {
					JOptionPane.showMessageDialog(admin, "출연진을 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
				} else if (String.valueOf(tfDirector.getText()).equals("")) {
					JOptionPane.showMessageDialog(admin, "감독을 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
				} else if (String.valueOf(tfpremier.getText()).equals("")) {
					JOptionPane.showMessageDialog(admin, "개봉일을 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
				} else if (String.valueOf(tfRuntime.getText()).equals("")) {
					JOptionPane.showMessageDialog(admin, "상영시간을 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
				} else if (String.valueOf(tfSummary.getText()).equals("")) {
					JOptionPane.showMessageDialog(admin, "즐거리를 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
				} else if (f == null) {
					JOptionPane.showMessageDialog(admin, "사진을 선택해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
				} else {
					new MovieController().inputMovie(String.valueOf(tfTitle.getText()),
							String.valueOf(tfActors.getText()), String.valueOf(tfDirector.getText()),
							String.valueOf(tfpremier.getText()), String.valueOf(tfRuntime.getText()), String.valueOf(tfSummary.getText()), f);
					
					
				}

			}
		});
		add(btnAdd);
		
		JButton button = new JButton("취소");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				admin.getContentPane().removeAll();
				admin.getContentPane().add(new AdminMainPanel(admin));
				admin.revalidate();
				admin.repaint();
				
			}
		});
		button.setBounds(0, 301, 97, 23);
		add(button);

	}
}
