package com.mini.khcinema.model;

import java.io.Serializable;
import java.util.Arrays;

public class Movie implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String summary;
	private String director;
	private String[] actors;
	private String runTime;
	private String premier;
	private int cnt = 0;
	private String imagePath;
	
	public Movie() {
		
	}
	
	public Movie(String title, String summary, String director, String[] actors, String runTime, String premier,
			int cnt) {
		super();
		this.title = title;
		this.summary = summary;
		this.director = director;
		this.actors = actors;
		this.runTime = runTime;
		this.premier = premier;
		this.cnt = cnt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String[] getActors() {
		return actors;
	}

	public void setActors(String[] actors) {
		this.actors = actors;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public String getPremier() {
		return premier;
	}

	public void setPremier(String premier) {
		this.premier = premier;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
