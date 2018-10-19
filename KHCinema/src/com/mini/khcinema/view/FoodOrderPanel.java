package com.mini.khcinema.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.mini.khcinema.controller.MouseEventController;
import com.mini.khcinema.model.FoodList;

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

	public FoodOrderPanel(JPanel startPanel) {

		JPanel panel = new JPanel();
		add(panel);
		setSize(900, 600);

		setLayout(new BorderLayout(0, 0));

		JPanel pane = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
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
		img.setLocation(90, 174);
		panel.add(img);
		// 콜라 아이콘 크기조정
		String imgPath2 = "Images/coke.png";
		ImageIcon originIcon2 = new ImageIcon(imgPath2);
		Image originImg2 = originIcon2.getImage();
		Image changedImg2 = originImg2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon Icon2 = new ImageIcon(changedImg2);
		JLabel img2 = new JLabel(Icon2);
		img2.setSize(45, 45);
		img2.setLocation(265, 174);
		panel.add(img2);

		// 팝콘글씨
		JLabel la1 = new JLabel();
		la1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		la1.setText("팝콘");
		la1.setBounds(136, 179, 100, 40);
		panel.add(la1);
		// 사이드메뉴글씨
		JLabel la2 = new JLabel();
		la2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		la2.setText("사이드메뉴");
		la2.setBounds(467, 179, 100, 40);
		panel.add(la2);
		// 콜라메뉴글씨
		JLabel la3 = new JLabel();
		la3.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		la3.setText("음료");
		la3.setBounds(304, 179, 100, 40);
		panel.add(la3);

		// 사이드메뉴 아이콘 크기조정
		String imgPath3 = "Images/hotdog.png";
		ImageIcon originIcon3 = new ImageIcon(imgPath3);
		Image originImg3 = originIcon3.getImage();
		Image changedImg3 = originImg3.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon Icon3 = new ImageIcon(changedImg3);
		JLabel img3 = new JLabel(Icon3);
		img3.setSize(45, 45);
		img3.setLocation(428, 174);
		panel.add(img3);

		// 팝콘
		String[] popcorn = { "선택 안함", "고소한 맛", "카라멜 맛", "치즈 맛", "어니언 맛", "고소 & 카라멜" };
		JComboBox combopopcorn = new JComboBox(popcorn);
		combopopcorn.setBounds(80, 222, 110, 30);

		panel.add(combopopcorn);

		combopopcorn.getSelectedItem();
		combopopcorn.setVisible(true);

		// 팝콘가격만 나오는 창
		pcprice = new JTextField("0");
		pcprice.setEditable(false);
		pcprice.setBounds(80, 382, 110, 40);
		panel.add(pcprice);
		pcprice.setVisible(true);

		// 팝콘수량 나오는 창
		pcnum = new JTextField("0");
		pcnum.setEditable(false);
		pcnum.setBounds(80, 472, 110, 30);
		panel.add(pcnum);
		pcnum.setVisible(true);

		// 음료
		String[] drink = { "선택 안함", "콜라", "사이다", "오렌지 에이드", "아이스 아메리카노", "따뜻한 아메리카노", "물" };
		JComboBox combodrink = new JComboBox(drink);
		combodrink.setBounds(250, 222, 110, 30);
		panel.add(combodrink);
		combodrink.getSelectedItem();
		combodrink.setVisible(true);

		// 음료가격만 나오는 창

		drprice = new JTextField("0");
		drprice.setEditable(false);
		drprice.setBounds(250, 382, 110, 40);
		panel.add(drprice);
		drprice.setVisible(true);

		// 음료수량 나오는 창
		drnum = new JTextField("0");
		drnum.setEditable(false);
		drnum.setBounds(250, 472, 110, 30);
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
		combosideMenu.setBounds(420, 222, 110, 30);
		panel.add(combosideMenu);
		combosideMenu.setVisible(true);

		combosideMenu.getSelectedItem();

		// 사이드메뉴 가격만 나오는 창
		sideprice = new JTextField("0");
		sideprice.setEditable(false);
		sideprice.setBounds(420, 382, 110, 40);
		panel.add(sideprice);
		sideprice.setVisible(true);

		// 사이드메뉴 수량 나오는 창
		sidenum = new JTextField("0");
		sidenum.setEditable(false);
		sidenum.setBounds(420, 472, 110, 30);
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

		// 합계 글씨
		JLabel totalLabel = new JLabel("합계");
		totalLabel.setFont(totalLabel.getFont().deriveFont(15f));
		totalLabel.setBounds(653, 191, 67, 28);
		panel.add(totalLabel);
		totalLabel.setVisible(true);

		// 합계값입력되는 칸
		totalField = new JTextField();
		totalField.setEditable(false);
		totalField.setBounds(610, 222, 117, 52);
		panel.add(totalField);
		totalField.setVisible(true);

//		int total=Integer.parseInt(pcnum.getText() + 1);	
//		System.out.println(total);
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
		sideminusBtn.setBounds(397, 472, 24, 30);
		panel.add(sideminusBtn);
		sideminusBtn.setVisible(true);

		sideminusBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (Integer.parseInt(sidenum.getText()) > 0) {
					sidenum.setText(String.valueOf(Integer.parseInt(sidenum.getText()) - 1));
					calSum();
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
		sideplusBtn.setBounds(530, 472, 24, 30);
		panel.add(sideplusBtn);
		sideplusBtn.setVisible(true);

		sideplusBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				sidenum.setText(String.valueOf(Integer.parseInt(sidenum.getText()) + 1));
				calSum();

			}
		}

		);

		// 음료수량화살표 버튼
		ImageIcon triIcon3 = new ImageIcon("Images/triangle1.png");
		Image triImg3 = triIcon3.getImage();
		Image changedTriImg3 = triImg3.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		triIcon3 = new ImageIcon(changedTriImg3);
		JButton drinkminusBtn = new JButton(triIcon3);
		drinkminusBtn.setBackground(UIManager.getColor("Button.light"));
		drinkminusBtn.setBounds(227, 472, 24, 30);
		panel.add(drinkminusBtn);
		drinkminusBtn.setVisible(true);
		drinkminusBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (Integer.parseInt(drnum.getText()) > 0) {
					drnum.setText(String.valueOf(Integer.parseInt(drnum.getText()) - 1));
					calSum();
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
		drinkplusBtn.setBounds(360, 472, 24, 30);
		panel.add(drinkplusBtn);
		drinkplusBtn.setVisible(true);
		drinkplusBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				drnum.setText(String.valueOf(Integer.parseInt(drnum.getText()) + 1));
				calSum();
			}
		});

		// 팝콘수량화살표 버튼
		ImageIcon triIcon5 = new ImageIcon("Images/triangle1.png");
		Image triImg5 = triIcon5.getImage();
		Image changedTriImg5 = triImg5.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		triIcon5 = new ImageIcon(changedTriImg5);
		JButton pcminusBtn = new JButton(triIcon5);
		pcminusBtn.setBackground(UIManager.getColor("Button.light"));
		pcminusBtn.setBounds(56, 472, 24, 30);
		panel.add(pcminusBtn);
		pcminusBtn.setVisible(true);
		pcminusBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (Integer.parseInt(pcnum.getText()) > 0) {
					pcnum.setText(String.valueOf(Integer.parseInt(pcnum.getText()) - 1));
					calSum();
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
		pcplusBtn.setBounds(189, 472, 24, 30);
		panel.add(pcplusBtn);

		// 장바구니

		ImageIcon cartIcon = new ImageIcon("Images/shopping-cart.png");
		Image cartImg = cartIcon.getImage();
		Image changedCartImg = cartImg.getScaledInstance(90, 60, Image.SCALE_SMOOTH);
		cartIcon = new ImageIcon(changedCartImg);

		JButton cartBtn = new JButton(cartIcon);
		cartBtn.setBackground(Color.LIGHT_GRAY);
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

				list.setSum(totalField.getText());
				fd.add(list);
				total = Integer.parseInt(totalField.getText());

				combosideMenu.setSelectedIndex(0);
				combopopcorn.setSelectedIndex(0);
				combodrink.setSelectedIndex(0);

			}
		});
		cartBtn.setBounds(610, 321, 117, 61);
		panel.add(cartBtn);
		// 장바구니추가누르면 합계누적

		// 결제누르면 장바구니 내용출력

		// 팝콘수량 화살표 버튼2 이어서
		pcplusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pcnum.setText(String.valueOf(Integer.parseInt(pcnum.getText()) + 1));
				calSum();
			}
		});

		// 결제 버튼
		JButton payBtn = new JButton("결제");
		payBtn.setBounds(610, 441, 117, 61);
		panel.add(payBtn);
		payBtn.setVisible(true);
		payBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (fd.size() > 0) {
					startPanel.removeAll();

					startPanel.add(new FoodPayment(fd, totalField.getText(), startPanel));

					startPanel.revalidate();
					startPanel.repaint();
				} else
					JOptionPane.showMessageDialog(null, "장바구니에 담아주세요");

			}
		});

	}

	public void calSum() {
		int sum = total + new MouseEventController().hap(pcprice.getText(), pcnum.getText(), sideprice.getText(),
				sidenum.getText(), drprice.getText(), drnum.getText());
		totalField.setText(String.valueOf(sum));
	}
}
