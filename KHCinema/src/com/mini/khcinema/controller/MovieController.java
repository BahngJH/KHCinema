package com.mini.khcinema.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import com.mini.khcinema.model.Movie;

public class MovieController {
	// 영화 정보를 저장할 파일 이름
	String filename = "movie.txt";

	// 영화 정보를 가져와서 ArrayList에 저장한 후 반환하는 메소드
	public ArrayList<Movie> getMovies() {
		ArrayList<Movie> Movies = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {

			Movies = (ArrayList) ois.readObject();

		} catch (IOException e) {
			e.getStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return Movies;
	}

	public void saveMovies(ArrayList<Movie> Movies) {
		File movieFile = new File(filename);

		// 파일 없을 경우 만들기
		if (!movieFile.exists()) {
			try {
				movieFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(Movies);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void inputMovieTest() {
		ArrayList<Movie> Movies = new ArrayList<>();

		Movie testMovie = new Movie();
		testMovie.setTitle("베놈");
		String[] actors = { "톰 하디", "미셀 월리엄스", "리즈 아메드", "제니 슬레이트", "레이드 스콧", "스콧 헤이즈", "우디 해럴슨", "미쉘 리", "샘 메디나",
				"소페 알루코", "웨인 페레", "멜로라 월터스" };
		testMovie.setActors(actors);
		testMovie.setDirector("루벤 플레셔");
		testMovie.setPremier("2018.10.03");
		testMovie.setRunTime("107분");
		testMovie.setSummary("영웅인가, 악당인가\r\n" + "진실을 위해서라면 몸을 사리지 않는 정의로운 열혈 기자 '에디 브록' \r\n"
				+ " 거대 기업 라이프 파운데이션의 뒤를 쫓던 그는 \r\n" + " 이들의 사무실에 잠입했다가 실험실에서 \r\n"
				+ " 외계 생물체 '심비오트'의 기습 공격을 받게 된다. \r\n" + "  \r\n" + " '심비오트'와 공생하게 된 '에디 브록'은 \r\n"
				+ " 마침내 한층 강력한 '베놈'으로 거듭나고, \r\n" + " 악한 존재만을 상대하려는 '에디 브록'의 의지와 달리 \r\n"
				+ " '베놈'은 난폭한 힘을 주체하지 못하는데…! \r\n" + "  \r\n" + " 지배할 것인가, 지배당할 것인가");
		testMovie.setImagePath("Images/베놈.jpg");

		Movies.add(testMovie);

		testMovie = new Movie();
		testMovie.setTitle("암수살인");
		String actors1[] = { "김윤석", "주지훈", "문정희", "진선규", "허진", "원현준", " 정종준", "김영웅", };
		testMovie.setActors(actors1);
		testMovie.setDirector("김태균");
		testMovie.setPremier("2018.10.03");
		testMovie.setRunTime("110분");
		testMovie.setSummary("피해자는 있지만 신고도, 시체도, 수사도 없어 세상에 알려지지 않은 살인사건, 암수살인.\r\n"
				+ "“일곱, 총 일곱 명 입니다. 제가 죽인 사람들예.” \r\n" + " 수감된 살인범 강태오(주지훈)는 형사 김형민(김윤석)에게 추가 살인을 자백한다. \r\n"
				+ " 형사의 직감으로 자백이 사실임을 확신하게 된 형민은, 태오가 적어준 7개의 살인 리스트를 믿고 수사에 들어간다. \r\n" + "  \r\n"
				+ " “이거 못 믿으면 수사 못한다. 일단 무조건 믿고, 끝까지 의심하자.” \r\n" + " 태오의 추가 살인은 세상에 알려지지 않은 암수사건. \r\n"
				+ " 형민은 태오가 거짓과 진실을 교묘히 뒤섞고 있다는 걸 알게 되지만 수사를 포기하지 않는다. \r\n"
				+ " 그러나 다가오는 공소시효와 부족한 증거로 인해 수사는 난항을 겪게 되는데…");
		testMovie.setImagePath("Images/암수살인.jpg");

		Movies.add(testMovie);

		saveMovies(Movies);

	}
}
