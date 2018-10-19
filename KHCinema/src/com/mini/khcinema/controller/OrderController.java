package com.mini.khcinema.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.mini.khcinema.model.FoodList;

public class OrderController {
	

	String filename = "OrderFood.txt";

	
	public ArrayList<ArrayList<FoodList>> getOrderFoods() {
		ArrayList<ArrayList<FoodList>> OrderFoods = null;
		
		try (ObjectInputStream oisfood = new ObjectInputStream(new FileInputStream(filename))) {

			OrderFoods = (ArrayList<ArrayList<FoodList>>) oisfood.readObject();

		} catch (IOException e) {
			e.getStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return OrderFoods;
	}

	public void saveFoods(ArrayList<ArrayList<FoodList>> OrderFoods) {
		File OrderFoodFile = new File(filename);

	
		if (!OrderFoodFile.exists()) {
			try {
				OrderFoodFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(OrderFoods);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}


