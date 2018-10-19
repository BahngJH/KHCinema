package com.mini.khcinema.view.food;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.mini.khcinema.controller.OrderController;
import com.mini.khcinema.model.FoodList;
import com.mini.khcinema.view.StartPanel;

public class FoodPayment extends JPanel {

	static int countt = 0;
	private FoodPayment fp;

	public FoodPayment(ArrayList<FoodList> fd, String total, JPanel startPanel) {
		// JPanel foo, String selectedText, String selectedText2, String selectedText3
		// 결제 버튼

		JPanel panel = new JPanel();
		add(panel);
		setSize(900, 600);

		setLayout(new BorderLayout(0, 0));

		JPanel pane = new JPanel();
		panel.setBackground(new Color(255,242,230));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		// 팝콘아이콘
		String imgPathPayment1 = "Images/popcorn.png";
		ImageIcon originIconpayment1 = new ImageIcon(imgPathPayment1);
		Image originImgPayment1 = originIconpayment1.getImage();
		Image changedImgPayment1 = originImgPayment1.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(changedImgPayment1);
		JLabel img = new JLabel(Icon);
		img.setSize(113, 81);
		img.setLocation(120, 84);
		panel.add(img);

		// 드링크아이콘

		String imgPathPayment2 = "Images/coke.png";
		ImageIcon originIconpayment2 = new ImageIcon(imgPathPayment2);
		Image originImgPayment2 = originIconpayment2.getImage();
		Image changedImgPayment2 = originImgPayment2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon Icon2 = new ImageIcon(changedImgPayment2);
		JLabel img2 = new JLabel(Icon2);
		img2.setSize(113, 81);
		img2.setLocation(280, 84);
		panel.add(img2);

		// 사이드메뉴아이콘
		String imgPathPayment3 = "Images/hotdog.png";
		ImageIcon originIconpayment3 = new ImageIcon(imgPathPayment3);
		Image originImgPayment3 = originIconpayment3.getImage();
		Image changedImgPayment3 = originImgPayment3.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon Icon3 = new ImageIcon(changedImgPayment3);
		JLabel img3 = new JLabel(Icon3);
		img3.setSize(113, 81);
		img3.setLocation(441, 84);
		panel.add(img3);
		panel.setVisible(true);

		// 합계
		JTextArea textArea = new JTextArea(total);
		textArea.setBounds(590, 176, 162, 260);
		panel.add(textArea);

		// 팝콘 이름
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 175, 151, 262);
		panel.add(scrollPane);

		JTextArea textArea_5 = new JTextArea();
		scrollPane.setViewportView(textArea_5);
		textArea_5.setWrapStyleWord(true);
		textArea_5.setLineWrap(true);
		textArea_5.setEditable(false);

		// 사이드
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(427, 175, 151, 262);
		panel.add(scrollPane_2);

		JTextArea textArea_10 = new JTextArea();
		scrollPane_2.setViewportView(textArea_10);
		textArea_10.setLineWrap(true);
		textArea_10.setEditable(false);
		// 드링크
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(264, 175, 151, 262);
		panel.add(scrollPane_1);

		JTextArea textArea_3 = new JTextArea();
		scrollPane_1.setViewportView(textArea_3);
		textArea_3.setLineWrap(true);
		textArea_3.setEditable(false);
		
		
		// 파일출력하기 위한 확인 버튼
		JButton OkBtn = new JButton("\uD655\uC778");
		OkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		OkBtn.setBounds(655, 520, 97, 41);
		panel.add(OkBtn);

		// 뒤로가기 버튼
		JButton BackBtn = new JButton("\uB4A4\uB85C \uAC00\uAE30");
		BackBtn.setBounds(77, 520, 97, 41);
		panel.add(BackBtn);

		for (int i = 0; i < fd.size(); i++) {
			FoodList f = fd.get(i);
			textArea_5.append("이름 : " + f.getPopcorn() + "\n가격 : " + f.getPcprice() + "원\n수량 : " + f.getPcnum() + "개\n"
					+ "-----------------------------------\n");
		}
		for (int i = 0; i < fd.size(); i++) {
			FoodList f = fd.get(i);
			textArea_3.append("이름 : " + f.getDrink() + "\n가격 : " + f.getDrprice() + "원\n수량 : " + f.getDrnum() + "개\n"
					+ "-----------------------------------\n");
		}

		for (int i = 0; i < fd.size(); i++) {
			FoodList f = fd.get(i);
			textArea_10.append("이름 : " + f.getSidemenu() + "\n가격 : " + f.getSideprice() + "원\n수량 : " + f.getSidenum()
					+ "개\n" + "-----------------------------------\n");
		}

		// 확인누르면 파일 출력하게
		OkBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				ArrayList foodlist = new ArrayList();

				// System.out.println(foodinfo);

				// 기존에 가지고 있는 예약 데이터를 list에 뽑아온다.

				try {
					File OrderFoodFile = new File("OrderFood.txt");
					// 내용이 없으면 건너띄도록 하는 조건문
					if (OrderFoodFile.length() != 0) {
						// 파일이 없으면 생성하도록 하는 조건문
						if (OrderFoodFile.exists()) {
							foodlist = new OrderController().getOrderFoods();
						}
					}
				} catch (NullPointerException er) {

				}
				// 뽑아온 데이터 뒤에 현재의 데이터를 추가하고 저장한다.
				foodlist.add(fd);
				new OrderController().saveFoods(foodlist);

				JOptionPane.showMessageDialog(null, "주문 완료되었습니다.");

				startPanel.removeAll();
				startPanel.add(new StartPanel());
				startPanel.revalidate();
				startPanel.repaint();

			}
		});

		BackBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				startPanel.removeAll();
				startPanel.add(new FoodOrderPanel(startPanel));
				startPanel.revalidate();
				startPanel.repaint();
			}
		});

	}
}
