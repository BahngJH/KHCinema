package com.mini.khcinema.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

import com.mini.khcinema.view.StartPanel;

public class NowTimeController extends Thread {
	
	JLabel l;
	//이 과정을 거쳐 줘야 주소값이 넘어가고 바로 하려고 하면 넘어가지 않는다.
	public NowTimeController(JLabel l) {
		this.l = l;
	}
	
	@Override
	public void run() {
		while(true) 
		{
			SimpleDateFormat timeform = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Date time = new Date();
			
			String NowTime = timeform.format(time);
			
			try {
				Thread.sleep(1000);
				l.setText(NowTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
