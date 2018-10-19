package com.mini.khcinema.view.food;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.mini.khcinema.controller.MemberController;
import com.mini.khcinema.controller.MouseEventController;
import com.mini.khcinema.controller.OrderController;
import com.mini.khcinema.model.FoodList;
import com.mini.khcinema.view.StartPanel;

public class FoodOrderPanel extends JPanel {
	private JTextField pcprice;
	private JTextField pcnum;
	private JTextField sideprice;
	private JTextField sidenum;
	private JTextField drprice;
	private JTextField drnum;
	private JTextField totalField;
	int count = 0;
	int total = 0;
	int pcindex;
	String pcprice1 = "";
	String sideprice1 = "";
	String drprice1 = "";
	ArrayList<FoodList> fd = new ArrayList<FoodList>();
	private JTextArea popField;
	private JTextArea drField;
	private JTextArea sideField;

	public FoodOrderPanel(JPanel startPanel) {

		JPanel panel = new JPanel();
		add(panel);
		setSize(900, 600);

		setLayout(new BorderLayout(0, 0));

		JPanel pane = new JPanel();
		panel.setBackground(new Color(255, 242, 230));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		// kh시네마 매장
		JLabel kh = new JLabel("KH 시네마 매점");
		kh.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		kh.setFont(kh.getFont().deriveFont(28.0f));
		kh.setForeground(Color.GRAY);
		kh.setBounds(280, 10, 247, 79);
		panel.add(kh);
		kh.setVisible(true);

		// 팝콘 아이콘 크기조정
		String imgPath = "Images/popcorn.png";
		ImageIcon originIcon = new ImageIcon(imgPath);
		Image originImg = originIcon.getImage();
		Image changedImg = originImg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(changedImg);
		JLabel img = new JLabel(Icon);
		img.setSize(45, 45);
		img.setLocation(33, 169);
		panel.add(img);
		// 콜라 아이콘 크기조정
		String imgPath2 = "Images/coke.png";
		ImageIcon originIcon2 = new ImageIcon(imgPath2);
		Image originImg2 = originIcon2.getImage();
		Image changedImg2 = originImg2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon Icon2 = new ImageIcon(changedImg2);
		JLabel img2 = new JLabel(Icon2);
		img2.setSize(45, 45);
		img2.setLocation(201, 169);
		panel.add(img2);

		// 팝콘글씨
		JLabel la1 = new JLabel();
		la1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		la1.setText("팝콘");
		la1.setBounds(80, 174, 100, 40);
		panel.add(la1);
		// 사이드메뉴글씨
		JLabel la2 = new JLabel();
		la2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		la2.setText("사이드메뉴");
		la2.setBounds(411, 174, 100, 40);
		panel.add(la2);
		// 콜라메뉴글씨
		JLabel la3 = new JLabel();
		la3.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		la3.setText("음료");
		la3.setBounds(248, 174, 100, 40);
		panel.add(la3);

		// 사이드메뉴 아이콘 크기조정
		String imgPath3 = "Images/hotdog.png";
		ImageIcon originIcon3 = new ImageIcon(imgPath3);
		Image originImg3 = originIcon3.getImage();
		Image changedImg3 = originImg3.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon Icon3 = new ImageIcon(changedImg3);
		JLabel img3 = new JLabel(Icon3);
		img3.setSize(45, 45);
		img3.setLocation(365, 169);
		panel.add(img3);

		// 팝콘
		String[] popcorn = { "선택 안함", "고소한 맛", "카라멜 맛", "치즈 맛", "어니언 맛", "고소 & 카라멜" };
		JComboBox combopopcorn = new JComboBox(popcorn);
		combopopcorn.setBounds(33, 222, 110, 30);

		panel.add(combopopcorn);

		combopopcorn.getSelectedItem();
		combopopcorn.setVisible(true);

		// 팝콘가격만 나오는 창
		pcprice = new JTextField("0");
		pcprice.setEditable(false);
		pcprice.setBounds(33, 262, 110, 40);
		panel.add(pcprice);
		pcprice.setVisible(true);

		// 팝콘수량 나오는 창
		pcnum = new JTextField("0");
		pcnum.setEditable(false);
		pcnum.setBounds(37, 312, 110, 30);
		panel.add(pcnum);
		pcnum.setVisible(true);

		// 음료
		String[] drink = { "선택 안함", "콜라", "사이다", "오렌지 에이드", "아이스 아메리카노", "따뜻한 아메리카노", "물" };
		JComboBox combodrink = new JComboBox(drink);
		combodrink.setBounds(201, 222, 110, 30);
		panel.add(combodrink);
		combodrink.getSelectedItem();
		combodrink.setVisible(true);

		// 음료가격만 나오는 창

		drprice = new JTextField("0");
		drprice.setEditable(false);
		drprice.setBounds(203, 262, 110, 40);
		panel.add(drprice);
		drprice.setVisible(true);

		// 음료수량 나오는 창
		drnum = new JTextField("0");
		drnum.setEditable(false);
		drnum.setBounds(207, 312, 110, 30);
		panel.add(drnum);
		drnum.setVisible(true);
		// 음료 콤보박스인덱스
		combodrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int drindex = cb.getSelectedIndex();

				switch (drindex) {
				case 0:
					drprice.setText("0");
					break;
				case 1:
					drprice.setText("2500");
					break;
				case 2:
					drprice.setText("2000");
					break;
				case 3:
					drprice.setText("4100");
					break;
				case 4:
					drprice.setText("3500");
					break;
				case 5:
					drprice.setText("3000");
					break;
				case 6:
					drprice.setText("1000");
					break;

				}
				drnum.setText("0");
				drprice1 = drprice.getText();
				calSum();
			}
		});

		// 사이드메뉴
		String[] sidemenu = { "선택 안함", "버터구이 오징어", "나초", "핫도그", "츄러스" };
		JComboBox combosideMenu = new JComboBox(sidemenu);
		combosideMenu.setBounds(370, 222, 110, 30);
		panel.add(combosideMenu);
		combosideMenu.setVisible(true);

		combosideMenu.getSelectedItem();

		// 사이드메뉴 가격만 나오는 창
		sideprice = new JTextField("0");
		sideprice.setEditable(false);
		sideprice.setBounds(373, 262, 110, 40);
		panel.add(sideprice);
		sideprice.setVisible(true);

		// 사이드메뉴 수량 나오는 창
		sidenum = new JTextField("0");
		sidenum.setEditable(false);
		sidenum.setBounds(377, 312, 110, 30);
		panel.add(sidenum);
		sidenum.setVisible(true);

		// 사이드메뉴 콤보박스인덱스

		combosideMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int sideindex = cb.getSelectedIndex();

				switch (sideindex) {
				case 0:
					sideprice.setText("0");
					break;
				case 1:
					sideprice.setText("4000");
					break;
				case 2:
					sideprice.setText("3000");
					break;
				case 3:
					sideprice.setText("3500");
					break;
				case 4:
					sideprice.setText("2800");
					break;

				}
				sidenum.setText("0");
				sideprice1 = sideprice.getText();
				calSum();
			}
		});

