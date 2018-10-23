package com.mini.khcinema.view.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
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
import java.awt.Image;
import java.awt.RenderingHints.Key;

public class LoginPanel extends JPanel {

	public LoginPanel(JFrame frame) {
		setBackground(Color.WHITE);

		frame.setSize(400, 550);
		frame.setTitle("KH 시네마 ");
		setLayout(null);

		JTextField texId = new JTextField("KH시네마 계정");
		texId.setBounds(47, 170, 280, 30);

		JPasswordField texPass = new JPasswordField();
		texPass.setBounds(47, 210, 280, 30);

		JButton logbtn = new JButton("로그인");
		logbtn.setBackground(Color.RED);
		logbtn.setForeground(Color.WHITE);
		logbtn.setBounds(47, 322, 280, 40);
		JButton signUpbtn = new JButton("회원가입");
		signUpbtn.setBackground(Color.WHITE);
		signUpbtn.setBounds(47, 417, 100, 40);
		JButton findbtn = new JButton("l          ID&Password 찾기");
		findbtn.setBackground(Color.WHITE);
		findbtn.setBounds(153, 417, 200, 40);

		add(texPass);
		add(texId);
		add(texPass);
		add(logbtn);
		add(signUpbtn);
		add(findbtn);

		JLabel idHintLabel = new JLabel();
		idHintLabel.setBounds(150, 85, 151, 15);
		add(idHintLabel);

		logbtn.setBorderPainted(false);
		signUpbtn.setBorderPainted(false);
		findbtn.setBorderPainted(false);
		
		
		String imgPathPayment3 = "Images/mainlogo.png";
		ImageIcon originIconpayment3 = new ImageIcon(imgPathPayment3);
		Image originImgPayment3 = originIconpayment3.getImage();
		Image changedImgPayment3 = originImgPayment3.getScaledInstance(350, 150, Image.SCALE_SMOOTH);
		ImageIcon Icon3 = new ImageIcon(changedImgPayment3);
		JLabel img3 = new JLabel(Icon3);
		img3.setSize(428, 140);
		img3.setLocation(-20, 20);
		add(img3);
		
		
		

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

				if (texId.getText().equals("KH시네마 계정")) {
					texId.setText("");
				} else {
					if (texId.getText().isEmpty() && e.getKeyChar() == '\b') {
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
