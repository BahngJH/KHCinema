package com.mini.khcinema.model;

import java.io.Serializable;

/*
 * 20181016 ����
 * �ֹ��� ���� Ŭ���� �����
 * ArrayList �̿��Ͽ� �ֹ��� ���� �����ϱ�
 * 
 * ---������---
 * �� �� Ŭ������ �ϳ��� �ֹ�(���� �̸�, ����, ����)
 * ArrayList�� ���Ͽ� �����ϰ� �ҷ����� (��Ʈ�ѷ� �ϳ� �����)
 * �� ī�� ����
 */



public class FoodList implements Serializable { 
	/**
	 * 
	 */
	private static final long serialVersionUID = -3811818671475205357L;
	//���� �̸�, ����, ����
	private String popcorn;
	private String drink;
	private String sidemenu;
	private String pcprice;
	private String drprice;
	private String sideprice;
	private String pcnum;
	private String drnum;
	private String sidenum;
	private String sum;
	private String myID;

	public FoodList() {}

	public FoodList(String popcorn, String drink, String sidemenu, String pcprice, String drprice, String sideprice,String pcnum, String drnum, String sidenum,String sum,String myID) {
		super();
		this.popcorn = popcorn;
		this.drink = drink;
		this.sidemenu = sidemenu;
		this.pcprice = pcprice;
		this.sideprice = sideprice;
		
		this.drprice = drprice;
		this.drnum=drnum;
		this.sidenum=sidenum;
		this.sum=sum;
		this.myID=myID;

	}

	public String getPopcorn() {
		return popcorn;
	}

	public void setPopcorn(String popcorn) {
		this.popcorn = popcorn;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getSidemenu() {
		return sidemenu;
	}

	public void setSidemenu(String sidemenu) {
		this.sidemenu = sidemenu;
	}

	public String getSideprice() {
		return sideprice;
	}

	public void setSideprice(String sideprice) {
		this.sideprice = sideprice;
	}

	public String getPcprice() {
		return pcprice;
	}

	public void setPcprice(String pcprice) {
		this.pcprice = pcprice;
	}

	public String getDrprice() {
		return drprice;
	}

	public void setDrprice(String drprice) {
		this.drprice = drprice;
		
	}


	public String getPcnum() {
		return pcnum;
	}

	public void setPcnum(String pcnum) {
		this.pcnum = pcnum;
	}

	public String getDrnum() {
		return drnum;
	}

	public void setDrnum(String drnum) {
		this.drnum = drnum;
	}

	public String getSidenum() {
		return sidenum;
	}

	public void setSidenum(String sidenum) {
		this.sidenum = sidenum;
	}
	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}
	
	public String getMyID() {
		return myID;
	}

	public void setMyID(String myID) {
		this.myID = myID;
	}

	@Override
	public String toString() {
		return "FoodList [popcorn=" + popcorn + ", drink=" + drink + ", sidemenu=" + sidemenu + ", pcprice=" + pcprice
				+ ", drprice=" + drprice + ", sideprice=" + sideprice + ", pcnum=" + pcnum + ", drnum=" + drnum
				+ ", sidenum=" + sidenum + ", sum=" + sum + "]"+ ", myID=" + myID + "]";
	}

	
	
	
	
}

	