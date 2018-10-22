package com.mini.khcinema.view.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mini.khcinema.controller.MemberController;
import java.awt.Color;
import java.awt.Font;

public class FindPanel extends JPanel {
	private String findpassword;
	private String findId1;
	private boolean find;

	public FindPanel(JFrame frame) {
		setBackground(Color.WHITE);
		frame.setSize(300, 400);
		frame.setTitle("KH 시네마 ID&Password 찾기");
		setLayout(null);

		// 라벨
		JLabel findId = new JLabel("ID를 모르실 경우");
		findId.setFont(new Font("굴림", Font.BOLD, 13));
		findId.setBounds(32, 10, 120, 30);
		add(findId);

		JLabel findPw = new JLabel("Password 모르실 경우");
		findPw.setFont(new Font("굴림", Font.BOLD, 13));
		findPw.setBounds(31, 161, 205, 30);
		add(findPw);

		JLabel mail = new JLabel("Mail 입력: ");
		mail.setBounds(32, 50, 70, 30);
		add(mail);

		JLabel id = new JLabel("ID 입력: ");
		id.setBounds(31, 202, 70, 30);
		add(id);

		JTextField texMail = new JTextField();
		texMail.setBounds(111, 50, 150, 30);
		add(texMail);

		JTextField texId = new JTextField();
		texId.setBounds(110, 202, 150, 30);
		add(texId);

		// 로그인 하기버튼 이벤트
		JButton backBtn = new JButton("로그인 하기");
		backBtn.setBounds(32, 302, 225, 30);
		backBtn.setForeground(Color.WHITE);
		backBtn.setBackground(Color.RED);
		add(backBtn);	
		backBtn.setBorderPainted(false);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new LoginPanel(frame));
				frame.getContentPane().revalidate();
				frame.getContentPane().repaint();

			}
		});

		// ID 찾기 버튼 이벤트
		JButton findIdBtn = new JButton("ID 찾기");
		findIdBtn.setBounds(111, 79, 150, 30);
		findIdBtn.setBackground(Color.WHITE);
		add(findIdBtn);
		findIdBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				findId1 = new MemberController().mailCheck(texMail.getText());
				JOptionPane.showMessageDialog(null, findId1);

			}
		});
		add(findIdBtn);
		findIdBtn.setBorderPainted(false);

		// Password 찾기 버튼 이벤트
		JButton findPwBtn = new JButton("Password 찾기");
		findPwBtn.setBounds(110, 231, 150, 30);
		findPwBtn.setBackground(Color.WHITE);
		add(findPwBtn);
		findPwBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				find = new MemberController().memberCheck(texId.getText());
				if (find) {
					JOptionPane.showMessageDialog(null, "일치하는 아이디가 없습니다.");

				} else {
					frame.getContentPane().removeAll();
					frame.getContentPane().add(new FindCheckPanel(frame));
					frame.getContentPane().revalidate();
					frame.getContentPane().repaint();

				}

			}
		});
		findPwBtn.setBorderPainted(false);

	}

}
