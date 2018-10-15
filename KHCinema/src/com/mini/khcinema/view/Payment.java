package com.mini.khcinema.view;

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
import com.mini.khcinema.model.MoveReserve;

public class Payment extends JPanel {

	static int count = 0;
	private Payment pm;

	public Payment(String movititle, String date, String movitime, String[] seat, /*int seatNum,*/ int personNum,
			String myID, JPanel mf) {
		setLayout(null);

		this.pm = this;
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		add(panel);
		panel.setLayout(null);
		JLabel info = new JLabel("Reservation info");
		info.setBounds(199, 415, 463, 43);

		ArrayList seatList = new ArrayList();
		for (int i = 0; i < personNum; i++) {
			seatList.add(seat[i]);
		}
		info.setText(movititle + " " + date + " 상영시간" + movitime + "분 " + "구매자:" + myID + " " + personNum + "명 좌석 "
				+ seatList + "");

		add(info);

		JLabel lblTitle = new JLabel("예매 정보 확인!");
		lblTitle.setFont(new Font("굴림", Font.PLAIN, 40));
		lblTitle.setBounds(253, 29, 293, 86);
		add(lblTitle);

		JButton paybtn = new JButton("확인");
		paybtn.setBounds(681, 504, 75, 27);
		add(paybtn);

		JButton cancelbtn = new JButton("취소");
		cancelbtn.setBounds(592, 504, 75, 27);
		add(cancelbtn);
		
		ImageIcon ic = new ImageIcon("Images/"+movititle+".jpg");
		Image originImg = ic.getImage();
		Image changedImg = originImg.getScaledInstance(270, 300, Image.SCALE_SMOOTH);
		ic = new ImageIcon(changedImg);
		JLabel lblNewLabel = new JLabel(ic);
		lblNewLabel.setBounds(263, 102, 268, 306);
		add(lblNewLabel);

		paybtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MoveReserve info = new MoveReserve(movititle, date, movitime, seat, personNum, myID);
				ArrayList list = new ArrayList();
				mf.remove(pm);
				// mf.add(new Reservation(mf));
				mf.revalidate();
				mf.repaint();
				System.out.println(info);

				// 기존에 가지고 있는 예약 데이터를 list에 뽑아온다.
				
				try {
					File moveReserveFile = new File("reserve.txt");
					//내용이 없으면 건너띄도록 하는 조건문
					if(moveReserveFile.length()!=0) {
					//파일이 없으면 생성하도록 하는 조건문
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
				// TODO Auto-generated method stub
				mf.remove(pm);
				// mf.add(new Reservation(mf));
				mf.revalidate();
				mf.repaint();
			}
		});
	}
}
