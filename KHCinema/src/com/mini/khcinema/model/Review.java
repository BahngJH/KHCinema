package com.mini.khcinema.model;

import java.io.Serializable;

public class Review implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7561617747694178740L;
	private String comment;
	private int score;
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
