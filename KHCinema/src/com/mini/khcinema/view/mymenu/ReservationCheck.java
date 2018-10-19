package com.mini.khcinema.view.mymenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.mini.khcinema.controller.MemberController;
import com.mini.khcinema.controller.PaymentController;
import com.mini.khcinema.model.MovieReserve;

public class ReservationCheck extends JPanel {

	int cnt = 0;
	int maxcnt;

	String s1 = "";
	ReservationCheck reservationcheck = this;

	public ReservationCheck(JPanel startPanel, JFrame mainF) {
		setBackground(new Color(255,242,230));
		setSize(900, 600);

		setLayout(null);

		// 티켓 이미지

		String imgPath = "Images/ticket.png";
		ImageIcon originIcon = new ImageIcon(imgPath);
		Image originImg = originIcon.getImage();
		Image ChangedImg = originImg.getScaledInstance(700, 500, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(ChangedImg);
		JLabel img = new JLabel(Icon);
		img.setBounds(40, 50, 700, 500);
		this.add(img);

		// 텍스트에 저장된 영화 예매 내역 tmp로 받아서
		// 로그인한 아이디의 예매 내역만 reservationinfo 에 넣음

		MovieReserve mv = new MovieReserve();
		ArrayList<MovieReserve> tmp = new PaymentController().getMoveReserve();
		ArrayList<MovieReserve> reservationInfo = new ArrayList<>();
		
		int count = 0;
		for (int i = 0; i < tmp.size(); i++) {
			if (MemberController.loginID.equals(tmp.get(i).getMyID())) {
				reservationInfo.add(tmp.get(i));
				count++;
			}
		}

		System.out.println(reservationInfo);
		
		if(reservationInfo.size()==0) {
			JOptionPane.showMessageDialog(null, "예매 정보가 없습니다.");
			startPanel.removeAll();
			startPanel.add(new One(startPanel, mainF));
			startPanel.revalidate();
			startPanel.repaint();
		}
		
		maxcnt = reservationInfo.size();

		// 예매내역 출력 라벨

		String s1 = reservationInfo.get(0).getMoviTitle();
		JLabel reMovieTitle = new JLabel();
		reMovieTitle.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		reMovieTitle.setBounds(287, 220, 300, 25);
		reMovieTitle.setText("예매 영화명 : " + s1);
		add(reMovieTitle);

		String s2 = reservationInfo.get(0).getDate();

		JLabel reMovieDate = new JLabel();
		reMovieDate.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		reMovieDate.setBounds(287, 247, 300, 25);
		reMovieDate.setText("관람 날짜 :  " + s2);
		add(reMovieDate);

		String s3 = reservationInfo.get(0).getMoviTime();
		JLabel reMovieTime = new JLabel();
		reMovieTime.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		reMovieTime.setBounds(287, 274, 300, 30);
		reMovieTime.setText("관람 시간 " + s3);
		add(reMovieTime);

		JLabel reMovieSeatName = new JLabel();
		reMovieSeatName.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		reMovieSeatName.setBounds(287, 301, 300, 30);
		reMovieSeatName.setText("관람 좌석");
		add(reMovieSeatName);

		String s[] = reservationInfo.get(0).getSet();
		JLabel ReMovieSeat = new JLabel();

		for (int j = 0; j < s.length; j++) {
			ReMovieSeat = new JLabel(s[j] + " ");
			ReMovieSeat.setBounds(350 + (j * 20), 301, 300, 30);
			add(ReMovieSeat);
		}

		int i1 = reservationInfo.get(0).getPersonNum();
		String s4 = Integer.toString(i1);
		JLabel reMoviePerson = new JLabel();
		reMoviePerson.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		reMoviePerson.setBounds(287, 328, 300, 30);
		reMoviePerson.setText("관람 인원 " + s4 + " 명");
		add(reMoviePerson);

		String s5 = reservationInfo.get(0).getMyID();
		JLabel reMovieId = new JLabel();
		reMovieId.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		reMovieId.setBounds(287, 355, 300, 30);
		reMovieId.setText("예매한 아이디 " + s5);
		add(reMovieId);

		JButton NextBtn = new JButton("다음");
		NextBtn.setBounds(623, 440, 97, 23);
		add(NextBtn);

		JButton beforeBtn = new JButton("이전");
		beforeBtn.setBounds(52, 440, 97, 23);
		add(beforeBtn);

		JLabel l = new JLabel();
		l.setBounds(90, 210, 180, 186);

		ImageIcon ic = new ImageIcon("Images/" + ((MovieReserve) reservationInfo.get(0)).getMoviTitle() + ".jpg");
		Image originImg1 = ic.getImage();
		Image changedImg1 = originImg1.getScaledInstance(160, 186, Image.SCALE_SMOOTH);
		ic = new ImageIcon(changedImg1);
		l.setIcon(ic);
		add(l);

		this.repaint();
		// 다음 예매 내역을 보기위해 이벤트 처리!

		NextBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (cnt < maxcnt - 1) {
					cnt++;
					String s1 = ((MovieReserve) reservationInfo.get(cnt)).getMoviTitle();
					reMovieTitle.setText("예매 영화명 : " + s1);
					add(reMovieTitle);
					String s2 = ((MovieReserve) reservationInfo.get(cnt)).getDate();
					reMovieDate.setText("관람 날짜 :  " + s2);
					add(reMovieDate);
					String s3 = ((MovieReserve) reservationInfo.get(cnt)).getMoviTime();
					reMovieTime.setText("관람 시간 " + s3);
					add(reMovieTime);
					int i1 = ((MovieReserve) reservationInfo.get(cnt)).getPersonNum();
					String s4 = Integer.toString(i1);
					reMoviePerson.setText("관람 인원 " + s4 + " 명");
					add(reMoviePerson);

					System.out.println(reservationInfo.get(cnt));
					ImageIcon ic = new ImageIcon(
							"Images/" + ((MovieReserve) reservationInfo.get(cnt)).getMoviTitle() + ".jpg");
					Image originImg = ic.getImage();
					Image changedImg = originImg.getScaledInstance(160, 186, Image.SCALE_SMOOTH);
					ic = new ImageIcon(changedImg);
					l.setIcon(ic);
					add(l);
					reservationcheck.repaint();

				} else
					JOptionPane.showMessageDialog(null, "더 이상 예매 내역이 없습니다.");

			}
		});

		// 이전 예매 내역을 보기위한 이벤트!
		beforeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (cnt == 0) {
					JOptionPane.showMessageDialog(null, "처음입니다.");
				} else {
					cnt--;
					String s1 = ((MovieReserve) reservationInfo.get(cnt)).getMoviTitle();
					reMovieTitle.setText("예매 영화명 : " + s1);
					add(reMovieTitle);
					String s2 = ((MovieReserve) reservationInfo.get(cnt)).getDate();
					reMovieDate.setText("관람 날짜 :  " + s2);
					add(reMovieDate);
					String s3 = ((MovieReserve) reservationInfo.get(cnt)).getMoviTime();
					reMovieTime.setText("관람 시간 " + s3);
					add(reMovieTime);
					int i1 = ((MovieReserve) reservationInfo.get(cnt)).getPersonNum();
					String s4 = Integer.toString(i1);
					reMoviePerson.setText("관람 인원 " + s4 + " 명");
					add(reMoviePerson);

					ImageIcon ic = new ImageIcon(
							"Images/" + ((MovieReserve) reservationInfo.get(cnt)).getMoviTitle() + ".jpg");
					Image originImg = ic.getImage();
					Image changedImg = originImg.getScaledInstance(160, 186, Image.SCALE_SMOOTH);
					ic = new ImageIcon(changedImg);
					l.setIcon(ic);
					add(l);
					reservationcheck.repaint();
				}
				super.mouseClicked(e);
			}
		});

		// 예매 취소 내역 이벤트!
		JButton DeleteBtn = new JButton("예매 취소");
		DeleteBtn.setBounds(668, 534, 97, 23);
		add(DeleteBtn);
		
		JLabel label = new JLabel("예매 정보 확인");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.PLAIN, 28));
		label.setBounds(217, 50, 389, 72);
		add(label);

		DeleteBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				reservationInfo.remove(cnt);
				cnt--;
				maxcnt--;
				JOptionPane.showMessageDialog(null, "예매내역이 취소되었습니다.");
				// 예매가 취소 돼서 text 파일안에 내용 지워짐.
				new PaymentController().saveMoveReserve(reservationInfo);
				startPanel.removeAll();
				startPanel.add(new One(startPanel,mainF));
				startPanel.revalidate();
				startPanel.repaint();
			}
		});

	}
}