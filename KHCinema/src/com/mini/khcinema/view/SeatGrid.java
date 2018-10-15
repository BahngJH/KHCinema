package com.mini.khcinema.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.mini.khcinema.controller.PaymentController;
import com.mini.khcinema.model.MoveReserve;

public class SeatGrid extends JPanel {

	boolean seatflag[][] = new boolean[7][8];
	int select = 0;

	public SeatGrid(String title, String date, String movitime, int count) {
		setSize(20, 20);

		// Flow의 좌우, 위아래 간격을 조정하는 함수 제일 처음은 정렬을 나타냄
		setLayout(new FlowLayout(0, 40, 40));
		// char형 65는 문자 A를 나타냄
		char alpa = 65;
		JButton[][] seat = new JButton[7][8];

		// 2중 포문으로 문자로 열과 숫자로 자리를 지정하는 로직
		for (int i = 0; i < 7; i++) {
			int r = i;
			// char형을 문자형으로 변환해 원하는 문자 출력
			String alpaseat = String.valueOf(alpa);
			for (int j = 0; j < 8; j++) {
				int c = j;
				seat[i][j] = new JButton(alpaseat + (j + 1) + "");
				add(seat[i][j]);

				seat[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						if (e.getButton() == 1 && seatflag[r][c] == false /* && select>=count */) {
							if (select >= count) {
								JOptionPane.showMessageDialog(null, "선택 가능한 좌석을 초과했습니다.");
							} else {
								seat[r][c].setBackground(Color.black);
								seatflag[r][c] = true;
								select++;
							}
						} else if (e.getButton() == 1 && seatflag[r][c] == true /* && select>0 */) {
							seat[r][c].setBackground(Color.white);
							seatflag[r][c] = false;
							select--;
						}

					}
				});

			}
			// 알파를 증가시켜 문자를 변화
			alpa++;
		}

		// 예매정보를 불러와서 예약된 좌석은 비활 처리하는 로직
		ArrayList check = new ArrayList();
		check = new PaymentController().getMoveReserve();
		try {
			for (int i = 0; i < check.size(); i++) {
				MoveReserve m = (MoveReserve) check.get(i);

				if (m.getMoviTitle().equals(title) && m.getDate().equals(date) && m.getMoviTime().equals(movitime)) {
					String[] checkseat = m.getSet();
					for (int j = 0; j < checkseat.length; j++) {
						String checkrow = checkseat[j].substring(0, 1);
						String checkcol = checkseat[j].substring(1, 2);
						char temp = checkrow.charAt(0);
						int row = (int) temp;
						int col = Integer.parseInt(checkcol);
						row = row - 65;
						--col;

						seat[row][col].setEnabled(false);
					}
				}
			}
		} catch (NullPointerException e) {

		}

		setVisible(true);
	}
}
