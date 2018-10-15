package com.mini.khcinema.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Reservation extends JPanel {
	// String seat[] = new String[10];
	int w = 0;
	private Reservation rj;
	private JPanel mf; // 메인 프레임을 해야하는데 잘못 만들어서 이걸로 대체함 자료형은 좀 틀리고 변수명만 맞춤

	public Reservation(JPanel mf, String title, String date, String movitime, int teenCount, int adultCount) {

		int count = teenCount + adultCount;
		int price = (teenCount*6000)+(adultCount*10000); 

		setLayout(new BorderLayout());
		this.mf = mf;
		this.rj = this;

		String seat[] = new String[count];

		JButton screen = new JButton("스크린");
		JButton payment = new JButton("결제하기");
		JPanel south = new JPanel();
		JLabel exit = new JLabel("출구");
		screen.setBackground(Color.white);
		screen.setToolTipText("아무기능이 없는 버튼입니다.");

		exit.setFont(new Font("고딕", Font.ITALIC, 30));

		// 좌석의 패널을 불러오는 것
		SeatGrid seatgrid = new SeatGrid(title, date, movitime, count);
		add(seatgrid, BorderLayout.CENTER);

		add(screen, BorderLayout.NORTH);
		south.setLayout(new BorderLayout());
		south.add(exit, BorderLayout.WEST);
		south.add(payment, BorderLayout.EAST);
		add(south, BorderLayout.SOUTH);

		payment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (seatgrid.select != count) {
					JOptionPane.showMessageDialog(null, "좌석을 선택하신 만큼 선택해주세요!");
				} else {
					// TODO Auto-generated method stub
					for (int i = 0; i < 7; i++) {
						for (int j = 0; j < 8; j++) {
							if (seatgrid.seatflag[i][j] == true) {
								seat[w] = ((char) (65 + i)) + "" + (j + 1);
								w++;
							}
						}
					}
					// 확인 테스트 코드
					for (int i = 0; i < w; i++)
						System.out.println(seat[i]);
					mf.remove(rj);
					mf.add(new Payment(title, date, movitime, seat, count, "wpxm2003", mf,price));
					mf.revalidate();
					mf.repaint();
				}
			}
		});

		setVisible(true);

	}

}
