package com.mini.khcinema.view.mymenu;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.mini.khcinema.controller.OrderController;
import com.mini.khcinema.model.FoodList;

public class FoodListCheck extends JPanel {

	FoodListCheck foodlistcheck = this;
	int cnt = 0;
	int maxcnt;

	public FoodListCheck(JPanel startPanel, JFrame mainF) {

		ArrayList<ArrayList<FoodList>> al = new OrderController().getOrderFoods();
		maxcnt = al.size();
		setBackground(new Color(255,242,230));
		setSize(900, 600);

		setLayout(null);

		System.out.println(al.get(0));
	/*	System.out.println(al.get(1));
		System.out.println(al.get(2));*/

		// 팝콘 이름
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 175, 151, 262);
		add(scrollPane);

		JTextArea textArea_5 = new JTextArea();
		scrollPane.setViewportView(textArea_5);
		textArea_5.setWrapStyleWord(true);
		textArea_5.setLineWrap(true);

		// 사이드
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(427, 175, 151, 262);
		add(scrollPane_2);

		JTextArea textArea_10 = new JTextArea();
		scrollPane_2.setViewportView(textArea_10);
		textArea_10.setLineWrap(true);

		// 드링크
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(264, 175, 151, 262);
		add(scrollPane_1);

		JTextArea textArea_3 = new JTextArea();
		scrollPane_1.setViewportView(textArea_3);
		textArea_3.setLineWrap(true);

		// 합계
		JTextArea textArea = new JTextArea("합계");

		textArea.setBounds(590, 176, 162, 260);
		add(textArea);
		
		
		for (int i = 0; i < al.get(0).size(); i++) {
			FoodList f = al.get(0).get(i);

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

			textArea.setText("합계\n" + f.getSum());
		}
		
		// 이전 예매 내역을 보기위한 이벤트!
		JButton beforeBtn = new JButton("이전 주문내역");
		beforeBtn.setBounds(70, 491, 97, 23);
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
				            
						for (int i = 0; i < al.get(cnt).size(); i++) {

							FoodList f = al.get(cnt).get(i);
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
					}
		        	else{
						JOptionPane.showMessageDialog(null, "처음입니다.");

					}
			}
		});

		// 다음 메뉴

		JButton nextBtn = new JButton("다음 주문내역");
		nextBtn.setBounds(491, 491, 97, 23);
		add(nextBtn);
		nextBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//textArea_5 
				
				if (cnt < maxcnt - 1) {
					cnt++;
					
						textArea.setText("");
			            textArea_10.setText("");
			            textArea_3.setText("");
			            textArea_5.setText("");
			            
					for (int i = 0; i < al.get(cnt).size(); i++) {

						FoodList f = al.get(cnt).get(i);
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
					JOptionPane.showMessageDialog(null, "마지막입니다.");

				}
				super.mouseClicked(e);

			}
		});

		// 주문 취소 내역 이벤트!
		JButton DeleteBtn = new JButton("주문 취소");
		DeleteBtn.setBounds(446, 553, 97, 23);
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
