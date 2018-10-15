package com.mini.khcinema.view;

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

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.mini.khcinema.controller.MovieController;
import com.mini.khcinema.model.Movie;

import java.awt.GridLayout;
import java.awt.Image;

public class ChoicePanel extends JPanel {
	int num;
	int date;
	int adultCount;
	int teenCount;
	
	ChoicePanel choicePanel = this;
	public ChoicePanel(JPanel startPanel)
	{
				setSize(900,600);
				
				setLayout(null);
				
				//이미지 아이콘 구성중
				
				/*String imgPath = "image/popcorn.png";
				ImageIcon originIcon = new ImageIcon(imgPath);
				Image originTmg = originIcon.getImage();
				Image ChangedImg = originImg.get*/
				
				
						
				JLabel la1 = new JLabel();
				la1.setFont(new Font("굴림", Font.PLAIN, 13));
				la1.setText("영화 선택");
				la1.setBounds(50,50,100,40);
				
				JLabel la2 = new JLabel();
				la2.setFont(new Font("굴림", Font.PLAIN, 13));
				la2.setText("날짜 선택");
				la2.setBounds(330,50,100,40);
				
				JLabel la3 = new JLabel();
				la3.setFont(new Font("굴림", Font.PLAIN, 13));
				la3.setText("시간 선택");
				la3.setBounds(600,50,100,40);
				
				JLabel la4 = new JLabel();
				la4.setFont(new Font("굴림", Font.PLAIN, 13));
				la4.setText("인원/좌석  수  선택");
				la4.setBounds(70,400,300,20);
				
				 MovieController mc = new MovieController();
				 ArrayList movies = mc.getMovies();
				 
				//영화 종류 선택 
			   
				 String movieName[] = new String[movies.size()]; 
			    
			    for(int i=0;i<movieName.length;i++) {
			    	Movie m = (Movie) movies.get(i);
			    	String s = m.getTitle();
			    	movieName[i] = s;
			    }
			    
			    JList movieList = new JList(movieName);
			    JScrollPane scrollPane = new JScrollPane(movieList);
			    scrollPane.setBounds(50,120,150,250);
			    movieList.setVisibleRowCount(3); 
			    
			    movieList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			    
			   
			    
			    //영화 날짜 선택
			    
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
			    JScrollPane dateScroll = new JScrollPane(dateList);
			    dateScroll.setBounds(330,120,150,250);
			    dateList.setEnabled(false);
			
			 	
			    // 영화 선택에 대한 이벤트
			    
			 	movieList.addMouseListener(new MouseAdapter() {
			    	
			    	@Override
			    	public void mouseClicked(MouseEvent e) {
			    		// TODO Auto-generated method stub
			    		 num = movieList.getSelectedIndex();
			    		 dateList.setEnabled(true);
			    		super.mouseClicked(e);
			    	}
			    	
			    
			    });
			    
			    //영화 , 날짜를 선택하여 시간이 보여지는 이벤트처리!
			    
			    JList<String> timeList = new JList();
	             JScrollPane timeScroll = new JScrollPane(timeList);
	             timeScroll.setBounds(600,120,150,250);
	             
	        
	             
	             	dateList.addMouseListener(new MouseAdapter() {
	                   
	                public void mouseClicked(MouseEvent e) {
	                      
	            
	                	
	                     String movieTime[] = new String[30];
	                     
	                  date = dateList.getSelectedIndex();
	                    
	                   if(num == 0) {
	                	   switch(date) {
	                	   case 0: case 2 : case 4 : case 6 :
	                		   movieTime[0] = "09:00";
	                		   movieTime[1] = "12:00";
	                		   movieTime[2] = "15:00";
	                		   movieTime[3] = "18:00";
	                		   movieTime[4] = "21:00";
	                		   movieTime[5] = "24:00";
	                		   movieTime[6] = "03:30";
	                		   break;
	                	   case 1: case 3: case 5: case 7:
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
	                   else if(num == 1) {
	                	   switch(date) {
	                	   case 0: case 2 : case 4 : case 6 :
	                		   movieTime[0] = "09:00";
	                		   movieTime[1] = "12:00";
	                		   movieTime[2] = "15:00";
	                		   movieTime[3] = "18:00";
	                		   movieTime[4] = "21:00";
	                		   movieTime[5] = "24:00";
	                		   movieTime[6] = "03:30";
	                		   break;
	                	   case 1: case 3: case 5: case 7:
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
	                   else if(num == 2) {
	                	   switch(date) {
	                	   case 0: case 2 : case 4 : case 6 :
	                		   movieTime[0] = "09:00";
	                		   movieTime[1] = "12:00";
	                		   movieTime[2] = "15:00";
	                		   movieTime[3] = "18:00";
	                		   movieTime[4] = "21:00";
	                		   movieTime[5] = "24:00";
	                		   movieTime[6] = "03:30";
	                		   break;
	                	   case 1: case 3: case 5: case 7:
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
	                   else if(num ==3) {
	                	   switch(date) {
	                	   case 0: case 2 : case 4 : case 6 :
	                		   movieTime[0] = "09:00";
	                		   movieTime[1] = "12:00";
	                		   movieTime[2] = "15:00";
	                		   movieTime[3] = "18:00";
	                		   movieTime[4] = "21:00";
	                		   movieTime[5] = "24:00";
	                		   movieTime[6] = "03:30";
	                		   break;
	                	   case 1: case 3: case 5: case 7:
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
	                   else if(num ==4) {
	                	   switch(date) {
	                	   case 0: case 2 : case 4 : case 6 :
	                		   movieTime[0] = "09:00";
	                		   movieTime[1] = "12:00";
	                		   movieTime[2] = "15:00";
	                		   movieTime[3] = "18:00";
	                		   movieTime[4] = "21:00";
	                		   movieTime[5] = "24:00";
	                		   movieTime[6] = "03:30";
	                		   break;
	                	   case 1: case 3: case 5: case 7:
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
	                   else if(num ==5) {
	                	   switch(date) {
	                	   case 0: case 2 : case 4 : case 6 :
	                		   movieTime[0] = "09:00";
	                		   movieTime[1] = "12:00";
	                		   movieTime[2] = "15:00";
	                		   movieTime[3] = "18:00";
	                		   movieTime[4] = "21:00";
	                		   movieTime[5] = "24:00";
	                		   movieTime[6] = "03:30";
	                		   break;
	                	   case 1: case 3: case 5: case 7:
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
	                     for(String s : movieTime) {
	                        listModel.addElement(s);
	                     }
	                     timeList.setModel(listModel);
	                     //choicePanel.repaint(); 없어도 동작 되긴함.
	                     
	                   };       
	                
	             });
	             	             	         	             	    
			    this.add(la1);
				this.add(la2);
				this.add(la3);
				this.add(scrollPane);
				this.add(dateScroll);
				this.add(timeScroll);
				this.add(la4);
		
				JLabel la5 = new JLabel();
				la5.setText("성인");
				la5.setBounds(80,430,50,40);
				add(la5);
				
				JLabel la6 = new JLabel();
				la6.setText("청소년");
				la6.setBounds(70,480,50,40);
				add(la6);
				
				
				// 좌석 버튼 생성
				
				JButton nextBtn = new JButton("좌석 선택");
				nextBtn.setFont(new Font("굴림", Font.PLAIN, 13));
				nextBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				nextBtn.setBounds(550,480,170,40);
				nextBtn.setVisible(true);
				add(nextBtn);
				setVisible(true);
				nextBtn.setEnabled(false);
				
				
				// 청소년 버튼 구현 및 이벤트처리!
				JButton teenCho = new JButton();		
				for(int i=0; i<6; i++)
				{
					int a =60;
					int num=i;
					 teenCho = new JButton((i)+"명");
					
					teenCho.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							teenCount = num;
							System.out.println(teenCount);
						}
					});
					
					teenCho.setBounds(120+(a*i),430,55,40);
					teenCho.setVisible(true);
					add(teenCho);
				
					
				}
				
				// 성인 버튼 구현 및 이벤트 처리!
				JButton adultCho = new JButton();
				for(int i=0; i<6; i++)
				{
					int a = 60;
					int num=i;
						 adultCho = new JButton((i)+"명");
					
					adultCho.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							adultCount = num;
							System.out.println(adultCount);
		
							
						}
					});
					
					adultCho.setBounds(120+(a*i),480,55,40);
					adultCho.setVisible(true);
					add(adultCho);
				
				}
				
			
				
				timeList.addMouseListener(new MouseAdapter() {
             		
             		@Override
             		public void mouseClicked(MouseEvent e) {
             			// TODO Auto-generated method stub
             			super.mouseClicked(e);
             		}
				});
				
				

				// 좌석 선택 버튼 이벤트 !
				
				nextBtn.addMouseListener(new MouseAdapter() {
					
					@Override
		               public void mouseClicked(MouseEvent e) {
		                  // TODO Auto-generated method stub
		                                                   
		                  if(movieList.getSelectedValue() != null && dateList.getSelectedValue() != null && timeList. getSelectedValue() != null && (teenCount != 0 || adultCount != 0) )
		                  {
		                     System.out.println( movieList.getSelectedValue() + "" + dateList.getSelectedValue() + " "+  timeList. getSelectedValue() + " " + teenCount + " " + adultCount);
		                     startPanel.removeAll();
		                     
		                     startPanel.add(new Reservation(startPanel,(String)movieList.getSelectedValue(), (String)dateList.getSelectedValue(), (String)timeList.getSelectedValue(), teenCount, adultCount ));
		                     
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
