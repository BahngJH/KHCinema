package com.mini.khcinema.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.mini.khcinema.model.Review;

public class ReviewController {
	public void inputComment(String comment, String filename, String score) {
		ArrayList<Review> comments = getComment(filename);
		
		Review review = new Review();
		review.setComment(comment);
		review.setScore(Integer.parseInt(score));
		
		if (!comment.equals("")) {
			comments.add(review);

			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
				oos.writeObject(comments);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Review> getComment(String filename) {
		ArrayList<Review> comments = new ArrayList<>();
		
		File file = new File(filename);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			comments = (ArrayList<Review>) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return comments;
	}
}
