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
	// 예약정보를 가져와서 ArrayList에 저장한 후 반환하는 메소드

	public ArrayList<MoveReserve> getMoveReserve() {

		ArrayList<MoveReserve> MoveReserve = null;

		File moveReserveFile = new File(filename);

		if (!moveReserveFile.exists()) {
			try {
				moveReserveFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			try {
				MoveReserve = (ArrayList) ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return MoveReserve;
	}

	public void saveMoveReserve(ArrayList<MoveReserve> MoveReserve) {
		File moveReserveFile = new File(filename);

		System.out.println("저장");
		if (!moveReserveFile.exists()) {
			try {
				moveReserveFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			try {
				oos.writeObject(MoveReserve);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
