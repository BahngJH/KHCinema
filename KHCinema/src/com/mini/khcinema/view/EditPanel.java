package com.mini.khcinema.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mini.khcinema.controller.MemberController;
import com.mini.khcinema.model.Member;

public class EditPanel extends JPanel{

	
	JPanel startPanel;
	
	private JTextField idtxt;
	private JTextField pwField;
	private JTextField phField;
	private JTextField pwFieldtwo;
	private JTextField mailField;
	private JTextField adField;
	int num = 0 ;
	
	public EditPanel(JPanel startPanel, JFrame mainF)
	
	{
		this.startPanel = startPanel;
		
		setLayout(null);
	
		ArrayList<Member> members = new MemberController().GetMembers();
		
		
		for (int i = 0 ; i <members.size() ; i ++)
		{
			if(MemberController.loginID.equals(members.get(i).getId()))
					{
						num=i; break;
					}
					
			
		}
		
		Member m = members.get(num);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(239, 91, 57, 15);
		add(lblNewLabel);
		
		idtxt = new JTextField(m.getId());
		idtxt.setEditable(false);
		idtxt.setBounds(333, 88, 116, 21);
		add(idtxt);
		idtxt.setColumns(10);
		
		JLabel label = new JLabel("비밀번호 수정");
		label.setBounds(239, 124, 89, 15);
		add(label);
		
		pwField = new JPasswordField();
		pwField.setColumns(10);
		pwField.setBounds(333, 119, 116, 21);
		add(pwField);
		
		JLabel label_1 = new JLabel("전화번호");
		label_1.setBounds(239, 184, 57, 15);
		add(label_1);
		
		phField = new JTextField(m.getPhone());
		phField.setColumns(10);
		phField.setBounds(333, 181, 134, 21);
		add(phField);
		
		JLabel label_2 = new JLabel("비밀번호 확인");
		label_2.setBounds(239, 154, 89, 15);
		add(label_2);
		
		pwFieldtwo = new JPasswordField();
		pwFieldtwo.setColumns(10);
		pwFieldtwo.setBounds(333, 149, 116, 21);
		add(pwFieldtwo);
		
		JLabel label_3 = new JLabel("이메일");
		label_3.setBounds(239, 212, 57, 15);
		add(label_3);
		
		mailField = new JTextField(m.getEmail());
		mailField.setBounds(333, 209, 134, 21);
		add(mailField);
		mailField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("주소");
		lblNewLabel_1.setBounds(239, 243, 57, 15);
		add(lblNewLabel_1);
		
		adField = new JTextField(m.getAddress());
		adField.setBounds(333, 240, 255, 21);
		add(adField);
		adField.setColumns(10);
		
		JButton btnNewButton = new JButton("수정");
		btnNewButton.setBounds(252, 286, 82, 50);
		add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				if(pwField.getText().equals("") || !pwField.getText().equals(pwFieldtwo.getText()))
						{
						JOptionPane.showMessageDialog(null , "Password 다시 입력하세요 ");
						}
				else if (adField.getText().equals(""))
						{
						JOptionPane.showMessageDialog(null , "주소를 입력해 주세요.");
						}
				else if (phField.getText().equals(""))
					{
					JOptionPane.showMessageDialog(null , "전화번호 입력해 주세요.");
					}
				else if (mailField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null , "이메일 입력해 주세요.");
				}
				
				else {
					
					m.setPassword(pwField.getText());
					m.setAddress(adField.getText());
					m.setPhone(phField.getText());
					m.setEmail(mailField.getText());
					
					members.remove(num);
					members.add(num, m);
					
					new MemberController().SaveMembers(members);
					
					JOptionPane.showMessageDialog(null , "수정 완료");
					
					startPanel.removeAll();
					startPanel.add(new StartPanel());
					startPanel.revalidate();
					startPanel.repaint();
					
				}
					
			}
		});
		
		JButton button = new JButton("취소");
		button.setBounds(385, 286, 82, 50);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				startPanel.removeAll();
				startPanel.add(new One(startPanel, mainF));
				startPanel.revalidate();
				startPanel.repaint();
			}
		});
		add(button);
		
		JButton button_1 = new JButton("회원탈퇴");
		button_1.setBounds(506, 286, 98, 50);
		
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				members.remove(num);
				
				new MemberController().SaveMembers(members);
				
				JOptionPane.showMessageDialog(null , "탈퇴 완료");
				
				new CinemaMainFrame("KH 시네마");
				mainF.dispose();
			}
		});
		add(button_1);
		
		
		
		
	}
}
