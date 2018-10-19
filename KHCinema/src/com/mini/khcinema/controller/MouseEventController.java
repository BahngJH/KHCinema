package com.mini.khcinema.controller;

import java.awt.event.MouseAdapter;


public class MouseEventController extends MouseAdapter{
	
	public int hap(String pcprice,String pcnum,String sideprice,String sidenum,String drprice, String drnum) {
		
		int pcprice1=Integer.parseInt(pcprice);
		int pcnum1=Integer.parseInt(pcnum);
		int sideprice1=Integer.parseInt(sideprice);
		int sidenum1=Integer.parseInt(sidenum);
		int drprice1=Integer.parseInt(drprice);
		int drnum1=Integer.parseInt(drnum);

		int sum=(pcprice1*pcnum1)+(sideprice1*sidenum1)+(drprice1*drnum1);
		
		return sum;
	}
	


}