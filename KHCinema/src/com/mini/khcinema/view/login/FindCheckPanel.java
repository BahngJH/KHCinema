package com.mini.khcinema.view.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mini.khcinema.controller.MemberController;

public class FindCheckPanel extends JPanel {
	String hintAs;
	String comboHint1;

	public FindCheckPanel(JFrame frame) {

		frame.setSize(500, 250);
		frame.setTitle("KH시네마 비밀번호 찾기 힌트");
		setLayout(null);

		// 비밀번호 힌트 라벨
		JLabel hint = new JLabel("비밀번호 힌트: ");
		hint.setBounds(44, 38, 100, 15);
		add(hint);
		JLabel answer = new JLabel("답: ");
		answer.setBounds(44, 60, 25, 15);
		add(answer);

		// 비밀번호 질문 선택 콤보박스
		String[] hint1 = { "어렸을적 별명은?", "출신 초등학교는?", "내 이름은?", "좋아하는 색은?", "부모님 성함?" };
		JComboBox comboHint = new JComboBox(hint1);
		comboHint.setBounds(147, 35, 140, 20);
		add(comboHint);

		// 비밀번호 답변
		JTextField answer1 = new JTextField();
		answer1.setBounds(147, 60, 140, 20);
		setBounds(60, 85, 462, 283);
		add(answer1);

		JButton backBtn = new JButton("뒤로 가기");
		backBtn.setBounds(44, 93, 100, 20);
		add(backBtn);

		JButton loginBtn = new JButton("로그인");
		loginBtn.setBounds(140, 93, 88, 20);
		add(loginBtn);

		JButton checkBtn = new JButton("비밀번호 확인");
		checkBtn.setBounds(227, 93, 118, 20);
		add(checkBtn);

		// 뒤로가기 버튼 리스너
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new FindPanel(frame));
				frame.getContentPane().revalidate();
				frame.getContentPane().repaint();

			}
		});

		// 로그인 버튼 리스너

		loginBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new LoginPanel(frame));
				frame.getContentPane().revalidate();
				frame.getContentPane().repaint();

			}

		});

		// 비밀번호 확인 버튼 리스너

		checkBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				hintAs = new MemberController().findPassword(((String) (comboHint.getSelectedItem())),
						answer1.getText());
				JOptionPane.showMessageDialog(null, hintAs);

			}

		});
	}
}
