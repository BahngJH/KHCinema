package com.mini.khcinema.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mini.khcinema.controller.MemberController;
import com.mini.khcinema.model.Member;

public class One extends JPanel {

	public One(JPanel startPanel) {
		setBackground(new Color(255, 255, 255));

		setSize(894, 600);
		setLayout(null);

		ImageIcon icon2 = new ImageIcon("poto/1233.JPG");
		Image ima1 = icon2.getImage();
		icon2 = new ImageIcon(ima1);

		ImageIcon ic = new ImageIcon("poto/321.JPG");
		Image ic1 = ic.getImage();

		Image changedlmg = ic1.getScaledInstance(501, 105, Image.SCALE_SMOOTH);
		ImageIcon icon5 = new ImageIcon(changedlmg);

		ArrayList<Member> members = new MemberController().GetMembers();
		Member member=null;
		for(int i=0;i<members.size();i++) {
			if(members.get(i).getId().equals(MemberController.loginID)) {
				member = members.get(i);
			}
		}
		
		System.out.println(member.getName());
		JLabel lblNewLabel = new JLabel("이름: " + member.getName());
		lblNewLabel.setBounds(260, 57, 137, 29);
		add(lblNewLabel);

		JButton btnNewButton = new JButton("정보변경");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(165, 185, 137, 116);
		add(btnNewButton);

		JLabel label = new JLabel("아이디: " + member.getId());
		label.setBounds(430, 57, 259, 29);
		add(label);

		JButton button = new JButton("예매확인 / 취소");
		button.setBackground(Color.WHITE);
		button.setBounds(344, 185, 137, 116);
		add(button);

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				startPanel.removeAll();
				startPanel.add(new ReservationCheck(startPanel));
				startPanel.revalidate();
				startPanel.repaint();

			}
		});

		JButton button_1 = new JButton("음식 확인 / 취소");
		button_1.setBackground(Color.WHITE);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		button_1.setBounds(523, 185, 137, 116);
		add(button_1);

		JLabel jl = new JLabel(icon5);
		jl.setSize(590, 131);
		jl.setLocation(111, 375);
		add(jl);

		setVisible(true);

	}
}
