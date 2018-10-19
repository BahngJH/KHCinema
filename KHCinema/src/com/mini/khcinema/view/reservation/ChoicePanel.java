package com.mini.khcinema.view.reservation;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import com.mini.khcinema.controller.MovieController;
import com.mini.khcinema.model.Movie;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;

public class ChoicePanel extends JPanel {
	int num;
	int date;
	int adultCount;
	int teenCount;

	ChoicePanel choicePanel = this;

	public ChoicePanel(JPanel startPanel) {
		setBackground(new Color(255,242,230));
		setSize(900, 600);

		setLayout(null);

		// 이미지 아이콘 구성

		String imgPath = "Images/movie.png";
		ImageIcon originIcon = new ImageIcon(imgPath);
		Image originImg = originIcon.getImage();
		Image ChangedImg = originImg.getScaledInstance(39, 40, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(ChangedImg);
		JLabel img = new JLabel(Icon);
		img.setBounds(40, 110, 39, 40);
		this.add(img);

		String imgPath2 = "Images/calendar.png";
		ImageIcon originIcon2 = new ImageIcon(imgPath2);
		Image originImg2 = originIcon2.getImage();
		Image ChangedImg2 = originImg2.getScaledInstance(39, 40, Image.SCALE_SMOOTH);
		ImageIcon Icon2 = new ImageIcon(ChangedImg2);
		JLabel img2 = new JLabel(Icon2);
		img2.setBounds(224, 110, 39, 40);
		this.add(img2);

		String imgPath1 = "Images/clock.png";
		ImageIcon originIcon1 = new ImageIcon(imgPath1);
		Image originImg1 = originIcon1.getImage();
		Image ChangedImg1 = originImg1.getScaledInstance(39, 40, Image.SCALE_SMOOTH);
		ImageIcon Icon1 = new ImageIcon(ChangedImg1);
		JLabel img1 = new JLabel(Icon1);
		img1.setBounds(414, 110, 39, 40);
		this.add(img1);

		String imgPath3 = "Images/family.png";
		ImageIcon originIcon3 = new ImageIcon(imgPath3);
		Image originImg3 = originIcon3.getImage();
		Image ChangedImg3 = originImg3.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon Icon3 = new ImageIcon(ChangedImg3);
		JLabel img3 = new JLabel(Icon3);
		img3.setSize(30, 30);
		img3.setLocation(35, 423);
		img1.setBounds(414, 110, 39, 40);
		this.add(img3);

		JLabel la = new JLabel();
		la.setFont(new Font("궁서체", Font.BOLD, 30));
		la.setText("영화 예매");
		la.setBounds(247, 23, 160, 40);

		JLabel la1 = new JLabel();
		la1.setBackground(new Color(255, 255, 255));
		la1.setForeground(new Color(0, 0, 0));
		la1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		la1.setText("영화 선택");
		la1.setBounds(90, 115, 100, 40);

		JLabel la2 = new JLabel();
		la2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		la2.setText("날짜 선택");
		la2.setBounds(274, 115, 100, 40);

		JLabel la3 = new JLabel();
		la3.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		la3.setText("시간 선택");
		la3.setBounds(464, 115, 100, 40);

		JLabel la4 = new JLabel();
		la4.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		la4.setText("인원/좌석  수  선택");
		la4.setBounds(72, 430, 300, 20);

		MovieController mc = new MovieController();
		ArrayList movies = mc.getMovies();

		// 영화 종류 선택

		String movieName[] = new String[movies.size()];

		for (int i = 0; i < movieName.length; i++) {
			Movie m = (Movie) movies.get(i);
			String s = m.getTitle();
			movieName[i] = s;
		}

		JList movieList = new JList(movieName);
		movieList.setForeground(new Color(0, 0, 0));
		movieList.setBackground(new Color(255, 250, 240));
		JScrollPane scrollPane = new JScrollPane(movieList);
		scrollPane.setBounds(30, 160, 172, 210);
		movieList.setVisibleRowCount(3);

		movieList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// 영화 날짜 선택

		String movieDate[] = new String[30];
		movieDate[0] = "2018-10-19";
		movieDate[1] = "2018-10-20";
		movieDate[2] = "2018-10-21";
		movieDate[3] = "2018-10-22";
		movieDate[4] = "2018-10-23";
		movieDate[5] = "2018-10-24";
		movieDate[6] = "2018-10-25";
		movieDate[7] = "2018-10-26";

		JList dateList = new JList(movieDate);
		dateList.setBackground(new Color(255, 250, 240));
		JScrollPane dateScroll = new JScrollPane(dateList);
		dateScroll.setBounds(200, 160, 190, 210);
		dateList.setEnabled(false);

		JLabel l = new JLabel();
		l.setBounds(590, 101, 160, 186);
		add(l);

		JLabel la7 = new JLabel("1");
		la7.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		la7.setBounds(610, 297, 100, 40);

		imgPath = "Images/ticket.png";
		ImageIcon originIcon4 = new ImageIcon(imgPath);
		Image originImg4 = originIcon4.getImage();
		Image ChangedImg4 = originImg4.getScaledInstance(160, 200, Image.SCALE_SMOOTH);
		ImageIcon Icon4 = new ImageIcon(ChangedImg4);
		JLabel ticketLabel = new JLabel(Icon4);
		ticketLabel.setBounds(589, 245, 160, 200);
		
		// 영화 선택에 대한 이벤트
		
		movieList.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				num = movieList.getSelectedIndex();
				dateList.setEnabled(true);

				ImageIcon ic = new ImageIcon("Images/" + movieList.getSelectedValue() + ".jpg");
				Image originImg = ic.getImage();
				Image changedImg = originImg.getScaledInstance(160, 186, Image.SCALE_SMOOTH);
				ic = new ImageIcon(changedImg);
				l.setIcon(ic);

				// imagePanel.setSize(300, 500);
				// choicePanel.add(l);

				choicePanel.repaint();

				// 영화 제목 텍스트 출력
				String n1 = (String) movieList.getSelectedValue();
				la7.setText(n1);
				add(la7);
				add(ticketLabel);
				super.mouseClicked(e);
			}

		});

		// 영화 , 날짜를 선택하여 시간이 보여지는 이벤트처리!

		JLabel la8 = new JLabel("2");
		la8.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		la8.setBounds(610, 312, 100, 40);

		JList<String> timeList = new JList();
		timeList.setBackground(new Color(255, 250, 240));
		JScrollPane timeScroll = new JScrollPane(timeList);
		timeScroll.setBounds(388, 160, 177, 210);

		dateList.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				String movieTime[] = new String[30];

				date = dateList.getSelectedIndex();

				if (num == 0) {
					switch (date) {
					case 0:
					case 2:
					case 4:
					case 6:
						movieTime[0] = "09:00";
						movieTime[1] = "12:00";
						movieTime[2] = "15:00";
						movieTime[3] = "18:00";
						movieTime[4] = "21:00";
						movieTime[5] = "24:00";
						movieTime[6] = "03:30";
						break;
					case 1:
					case 3:
					case 5:
					case 7:
						movieTime[0] = "09:30";
						movieTime[1] = "12:30";
						movieTime[2] = "15:30";
						movieTime[3] = "18:30";
						movieTime[4] = "21:30";
						movieTime[5] = "24:30";
						movieTime[6] = "03:30";
						break;

					}

				} else if (num == 1) {
					switch (date) {
					case 0:
					case 2:
					case 4:
					case 6:
						movieTime[0] = "09:00";
						movieTime[1] = "12:00";
						movieTime[2] = "15:00";
						movieTime[3] = "18:00";
						movieTime[4] = "21:00";
						movieTime[5] = "24:00";
						movieTime[6] = "03:30";
						break;
					case 1:
					case 3:
					case 5:
					case 7:
						movieTime[0] = "09:30";
						movieTime[1] = "12:30";
						movieTime[2] = "15:30";
						movieTime[3] = "18:30";
						movieTime[4] = "21:30";
						movieTime[5] = "24:30";
						movieTime[6] = "03:30";
						break;

					}
				} else if (num == 2) {
					switch (date) {
					case 0:
					case 2:
					case 4:
					case 6:
						movieTime[0] = "09:00";
						movieTime[1] = "12:00";
						movieTime[2] = "15:00";
						movieTime[3] = "18:00";
						movieTime[4] = "21:00";
						movieTime[5] = "24:00";
						movieTime[6] = "03:30";
						break;
					case 1:
					case 3:
					case 5:
					case 7:
						movieTime[0] = "09:30";
						movieTime[1] = "12:30";
						movieTime[2] = "15:30";
						movieTime[3] = "18:30";
						movieTime[4] = "21:30";
						movieTime[5] = "24:30";
						movieTime[6] = "03:30";
						break;

					}
				} else if (num == 3) {
					switch (date) {
					case 0:
					case 2:
					case 4:
					case 6:
						movieTime[0] = "09:00";
						movieTime[1] = "12:00";
						movieTime[2] = "15:00";
						movieTime[3] = "18:00";
						movieTime[4] = "21:00";
						movieTime[5] = "24:00";
						movieTime[6] = "03:30";
						break;
					case 1:
					case 3:
					case 5:
					case 7:
						movieTime[0] = "09:30";
						movieTime[1] = "12:30";
						movieTime[2] = "15:30";
						movieTime[3] = "18:30";
						movieTime[4] = "21:30";
						movieTime[5] = "24:30";
						movieTime[6] = "03:30";
						break;

					}
				} else if (num == 4) {
					switch (date) {
					case 0:
					case 2:
					case 4:
					case 6:
						movieTime[0] = "09:00";
						movieTime[1] = "12:00";
						movieTime[2] = "15:00";
						movieTime[3] = "18:00";
						movieTime[4] = "21:00";
						movieTime[5] = "24:00";
						movieTime[6] = "03:30";
						break;
					case 1:
					case 3:
					case 5:
					case 7:
						movieTime[0] = "09:30";
						movieTime[1] = "12:30";
						movieTime[2] = "15:30";
						movieTime[3] = "18:30";
						movieTime[4] = "21:30";
						movieTime[5] = "24:30";
						movieTime[6] = "03:30";
						break;

					}
				} else if (num == 5) {
					switch (date) {
					case 0:
					case 2:
					case 4:
					case 6:
						movieTime[0] = "09:00";
						movieTime[1] = "12:00";
						movieTime[2] = "15:00";
						movieTime[3] = "18:00";
						movieTime[4] = "21:00";
						movieTime[5] = "24:00";
						movieTime[6] = "03:30";
						break;
					case 1:
					case 3:
					case 5:
					case 7:
						movieTime[0] = "09:30";
						movieTime[1] = "12:30";
						movieTime[2] = "15:30";
						movieTime[3] = "18:30";
						movieTime[4] = "21:30";
						movieTime[5] = "24:30";
						movieTime[6] = "03:30";
						break;

					}
				}

				DefaultListModel<String> listModel = new DefaultListModel<String>();
				for (String s : movieTime) {
					listModel.addElement(s);
				}
				timeList.setModel(listModel);
				// choicePanel.repaint(); 없어도 동작 되긴함.

				// 영화 시간 텍스트 출력
				String n2 = (String) dateList.getSelectedValue();
				la8.setText(n2);
				System.out.println(n2);
				add(la8);
				repaint();

			};
		});
		
		
		//시간 선택에 대한 이벤트 ! 
		
		JLabel la9 = new JLabel();
		la9.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		la9.setBounds(610, 323, 100, 40);
		
		timeList.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				String n3 = (String)timeList.getSelectedValue();
				la9.setText(n3);
				add(la9);
				repaint();
			}
		});

		this.add(la);
		this.add(la1);
		this.add(la2);
		this.add(la3);
		this.add(scrollPane);
		this.add(dateScroll);
		this.add(timeScroll);
		this.add(la4);

		JLabel la5 = new JLabel();
		la5.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		la5.setText("성인");
		la5.setBounds(80, 460, 50, 40);
		add(la5);

		JLabel la6 = new JLabel();
		la6.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		la6.setText("청소년");
		la6.setBounds(70, 510, 50, 40);
		add(la6);

		// 좌석 버튼 생성

		JButton nextBtn = new JButton("");
		nextBtn.setBackground(new Color(255,242,230));
		nextBtn.setIcon(new ImageIcon("Images/rightarrow1.png"));
		nextBtn.setSelectedIcon(new ImageIcon("Images/rightarrow1.png"));
		nextBtn.setFont(new Font("굴림", Font.PLAIN, 13));
		nextBtn.setBorderPainted(false);
		
		nextBtn.setBounds(602, 485, 148, 52);
		nextBtn.setVisible(true);
		add(nextBtn);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(30, 101, 535, 60);
		add(panel);
		
			
		// 성인 인원 정보 출력!
		
		JLabel la11 = new JLabel();
		la11.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		la11.setBounds(610, 335, 100, 40);
		add(la11);
		la11.setVisible(false);
			
		// 성인 버튼 구현 및 이벤트 처리!
		JToggleButton adultCho = new JToggleButton();
		ButtonGroup bg = new ButtonGroup();
		for (int i = 0; i < 6; i++) {
			int a = 60;
			int num = i;
			adultCho = new JToggleButton((i) + "명");

			adultCho.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					adultCount = num;
					System.out.println(adultCount);
					la11.setText("성인 : " + adultCount + "명");
					la11.setVisible(true);
				}
			});

			adultCho.setBounds(120 + (a * i), 460, 55, 40);
			adultCho.setVisible(true);
			bg.add(adultCho);
			add(adultCho);

		}
		
		// 청소년 인원 정보 출력! 
		
				JLabel la10 = new JLabel();
				la10.setFont(new Font("맑은 고딕", Font.BOLD, 13));
				la10.setBounds(610, 350, 100, 40);
				add(la10);
				
							
				// 청소년 버튼 구현 및 이벤트처리!
				JToggleButton teenCho = new JToggleButton();
				ButtonGroup bg1 = new ButtonGroup();
				
				for (int i = 0; i < 6; i++) {
					int a = 60;
					int num = i;
					teenCho = new JToggleButton((i) + "명");

					teenCho.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							teenCount = num;
							System.out.println(teenCount);
							la10.setText("청소년 : " + teenCount + "명");
							la10.setVisible(true);
						}
					});
					
					teenCho.setBounds(120 + (a * i), 510, 55, 40);
					//teenCho.setVisible(true);
					bg1.add(teenCho);
					add(teenCho);
					
				}
				

		// 좌석 선택 버튼 이벤트 !
		
		nextBtn.addMouseListener(new MouseAdapter() {

			@Override
            public void mouseClicked(MouseEvent e) {                                                
               if(movieList.getSelectedValue() != null && dateList.getSelectedValue() != null && timeList. getSelectedValue() != null && (teenCount != 0 || adultCount != 0) )
               {
                  System.out.println( movieList.getSelectedValue() + "" + dateList.getSelectedValue() + " "+  timeList. getSelectedValue() + " " + teenCount + " " + adultCount);
                  startPanel.removeAll();
                  
                  startPanel.add(new ReservationPanel(startPanel,(String)movieList.getSelectedValue(), (String)dateList.getSelectedValue(), (String)timeList.getSelectedValue(), teenCount, adultCount ));
                  
                  startPanel.revalidate();
                  startPanel.repaint();
               
               }
               else
               {
                  JOptionPane.showMessageDialog(null, "전부 선택해주세요.");
               }
               
               
            }

		});


	}
}
