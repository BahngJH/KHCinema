package com.mini.khcinema.model;

import java.io.Serializable;
import java.util.Arrays;

public class MoveReserve implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9181521247200821668L;
	
	private String moviTitle;	//영화제목
	private String date;		//영화 날짜
	private String moviTime;		//영화 시작 시간
	private String[] set;		//좌석
	private int personNum;		//인원
	private String myID;		//구매한 아이디
	
	public MoveReserve() {}
	
	public MoveReserve(String moviTitle, String date, String moviTime, String[] set, int personNum, String myID) {
		this.moviTitle = moviTitle;
		this.date = date;
		this.moviTime = moviTime;
		this.set = set;
		this.personNum = personNum;
		this.myID = myID;
	}



	public String getMoviTitle() {
		return moviTitle;
	}

	public void setMoviTitle(String moviTitle) {
		this.moviTitle = moviTitle;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMoviTime() {
		return moviTime;
	}

	public void setMoviTime(String moviTime) {
		this.moviTime = moviTime;
	}

	public String[] getSet() {
		return set;
	}

	public void setSet(String[] set) {
		this.set = set;
	}

	public int getPersonNum() {
		return personNum;
	}

	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}

	public String getMyID() {
		return myID;
	}

	public void setMyID(String myID) {
		this.myID = myID;
	}

	@Override
	public String toString() {
			
		return "MoveReserve [moviTitle=" + moviTitle + ", date=" + date + ", moviTime=" + moviTime + ", set=" + Arrays.toString(set)
				+ ", personNum=" + personNum + ", myID=" + myID + "]";
	}

	
	
	
}
