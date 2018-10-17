package com.mini.khcinema.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mini.khcinema.controller.MemberController;

public class LoginPanel extends JPanel {

	public LoginPanel(JFrame frame) {

		frame.setSize(500, 300);
		frame.setTitle("KH 시네마 ");
		JLabel id = new JLabel("아이디: ");
		id.setBounds(73, 78, 60, 30);
		JLabel password = new JLabel("비밀번호: ");
		password.setBounds(73, 118, 60, 30);

		JLabel kh = new JLabel("KH 시네마 로그인");
		kh.setBounds(73, 26, 140, 30);
		add(kh);

		JTextField texId = new JTextField(10);
		texId.setBounds(143, 78, 180, 30);
		JPasswordField texPass = new JPasswordField(10);
		texPass.setBounds(143, 118, 180, 30);

		JButton logbtn = new JButton("로그인");
		logbtn.setBounds(341, 78, 83, 70);
		JButton signUpbtn = new JButton("회원가입");
		signUpbtn.setBounds(73, 172, 140, 50);
		JButton findbtn = new JButton("ID&Password 찾기");
		findbtn.setBounds(244, 173, 181, 50);
		setLayout(null);

		add(id);
		add(texId);
		add(password);
		add(texPass);
		add(logbtn);
		add(signUpbtn);
		add(findbtn);

		logbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e1) {// 로그인하기

				boolean login = new MemberController().loginCheck(texId.getText(), texPass.getText());

				if (login) {
					JOptionPane.showMessageDialog(null, "        로그인 성공");
					new MainFrame();
					frame.dispose();

				} else {
					JOptionPane.showMessageDialog(null, "ID&Password가 올바르지 않습니다.");

				}

			}
		});

		signUpbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e2) {// 회원가입 하기
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new SignUpPanel(frame));
				frame.getContentPane().revalidate();
				frame.getContentPane().repaint();

			}
		});
	}
}
