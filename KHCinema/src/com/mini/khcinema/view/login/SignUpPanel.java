package com.mini.khcinema.view.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.mini.khcinema.controller.MemberController;

public class SignUpPanel extends JPanel {
	private JTextField idTxt;
	private JPasswordField passwordTxt;
	private JTextField nameTxt;
	private JTextField mailTxt;
	private JTextField addTxt;
	private JTextField phoneTxt1;
	private boolean idck = false;
	private JTextField monthTxt;
	private JTextField dateTxt;
	private JTextField hintText;

	public SignUpPanel(JFrame frame) {
		setBackground(Color.WHITE);

		frame.setSize(480, 550);
		frame.setTitle("KH 시네마 회원가입");

		JLabel cinemaLb = new JLabel("회원가입");
		cinemaLb.setFont(new Font("굴림", Font.BOLD, 13));
		cinemaLb.setBackground(Color.BLACK);
		cinemaLb.setBounds(40, 15, 72, 20);
		add(cinemaLb);

		JLabel id = new JLabel("ID: ");// ID 라벨
		id.setBounds(40, 60, 25, 20);
		id.setFont(new Font("굴림", Font.PLAIN, 13));
		add(id);

		JLabel nameLb = new JLabel("이름 :");// 이름 라벨
		nameLb.setBounds(40, 210, 34, 20);
		nameLb.setFont(new Font("굴림", Font.PLAIN, 13));
		add(nameLb);

		JLabel birtLb = new JLabel("법정생년월일 : ");// 생년월일 라벨
		birtLb.setBounds(40, 240, 95, 20);
		birtLb.setFont(new Font("굴림", Font.PLAIN, 13));
		add(birtLb);

		JLabel passwordLb = new JLabel("Password: ");// Password 라벨
		passwordLb.setBounds(40, 90, 70, 20);
		add(passwordLb);

		JLabel pwcLb = new JLabel("Password 확인: ");// Password 확인 라벨
		pwcLb.setBounds(40, 120, 95, 20);
		add(pwcLb);

		JLabel yearLb = new JLabel("년");
		yearLb.setBounds(204, 240, 15, 20);
		add(yearLb);

		JLabel monLb = new JLabel("월");
		monLb.setBounds(280, 240, 15, 20);
		add(monLb);

		JLabel dateLb = new JLabel("일");
		dateLb.setBounds(359, 240, 15, 20);
		add(dateLb);

		JLabel phoneLb = new JLabel("전화번호 : ");// 전화번호 라벨
		phoneLb.setBounds(40, 270, 64, 20);
		phoneLb.setFont(new Font("굴림", Font.PLAIN, 13));
		add(phoneLb);

		JLabel sxLb = new JLabel("회원 성별 :");// 회원성별 라벨
		sxLb.setBounds(256, 270, 70, 20);
		add(sxLb);

		JLabel mailLb = new JLabel("이메일 : ");// 이메일 라벨
		mailLb.setBounds(40, 300, 60, 20);
		mailLb.setFont(new Font("굴림", Font.PLAIN, 13));
		add(mailLb);

		JLabel addLb = new JLabel("주소 : ");// 주소 라벨
		addLb.setBounds(40, 330, 40, 20);
		addLb.setFont(new Font("굴림", Font.PLAIN, 13));
		add(addLb);

		// 남,녀 선택버튼
		JRadioButton female;
		JRadioButton male;
		ButtonGroup bg = new ButtonGroup();
		setLayout(null);

		male = new JRadioButton("남");// 남자 선택 버튼
		male.setBounds(324, 270, 40, 20);

		female = new JRadioButton("여");// 여자 선택 버튼
		female.setBounds(374, 270, 40, 20);

		bg.add(male);
		bg.add(female);
		add(male);
		add(female);
		
		

		idTxt = new JTextField();// ID 입력필드
		idTxt.setBounds(135, 60, 120, 20);
		add(idTxt);
		idTxt.setColumns(10);

		passwordTxt = new JPasswordField(10);// 패스워드 입력필드
		passwordTxt.setBounds(135, 120, 120, 20);
		add(passwordTxt);

		JPasswordField pwcTxt = new JPasswordField(10);// 패스워드 재확인 입력필드
		pwcTxt.setBounds(135, 90, 120, 20);
		add(pwcTxt);

		nameTxt = new JTextField();// 이름 입력창
		nameTxt.setBounds(135, 210, 120, 20);
		nameTxt.setColumns(10);
		add(nameTxt);

		mailTxt = new JTextField(10);// 메일 입력필드
		mailTxt.setBounds(135, 300, 115, 20);
		add(mailTxt);

		addTxt = new JTextField(10);// 주소 입력 필드
		addTxt.setBounds(135, 330, 290, 20);
		add(addTxt);

		phoneTxt1 = new JTextField(13);// 핸드폰 입력 필드
		phoneTxt1.setBounds(135, 270, 115, 20);
		add(phoneTxt1);

		// 비밀번호 찾기 힌트 콤보박스
		String[] hint = { "어렸을적 별명은?", "출신 초등학교는?", "내 이름은?", "좋아하는 색은?", "부모님 성함?" };
		JComboBox comboHint = new JComboBox(hint);
		comboHint.setBounds(135, 150, 136, 20);
		add(comboHint);

		JLabel hintLb = new JLabel("비밀번호 힌트:");// 비밀번호 힌트 라벨
		hintLb.setFont(new Font("굴림", Font.PLAIN, 13));
		hintLb.setBounds(40, 150, 95, 20);
		add(hintLb);

		JLabel hint1 = new JLabel("힌트 답 : ");// 비밀번호 힌트 답 라벨
		hint1.setFont(new Font("굴림", Font.PLAIN, 13));
		hint1.setBounds(40, 180, 95, 20);
		add(hint1);

		hintText = new JTextField(13);// 비밀번호 찾기 답 필드
		hintText.setBounds(135, 180, 115, 20);
		add(hintText);

		// 년도 콤보박스
		String[] year = new String[2018 - 1898];
		int j = 0;
		for (int i = 2018; i > 1899; i--) {
			year[j] = String.valueOf(i);
			j++;

		}

		JComboBox<String> comboyear = new JComboBox(year);
		comboyear.setBounds(135, 240, 60, 19);
		add(comboyear);

		// 월 콤보박스
		String[] month = new String[12];
		for (int l = 1; l < 13; l++) {
			month[l - 1] = String.valueOf(l);
		}
		JComboBox<String> combomonth = new JComboBox(month);
		combomonth.setBounds(225, 240, 40, 20);
		add(combomonth);

		// 일 콤보박스
		String[] date = new String[31];
		for (int k = 1; k < 32; k++) {
			date[k - 1] = String.valueOf(k);

		}
		JComboBox<String> combodate = new JComboBox(date);
		combodate.setBounds(304, 240, 40, 20);
		add(combodate);

		// ID중복확인 버튼 이벤트
		JButton idckBtn = new JButton("ID 중복확인 ");
		idckBtn.setBackground(Color.WHITE);
		idckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idck = new MemberController().memberCheck(idTxt.getText());

				if (idck) {

					JOptionPane.showMessageDialog(null, "사용하셔도 좋습니다.");
				} else {
					JOptionPane.showMessageDialog(null, "사용중인 아이디입니다.");

				}

			}
		});
		idckBtn.setBounds(322, 58, 103, 25);
		add(idckBtn);

		// 취소버튼 이벤트
		JButton cancelBtn = new JButton("취소");
		cancelBtn.setBackground(Color.WHITE);
		cancelBtn.setBounds(60, 422, 130, 30);
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// 취소버튼 이벤트
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new LoginPanel(frame));
				frame.getContentPane().revalidate();
				frame.getContentPane().repaint();
			}
		});
		cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		add(cancelBtn);

		JButton rgBtn = new JButton("등록");// 등록버튼
		rgBtn.setBackground(Color.RED);
		rgBtn.setBounds(271, 422, 130, 30);
		rgBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		add(rgBtn);

		// 등록 버튼 이벤트
		rgBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (idTxt.getText().equals("") || !idck) {
					JOptionPane.showMessageDialog(null, "ID 다시 입력하세요");

				} else if (passwordTxt.getText().equals("") || !passwordTxt.getText().equals(pwcTxt.getText())) {
					JOptionPane.showMessageDialog(null, "Password 다시 입력하세요");

				} else if (hintText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호 힌트 다시 입력하세요");

				} else if (nameTxt.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "이름 다시 입력하세요..");

				} else if (phoneTxt1.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "전화번호 다시 입력하세요.");
				} else if (addTxt.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "주소 다시 입력하세요.");

				} else if (mailTxt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "메일 다시 입력하세요");
				}

				else if (!female.isSelected() && !male.isSelected()) {
					JOptionPane.showMessageDialog(null, "성별 입력하세요.");
					System.out.println("");
				}

				else {
					String gen = "";
					if (male.isSelected()) {
						gen = "남";
					} else if (female.isSelected()) {
						gen = "여";
					}

					String birth = (String) ((comboyear.getSelectedItem()) + "년" + (combomonth.getSelectedItem()) + "월"
							+ (combodate.getSelectedItem()) + "일");

					String hint = (String) (comboHint.getSelectedItem());
					String answer = (String) (hintText.getText());

					new MemberController().InputMember(idTxt.getText(), passwordTxt.getText(), hint, answer, 
							nameTxt.getText(), birth, mailTxt.getText(), phoneTxt1.getText(), gen, addTxt.getText());
					JOptionPane.showMessageDialog(null, "회원가입을 축하드립니다.");

					frame.getContentPane().removeAll();
					frame.getContentPane().add(new LoginPanel(frame));
					frame.getContentPane().revalidate();
					frame.getContentPane().repaint();
				}

			}

		});
		
		rgBtn.setBorderPainted(false);
		cancelBtn.setBorderPainted(false);
		idckBtn.setBorderPainted(false);

	}
}
