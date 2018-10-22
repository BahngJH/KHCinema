package com.mini.khcinema.view.mymenu;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.mini.khcinema.controller.MemberController;
import com.mini.khcinema.controller.OrderController;
import com.mini.khcinema.controller.PaymentController;
import com.mini.khcinema.model.FoodList;
import com.mini.khcinema.model.MovieReserve;

public class FoodListCheck extends JPanel {

	FoodListCheck foodlistcheck = this;
	int cnt = 0;
	int maxcnt;

	public FoodListCheck(JPanel startPanel, JFrame mainF) {

		ArrayList<ArrayList<FoodList>> al = new OrderController().getOrderFoods();

		setBackground(new Color(255, 242, 230));
		setSize(900, 600);

		setLayout(null);

		FoodList mv = new FoodList();
		ArrayList<ArrayList<FoodList>> tmp = new OrderController().getOrderFoods();
		ArrayList<ArrayList<FoodList>> foodreservationInfo = new ArrayList<>();

		if (tmp != null) {
			for (int i = 0; i < tmp.size(); i++) {
				if (MemberController.loginID.equals(tmp.get(i).get(0).getMyID())) {
					foodreservationInfo.add(tmp.get(i));
				}
			}
		}
		if (foodreservationInfo.size() == 0) {
			JOptionPane.showMessageDialog(null, "주문 정보가 없습니다.");
			startPanel.removeAll();
			startPanel.add(new One(startPanel, mainF));
			startPanel.revalidate();
			startPanel.repaint();
		}

		maxcnt = foodreservationInfo.size();
		// System.out.println(al.get(0));
		/*
		 * System.out.println(al.get(1)); System.out.println(al.get(2));
		 */

		// 팝콘 이름
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 175, 151, 262);
		add(scrollPane);
		String imgPathPayment1 = "Images/popcorn.png";
		ImageIcon originIconpayment1 = new ImageIcon(imgPathPayment1);
		Image originImgPayment1 = originIconpayment1.getImage();
		Image changedImgPayment1 = originImgPayment1.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(changedImgPayment1);
		JLabel img = new JLabel(Icon);
		img.setSize(113, 81);
		img.setLocation(120, 84);
		add(img);
		JTextArea textArea_5 = new JTextArea();
		scrollPane.setViewportView(textArea_5);
		textArea_5.setWrapStyleWord(true);
		textArea_5.setLineWrap(true);
		setVisible(true);
		// 사이드
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(427, 175, 151, 262);
		add(scrollPane_2);
		String imgPathPayment3 = "Images/hotdog.png";
		ImageIcon originIconpayment3 = new ImageIcon(imgPathPayment3);
		Image originImgPayment3 = originIconpayment3.getImage();
		Image changedImgPayment3 = originImgPayment3.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon Icon3 = new ImageIcon(changedImgPayment3);
		JLabel img3 = new JLabel(Icon3);
		img3.setSize(113, 81);
		img3.setLocation(441, 84);
		add(img3);
		JTextArea textArea_10 = new JTextArea();
		scrollPane_2.setViewportView(textArea_10);
		textArea_10.setLineWrap(true);
		setVisible(true);

		// 드링크
		String imgPathPayment2 = "Images/coke.png";
		ImageIcon originIconpayment2 = new ImageIcon(imgPathPayment2);
		Image originImgPayment2 = originIconpayment2.getImage();
		Image changedImgPayment2 = originImgPayment2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon Icon2 = new ImageIcon(changedImgPayment2);
		JLabel img2 = new JLabel(Icon2);
		img2.setSize(113, 81);
		img2.setLocation(280, 84);
		add(img2);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(264, 175, 151, 262);
		add(scrollPane_1);

		JTextArea textArea_3 = new JTextArea();
		scrollPane_1.setViewportView(textArea_3);
		textArea_3.setLineWrap(true);
		setVisible(true);
		// 합계

		JTextArea textArea = new JTextArea("합계");

		textArea.setBounds(590, 176, 162, 260);
		add(textArea);