//      int total=Integer.parseInt(pcnum.getText() + 1);   
//      System.out.println(total);
//   

		// 팝콘 콤보박스인덱스
		combopopcorn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				pcindex = cb.getSelectedIndex();

				switch (pcindex) {
				case 0:
					pcprice.setText("0");
					break;
				case 1:
					pcprice.setText("5000");
					break;
				case 2:
					pcprice.setText("5500");
					break;
				case 3:
					pcprice.setText("6000");
					break;
				case 4:
					pcprice.setText("6000");
					break;
				case 5:
					pcprice.setText("7000");
					break;

				}

				pcprice1 = pcprice.getText();
				pcnum.setText("0");
				calSum();
			}
		});

		// 사이드량화살표 버튼
		ImageIcon triIcon = new ImageIcon("Images/triangle1.png");
		Image triImg = triIcon.getImage();
		Image changedTriImg = triImg.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		triIcon = new ImageIcon(changedTriImg);
		JButton sideminusBtn = new JButton(triIcon);
		sideminusBtn.setBackground(UIManager.getColor("Button.light"));
		sideminusBtn.setBounds(354, 312, 24, 30);
		panel.add(sideminusBtn);
		sideminusBtn.setVisible(true);

		sideminusBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (((String) combosideMenu.getSelectedItem()).equals("선택 안함")) {
					JOptionPane.showMessageDialog(null, "음식을 선택해주세요.");
				} else {
					if (Integer.parseInt(sidenum.getText()) > 0) {
						sidenum.setText(String.valueOf(Integer.parseInt(sidenum.getText()) - 1));
						calSum();
					} else {
						JOptionPane.showMessageDialog(null, "수량을 선택해주세요.");
					}

				}
			}
		});

		// 사이드수량 화살표 플러스
		ImageIcon triIcon2 = new ImageIcon("Images/triangle.png");
		Image triImg2 = triIcon2.getImage();
		Image changedTriImg2 = triImg2.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		triIcon2 = new ImageIcon(changedTriImg2);
		JButton sideplusBtn = new JButton(triIcon2);
		sideplusBtn.setBackground(UIManager.getColor("Button.light"));
		sideplusBtn.setBounds(487, 312, 24, 30);
		panel.add(sideplusBtn);
		sideplusBtn.setVisible(true);

		sideplusBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (((String) combosideMenu.getSelectedItem()).equals("선택 안함")) {
					JOptionPane.showMessageDialog(null, "음식을 선택해주세요.");
				} else {
					sidenum.setText(String.valueOf(Integer.parseInt(sidenum.getText()) + 1));
					calSum();
				}

			}
		});

		// 음료수량화살표 버튼
		ImageIcon triIcon3 = new ImageIcon("Images/triangle1.png");
		Image triImg3 = triIcon3.getImage();
		Image changedTriImg3 = triImg3.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		triIcon3 = new ImageIcon(changedTriImg3);
		JButton drinkminusBtn = new JButton(triIcon3);
		drinkminusBtn.setBackground(UIManager.getColor("Button.light"));
		drinkminusBtn.setBounds(184, 312, 24, 30);
		panel.add(drinkminusBtn);
		drinkminusBtn.setVisible(true);
		drinkminusBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (((String) combodrink.getSelectedItem()).equals("선택 안함")) {
					JOptionPane.showMessageDialog(null, "음식을 선택해주세요.");
				} else {
					if (Integer.parseInt(drnum.getText()) > 0) {
						drnum.setText(String.valueOf(Integer.parseInt(drnum.getText()) - 1));
						calSum();
					} else {
						JOptionPane.showMessageDialog(null, "수량을 선택해주세요.");
					}

				}
			}
		});
		// 음료수량 화살표 버튼2
		ImageIcon triIcon4 = new ImageIcon("Images/triangle.png");
		Image triImg4 = triIcon2.getImage();
		Image changedTriImg4 = triImg4.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		triIcon4 = new ImageIcon(changedTriImg4);
		JButton drinkplusBtn = new JButton(triIcon4);
		drinkplusBtn.setBackground(UIManager.getColor("Button.light"));
		drinkplusBtn.setBounds(317, 312, 24, 30);
		panel.add(drinkplusBtn);
		drinkplusBtn.setVisible(true);
		drinkplusBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (((String) combodrink.getSelectedItem()).equals("선택 안함")) {
					JOptionPane.showMessageDialog(null, "음식을 선택해주세요.");
				} else {
					drnum.setText(String.valueOf(Integer.parseInt(drnum.getText()) + 1));
					calSum();
				}

			}
		});

		// 팝콘수량화살표 버튼
		ImageIcon triIcon5 = new ImageIcon("Images/triangle1.png");
		Image triImg5 = triIcon5.getImage();
		Image changedTriImg5 = triImg5.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		triIcon5 = new ImageIcon(changedTriImg5);
		JButton pcminusBtn = new JButton(triIcon5);
		pcminusBtn.setBackground(UIManager.getColor("Button.light"));
		pcminusBtn.setBounds(13, 312, 24, 30);
		panel.add(pcminusBtn);
		pcminusBtn.setVisible(true);
		pcminusBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (((String) combopopcorn.getSelectedItem()).equals("선택 안함")) {
					JOptionPane.showMessageDialog(null, "음식을 선택해주세요.");
				} else {
					if (Integer.parseInt(pcnum.getText()) > 0) {
						pcnum.setText(String.valueOf(Integer.parseInt(pcnum.getText()) - 1));
						calSum();
					} else {
						JOptionPane.showMessageDialog(null, "수량을 선택해주세요.");
					}

				}
			}
		});

		// 팝콘수량 화살표 버튼2
		ImageIcon triIcon6 = new ImageIcon("Images/triangle.png");
		Image triImg6 = triIcon6.getImage();
		Image changedTriImg6 = triImg6.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		triIcon6 = new ImageIcon(changedTriImg6);
		JButton pcplusBtn = new JButton(triIcon6);
		pcplusBtn.setBackground(UIManager.getColor("Button.light"));
		pcplusBtn.setBounds(146, 312, 24, 30);
		panel.add(pcplusBtn);
		pcplusBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (((String) combopopcorn.getSelectedItem()).equals("선택 안함")) {
					JOptionPane.showMessageDialog(null, "음식을 선택해주세요.");
				} else {
					pcnum.setText(String.valueOf(Integer.parseInt(pcnum.getText()) + 1));
					calSum();
				}

			}
		});

		popField = new JTextArea();
		popField.setBounds(13, 375, 157, 164);
		panel.add(popField);
		popField.setColumns(10);

		drField = new JTextArea();
		drField.setColumns(10);
		drField.setBounds(184, 375, 157, 164);
		panel.add(drField);

		sideField = new JTextArea();
		sideField.setColumns(10);
		sideField.setBounds(354, 375, 157, 164);
		panel.add(sideField);
		
		// 장바구니

		ImageIcon cartIcon = new ImageIcon("Images/shopping-cart.png");
		Image cartImg = cartIcon.getImage();
		Image changedCartImg = cartImg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		cartIcon = new ImageIcon(changedCartImg);

		JButton cartBtn = new JButton(cartIcon);
		cartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cartBtn.setBackground(new Color(255, 242, 230));
		cartBtn.setBorderPainted(false);

		cartBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				FoodList list = new FoodList();
				list.setPopcorn((String) combopopcorn.getSelectedItem());
				list.setPcprice(pcprice.getText());
				list.setPcnum(pcnum.getText());
				list.setDrink((String) combodrink.getSelectedItem());
				list.setDrprice(drprice.getText());
				list.setDrnum(drnum.getText());
				list.setSidemenu((String) combosideMenu.getSelectedItem());
				list.setSideprice(sideprice.getText());
				list.setSidenum(sidenum.getText());
				list.setSidemenu((String) combosideMenu.getSelectedItem());
				list.setSideprice(sideprice.getText());
				list.setSidenum(sidenum.getText());
				list.setMyID(MemberController.loginID);
				
				popField.append("이름 : " + list.getPopcorn() + "\n가격 : " + list.getPcprice() + "원\n수량 : " + list.getPcnum() + "개\n"
						+ "-----------------------------------\n");
				drField.append("이름 : " + list.getDrink() + "\n가격 : " + list.getDrprice() + "원\n수량 : " + list.getDrnum() + "개\n"
						+ "-----------------------------------\n");
				sideField.append("이름 : " + list.getSidemenu() + "\n가격 : " + list.getSideprice() + "원\n수량 : " + list.getSidenum()
				+ "개\n" + "-----------------------------------\n");
				list.setSum(totalField.getText());
				fd.add(list);
				total = Integer.parseInt(totalField.getText());
				
				combosideMenu.setSelectedIndex(0);
				combopopcorn.setSelectedIndex(0);
				combodrink.setSelectedIndex(0);

			}
		});
		cartBtn.setBounds(554, 472, 85, 45);
		panel.add(cartBtn);
		// 장바구니추가누르면 합계누적

		// 결제누르면 장바구니 내용출력

		// 팝콘수량 화살표 버튼2 이어서

		// 결제 버튼
		JButton payBtn = new JButton("결제");
		payBtn.setBounds(677, 472, 85, 45);
		panel.add(payBtn);

		// 합계값입력되는 칸
		totalField = new JTextField();
		totalField.setBounds(554, 262, 208, 80);
		panel.add(totalField);
		totalField.setEditable(false);

		
		totalField.setVisible(true);
		payBtn.setVisible(true);
		payBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				FoodList list = new FoodList();
				list.setPopcorn((String) combopopcorn.getSelectedItem());
				list.setPcprice(pcprice.getText());
				list.setPcnum(pcnum.getText());
				list.setDrink((String) combodrink.getSelectedItem());
				list.setDrprice(drprice.getText());
				list.setDrnum(drnum.getText());
				list.setSidemenu((String) combosideMenu.getSelectedItem());
				list.setSideprice(sideprice.getText());
				list.setSidenum(sidenum.getText());
				list.setSidemenu((String) combosideMenu.getSelectedItem());
				list.setSideprice(sideprice.getText());
				list.setSidenum(sidenum.getText());
				list.setMyID(MemberController.loginID);
				
				list.setSum(totalField.getText());
				fd.add(list);
				total = Integer.parseInt(totalField.getText());

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

	}

	public void calSum() {
		int sum = total + new MouseEventController().hap(pcprice.getText(), pcnum.getText(), sideprice.getText(),
				sidenum.getText(), drprice.getText(), drnum.getText());
		totalField.setText(String.valueOf(sum));
	}
}