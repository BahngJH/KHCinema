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

public class FindPanel extends JPanel {
	private String findpassword;
	private String findId1;
	private boolean find;

	public FindPanel(JFrame frame) {
		frame.setSize(500, 300);
		frame.setTitle("KH 시네마 ID&Password 찾기");
		setLayout(null);

		// 라벨
		JLabel findId = new JLabel("ID를 모르실 경우");
		findId.setBounds(44, 38, 150, 15);
		add(findId);

		JLabel findPw = new JLabel("Password 모르실 경우");
		findPw.setBounds(44, 128, 150, 30);
		add(findPw);

		JLabel mail = new JLabel("Mail 입력: ");
		mail.setBounds(44, 68, 70, 30);
		add(mail);

		JLabel id = new JLabel("ID 입력: ");
		id.setBounds(44, 158, 70, 30);
		add(id);

		JTextField texMail = new JTextField();
		texMail.setBounds(115, 68, 150, 30);
		add(texMail);

		JTextField texId = new JTextField();
		texId.setSize(150, 30);
		texId.setLocation(115, 158);
		add(texId);

		// 뒤로가기버튼 이벤트
		JButton backBtn = new JButton("뒤로가기");
		backBtn.setBounds(199, 223, 120, 30);
		add(backBtn);
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
		findIdBtn.setBounds(277, 68, 130, 30);
		add(findIdBtn);
		findIdBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				findId1 = new MemberController().mailCheck(texMail.getText());
				JOptionPane.showMessageDialog(null, findId1);

			}
		});

		findIdBtn.setBounds(277, 68, 130, 30);
		add(findIdBtn);

		// Password 찾기 버튼 이벤트
		JButton findPwBtn = new JButton("Password 찾기");
		findPwBtn.setBounds(277, 158, 130, 30);
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

	}

}
