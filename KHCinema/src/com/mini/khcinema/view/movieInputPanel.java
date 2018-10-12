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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class movieInputPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public movieInputPanel(JFrame admin) {
		setBackground(new Color(255, 228, 196));
		setLayout(null);
		setSize(235, 365);

		JLabel lblNewLabel = new JLabel("영화 제목");
		lblNewLabel.setBounds(12, 10, 57, 15);
		add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(92, 7, 116, 21);
		add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("출연진");
		lblNewLabel_1.setBounds(12, 35, 57, 15);
		add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(92, 32, 116, 21);
		add(textField_1);
		textField_1.setColumns(10);

		JLabel label = new JLabel("감독");
		label.setBounds(12, 63, 57, 15);
		add(label);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(92, 60, 116, 21);
		add(textField_2);

		JLabel label_1 = new JLabel("개봉일");
		label_1.setBounds(12, 91, 57, 15);
		add(label_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(92, 88, 116, 21);
		add(textField_3);

		JLabel label_2 = new JLabel("상영시간");
		label_2.setBounds(12, 119, 57, 15);
		add(label_2);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(92, 116, 116, 21);
		add(textField_4);

		JLabel label_3 = new JLabel("줄거리");
		label_3.setBounds(12, 144, 57, 15);
		add(label_3);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(92, 147, 116, 159);
		add(textPane);

		JFileChooser fc = new JFileChooser("C:");
		fc.setMultiSelectionEnabled(false);

		JButton imageAddButton = new JButton("사진 선택");
		imageAddButton.addActionListener(new ActionListener() {
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
						if (filename.indexOf(".png") != -1) {
							return true;
						} else if (filename.indexOf(".jpg") != -1) {
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
					File f = fc.getSelectedFile();
						System.out.println("선택한 파일:" + f.getName());
				}
			}
		});
		imageAddButton.setFont(new Font("굴림", Font.PLAIN, 11));
		imageAddButton.setBounds(0, 259, 85, 47);
		add(imageAddButton);

	}
}
