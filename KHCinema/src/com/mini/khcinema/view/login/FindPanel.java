package com.mini.khcinema.view.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mini.khcinema.controller.MemberController;

public class FindPanel extends JPanel {
	private JTextField idTf;
	private JTextField mailTf;
	private String findpassword;
	private boolean find = false;
	private String ip;

	public FindPanel(JFrame frame) {
		frame.setSize(500, 300);
		frame.setTitle("KH 시네마 ID&Password 찾기");

		JLabel findPw = new JLabel("비밀번호를 모르실 경우");
		findPw.setBounds(44, 38, 150, 15);
		JLabel id = new JLabel("ID 입력: ");
		id.setBounds(44, 68, 60, 30);
		JLabel findIdPw = new JLabel("ID & Pass 모르실 경우");
		findIdPw.setBounds(44, 128, 150, 15);
		JLabel mail = new JLabel("Mail 입력: ");
		mail.setBounds(44, 158, 65, 30);

		idTf = new JTextField();
		mailTf = new JTextField();
		idTf.setBounds(113, 68, 150, 30);
		mailTf.setBounds(113, 158, 150, 30);
		setLayout(null);

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

		// 패스워드 찾기 버튼 이벤트
		JButton findPwBtn = new JButton("패스워드 찾기");
		findPwBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				findpassword = new MemberController().findPassword(idTf.getText());
				JOptionPane.showMessageDialog(null, findpassword);
			}
		});
		findPwBtn.setBounds(277, 68, 120, 30);
		add(findPwBtn);
		add(findIdPw);
		add(id);
		add(mail);
		add(findPw);
		add(idTf);
		add(mailTf);

		// ID&PW 찾기 버튼 이벤트
		JButton findIdPwBtn = new JButton("ID&PW 찾기");
		findIdPwBtn.setBounds(277, 158, 120, 30);
		add(findIdPwBtn);
		findIdPwBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ip = new MemberController().mailCheck(mailTf.getText());
				JOptionPane.showMessageDialog(null, ip);

			}
		});

	}

}
