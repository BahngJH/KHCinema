package com.mini.khcinema.view.reservation;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mini.khcinema.controller.PaymentController;
import com.mini.khcinema.model.MovieReserve;
import com.mini.khcinema.view.StartPanel;

import java.awt.Color;
import java.awt.SystemColor;

public class PaymentPanel extends JPanel {

	static int count = 0;
	private PaymentPanel pm;

	public PaymentPanel(String movititle, String date, String movitime, String[] seat, int personNum, String myID, JPanel mf,
			int price) {
		setBackground(new Color(255,242,230));
		setForeground(new Color(0, 0, 0));
		setLayout(null);

		this.pm = this;
		JLabel info = new JLabel("Reservation info");
		info.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		info.setBounds(371, 261, 268, 17);

		ArrayList seatList = new ArrayList();
		for (int i = 0; i < personNum; i++) {
			seatList.add(seat[i]);
		}
		info.setText(movititle + " " + date + " 상영시간 " + movitime);
		add(info);

		JLabel payinfo = new JLabel("payinfo");
		payinfo.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		payinfo.setText(personNum + "명 좌석 " + seatList + "");
		payinfo.setBounds(371, 313, 253, 15);
		add(payinfo);

		JLabel seatinfo = new JLabel("payinfo");
		seatinfo.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		seatinfo.setText("구매자: " + myID + " 가격: " + price);
		seatinfo.setBounds(371, 288, 253, 15);
		add(seatinfo);

		JLabel lblTitle = new JLabel("예매 정보 확인");
		lblTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 40));
		lblTitle.setBounds(253, 29, 293, 86);
		add(lblTitle);

		JButton paybtn = new JButton("확인");
		paybtn.setBounds(681, 504, 75, 27);
		add(paybtn);

		JButton cancelbtn = new JButton("취소");
		cancelbtn.setBounds(592, 504, 75, 27);
		add(cancelbtn);

		ImageIcon ic = new ImageIcon("Images/" + movititle + ".jpg");
		Image originImg = ic.getImage();
		Image changedImg = originImg.getScaledInstance(270, 300, Image.SCALE_SMOOTH);
		ic = new ImageIcon(changedImg);
		JLabel lblNewLabel = new JLabel(ic);
		lblNewLabel.setBackground(SystemColor.inactiveCaption);
		lblNewLabel.setBounds(36, 138, 268, 306);
		add(lblNewLabel);

		ImageIcon ic2 = new ImageIcon("Images/ticket.png");
		Image originImg2 = ic2.getImage();
		Image chagedImg2 = originImg2.getScaledInstance(380, 230, Image.SCALE_SMOOTH);
		ic2 = new ImageIcon(chagedImg2);
		JLabel model_ticket = new JLabel(ic2);
		model_ticket.setBounds(316, 201, 439, 185);
		add(model_ticket);
		
		JLabel lblNewLabel_1 = new JLabel("즐거운 관람되세요 감사합니다.");
		lblNewLabel_1.setBounds(388, 396, 285, 27);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		add(lblNewLabel_1);

		String test = "커밋 테스트중";
		
		paybtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MovieReserve info = new MovieReserve(movititle, date, movitime, seat, personNum, myID);
				ArrayList list = new ArrayList();
				mf.remove(pm);
				mf.add(new StartPanel());
				mf.revalidate();
				mf.repaint();
				System.out.println(info);

				// 기존에 가지고 있는 예약 데이터를 list에 뽑아온다.
				try {
					File moveReserveFile = new File("reserve.txt");
					// 내용이 없으면 건너띄도록 하는 조건문
					if (moveReserveFile.length() != 0) {
						// 파일이 없으면 생성하도록 하는 조건문
						if (moveReserveFile.exists()) {
							list = new PaymentController().getMoveReserve();
						}
					}
				} catch (NullPointerException er) {

				}
				// 뽑아온 데이터 뒤에 현재의 데이터를 추가하고 저장한다.
				list.add(info);
				new PaymentController().saveMoveReserve(list);

			}
		});

		cancelbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mf.remove(pm);
				mf.add(new StartPanel());
				mf.revalidate();
				mf.repaint();
			}
		});
	}
}
