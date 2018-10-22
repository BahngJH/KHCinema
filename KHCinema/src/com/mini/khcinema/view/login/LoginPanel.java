package com.mini.khcinema.view.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mini.khcinema.controller.MemberController;
import com.mini.khcinema.view.MainFrame;
import com.mini.khcinema.view.admin.AdminFrame;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.RenderingHints.Key;

public class LoginPanel extends JPanel {

	public LoginPanel(JFrame frame) {

		frame.setSize(500, 300);
		frame.setTitle("KH 시네마 ");
		setLayout(null);

		JLabel kh = new JLabel("KH 시네마 로그인");
		kh.setBounds(73, 26, 140, 30);
		add(kh);

		JTextField texId = new JTextField("KH시네마 계정");
		texId.setBounds(143, 78, 180, 30);

		JPasswordField texPass = new JPasswordField();
		texPass.setBounds(143, 118, 180, 30);

		JButton logbtn = new JButton("로그인");
		logbtn.setBounds(341, 78, 83, 70);
		JButton signUpbtn = new JButton("회원가입");
		signUpbtn.setBounds(73, 172, 140, 50);
		JButton findbtn = new JButton("ID&Password 찾기");
		findbtn.setBounds(244, 173, 181, 50);

		add(texPass);
		add(texId);
		add(texPass);
		add(logbtn);
		add(signUpbtn);
		add(findbtn);
		
		JLabel idHintLabel = new JLabel();
		idHintLabel.setBounds(150, 85, 151, 15);
		add(idHintLabel);

		texId.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				texId.setText("");
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		texId.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				

			}

			@Override
			public void keyTyped(KeyEvent e) {
				
				if(texId.getText().equals("KH시네마 계정")) {
					texId.setText("");
				}else {
				if(texId.getText().isEmpty() && e.getKeyChar() == '\b') {
					texId.setText("KH시네마 계정");
				}
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		// 로그인 버튼 이벤트
		logbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e1) {// 로그인하기

				String login = new MemberController().loginCheck(texId.getText(), texPass.getText());

				if (login.equals("true")) {
					new MainFrame();
					frame.dispose();

				} else if (login.equals("admin")) {
					new AdminFrame();
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "ID&Password가 올바르지 않습니다.");

				}

			}
		});

		// 회원가입 버튼 이벤트
		signUpbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e2) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new SignUpPanel(frame));
				frame.getContentPane().revalidate();
				frame.getContentPane().repaint();

			}
		});

		// ID&Password 찾기 버튼 이벤트

		findbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e3) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new FindPanel(frame));
				frame.getContentPane().revalidate();
				frame.getContentPane().repaint();

			}
		});
	}
}
