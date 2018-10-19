package com.mini.khcinema.view.reservation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.mini.khcinema.controller.PaymentController;
import com.mini.khcinema.model.MovieReserve;

public class SeatGridPanel extends JPanel {

	boolean seatflag[][] = new boolean[5][8];
	int Reserveseat[][] = new int[5][8];

	int select = 0; // 좌석이 선택될 때 마다 증가시킴

	public SeatGridPanel(String title, String date, String movitime, int count) {
		setSize(783, 372);

		// Flow의 좌우, 위아래 간격을 조정하는 함수 제일 처음은 정렬을 나타냄
		setLayout(new FlowLayout(0, 40, 50));
		// char형 65는 문자 A를 나타냄
		char alpa = 65;
		JButton[][] seat = new JButton[5][8];

		// 2중 포문으로 문자로 열과 숫자로 자리를 지정하는 로직
		for (int i = 0; i < 5; i++) {
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

						if (e.getButton() == 1 && Reserveseat[r][c] == 1)
							JOptionPane.showMessageDialog(null, "이미 예약된 좌석입니다.");
						else {

							// 마우스 클릭이벤트를 받으면서 flag 값이 좌석 비었음 일 때
							if (e.getButton() == 1 && seatflag[r][c] == false) {
								// 전달 받은 인원수가 선택된 좌석보다 많을 경우 이벤트 처리
								if (select >= count) {
									JOptionPane.showMessageDialog(null, "선택 가능한 좌석을 초과했습니다.");
								} else {
									// 해당좌석의 배경을 검게 만들어 체크된 표시를 해준다.
									seat[r][c].setBackground(Color.black);
									seatflag[r][c] = true;
									select++;
								}

							} else if (e.getButton() == 1 && seatflag[r][c] == true) {
								seat[r][c].setBackground(Color.white);
								seatflag[r][c] = false;
								select--;
							}
						}
					}
				});

			}
			// 알파를 증가시켜 문자를 변화
			alpa++;
		}

		// 예매정보를 불러와서 예약된 좌석은 비활 처리하는 로직
		ArrayList check = new ArrayList();
		// getMoveReserve()를 호출하여 reserve.txt 파일을 불러와 현재 예매상태를 불러오고 그걸 check에 넣는다.
		check = new PaymentController().getMoveReserve();
		try {
			for (int i = 0; i < check.size(); i++) {
				// for문을 통해 check에 있는 객체를 뽑아낸다.
				MovieReserve m = (MovieReserve) check.get(i);
				// reserve.txt에 있는 영화 제목과 날짜,시간이 같은 경우의 set데이터를 배열로 받는다.
				if (m.getMoviTitle().equals(title) && m.getDate().equals(date) && m.getMoviTime().equals(movitime)) {
					String[] checkseat = m.getSet();
					for (int j = 0; j < checkseat.length; j++) {
						// 받은 배열 데이터는 A5,D3 이런식으로 저장되었기 때문에 substring으로 행과 열로 나눠준다.
						String checkrow = checkseat[j].substring(0, 1);
						String checkcol = checkseat[j].substring(1, 2);

						// 받은 행과 열을 원래의 데이터로 복원하는 작업
						char temp = checkrow.charAt(0);
						int row = (int) temp;
						int col = Integer.parseInt(checkcol);
						row = row - 65;
						--col;
						// 복원된 데이터를 넣어서 비활성화 해준다.
						seat[row][col].setEnabled(false);
						//seat[row][col].setText("X");
						Reserveseat[row][col] = 1;
					}
				}
			}
		} catch (NullPointerException e) {

		}

		setVisible(true);
	}
}