		for (int i = 0; i < foodreservationInfo.get(0).size(); i++) {
			FoodList f = foodreservationInfo.get(0).get(i);

			if (!f.getPopcorn().equals("선택 안함")) {
				textArea_5.append("이름 : " + f.getPopcorn() + "\n가격 : " + f.getPcprice() + "원\n수량 : " + f.getPcnum()
						+ "개\n" + "-----------------------------------\n");
			}
			if (!f.getDrink().equals("선택 안함")) {

				textArea_3.append("이름 : " + f.getDrink() + "\n가격 : " + f.getDrprice() + "원\n수량 : " + f.getDrnum()
						+ "개\n" + "-----------------------------------\n");

			}
			if (!f.getSidemenu().equals("선택 안함")) {
				textArea_10.append("이름 : " + f.getSidemenu() + "\n가격 : " + f.getSideprice() + "원\n수량 : "
						+ f.getSidenum() + "개\n" + "-----------------------------------\n");
			}

			textArea.setText("-----합계-----\n" + f.getSum());
		}

		// 이전 예매 내역을 보기위한 이벤트!
		JButton beforeBtn = new JButton("이전 주문내역");
		beforeBtn.setBounds(506, 490, 117, 37);
		add(beforeBtn);
		beforeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (cnt > 0) {
					cnt--;
					textArea.setText("");
					textArea_10.setText("");
					textArea_3.setText("");
					textArea_5.setText("");

					for (int i = 0; i < foodreservationInfo.get(cnt).size(); i++) {

						FoodList f = foodreservationInfo.get(cnt).get(i);
						System.out.println(cnt);
						System.out.println(maxcnt);
						if (!f.getPopcorn().equals("선택 안함")) {
							textArea_5.append("이름 : " + f.getPopcorn() + "\n가격 : " + f.getPcprice() + "원\n수량 : "
									+ f.getPcnum() + "개\n" + "-----------------------------------\n");
						}
						if (!f.getDrink().equals("선택 안함")) {

							textArea_3.append("이름 : " + f.getDrink() + "\n가격 : " + f.getDrprice() + "원\n수량 : "
									+ f.getDrnum() + "개\n" + "-----------------------------------\n");

						}
						if (!f.getSidemenu().equals("선택 안함")) {
							textArea_10.append("이름 : " + f.getSidemenu() + "\n가격 : " + f.getSideprice() + "원\n수량 : "
									+ f.getSidenum() + "개\n" + "-----------------------------------\n");
						}

						textArea.setText("합계\n" + f.getSum());

						foodlistcheck.repaint();
					}
				} else {
					JOptionPane.showMessageDialog(null, "처음입니다.");

				}
			}
		});

		// 다음 메뉴

		JButton nextBtn = new JButton("다음 주문내역");
		nextBtn.setBounds(635, 490, 117, 37);
		add(nextBtn);
		nextBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				// textArea_5

				if (cnt < maxcnt - 1) {
					cnt++;

					System.out.println(cnt);
					System.out.println(maxcnt);

					textArea.setText("");
					textArea_10.setText("");
					textArea_3.setText("");
					textArea_5.setText("");

					for (int i = 0; i < foodreservationInfo.get(cnt).size(); i++) {

						FoodList f = foodreservationInfo.get(cnt).get(i);

						if (!f.getPopcorn().equals("선택 안함")) {
							textArea_5.append("이름 : " + f.getPopcorn() + "\n가격 : " + f.getPcprice() + "원\n수량 : "
									+ f.getPcnum() + "개\n" + "-----------------------------------\n");
						}
						if (!f.getDrink().equals("선택 안함")) {

							textArea_3.append("이름 : " + f.getDrink() + "\n가격 : " + f.getDrprice() + "원\n수량 : "
									+ f.getDrnum() + "개\n" + "-----------------------------------\n");

						}
						if (!f.getSidemenu().equals("선택 안함")) {
							textArea_10.append("이름 : " + f.getSidemenu() + "\n가격 : " + f.getSideprice() + "원\n수량 : "
									+ f.getSidenum() + "개\n" + "-----------------------------------\n");
						}

						textArea.setText("합계\n" + f.getSum());

						foodlistcheck.repaint();
					}
				} else {
					JOptionPane.showMessageDialog(null, "마지막입니다.");

				}
				super.mouseClicked(e);

			}
		});

		// 주문 취소 내역 이벤트!
		JButton DeleteBtn = new JButton("주문 취소");
		DeleteBtn.setBounds(365, 490, 129, 37);
		add(DeleteBtn);

		DeleteBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				al.remove(cnt);
				cnt--;
				maxcnt--;
				JOptionPane.showMessageDialog(null, "주문이 취소되었습니다.");
				// 예매가 취소 돼서 text 파일안에 내용 지워짐.
				new OrderController().saveFoods(al);
				startPanel.removeAll();
				startPanel.add(new One(startPanel, mainF));
				startPanel.revalidate();
				startPanel.repaint();
			}
		});

	}

}
