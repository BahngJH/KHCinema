package com.mini.khcinema.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.mini.khcinema.model.MoveReserve;

public class PaymentController {

	String filename = "reserve.txt";
	//예약정보를 가져와서 ArrayList에 저장한 후 반환하는 메소드

	public ArrayList<MoveReserve> getMoveReserve() {
		//현재 .txt 파일로 저장된 내용(데이터)을 받을 콜렉션 변수를 만든다.
		//MoveReserve 자료형만 담기도록 하는 처리.
		ArrayList<MoveReserve> MoveReserve = null;

		File moveReserveFile = new File(filename);

		if (!moveReserveFile.exists()) {
			try {
				moveReserveFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(moveReserveFile))) {
			try {
				MoveReserve = (ArrayList) ois.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return MoveReserve;
	}

	//데이터를 텍스트 파일로 저장하는 메소드.
	public void saveMoveReserve(ArrayList<MoveReserve> MoveReserve) {
		File moveReserveFile = new File(filename);

		System.out.println("텍스트 파일로 저장");
		if (!moveReserveFile.exists()) {
			try {
				moveReserveFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(moveReserveFile))) {
			try {
				oos.writeObject(MoveReserve);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
