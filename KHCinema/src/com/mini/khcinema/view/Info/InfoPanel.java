package com.mini.khcinema.view.Info;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import com.mini.khcinema.controller.PaymentController;
import com.mini.khcinema.controller.ReviewController;
import com.mini.khcinema.model.Movie;
import com.mini.khcinema.model.MovieReserve;
import com.mini.khcinema.model.Review;
import javax.swing.border.LineBorder;

public class InfoPanel extends JPanel {
	public InfoPanel(Movie movie) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));

		//영화 포스터 패널
		JPanel imagePanel = new JPanel();
		imagePanel.setBackground(new Color(255,242,230));
		add(imagePanel, BorderLayout.WEST);

		//라벨에 영화 포스터 아이콘 넣기
		ImageIcon ic = new ImageIcon(movie.getImagePath());
		Image originImg = ic.getImage();
		Image changedImg = originImg.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
		ic = new ImageIcon(changedImg);
		imagePanel.setLayout(new BorderLayout(0, 0));
		JLabel l = new JLabel(ic);
		l.setSize(300, 500);
		imagePanel.add(l);

		//영화 정보 패널
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(new Color(255,242,230));
		add(infoPanel, BorderLayout.CENTER);
		GridBagLayout gbl_infoPanel = new GridBagLayout();
		gbl_infoPanel.columnWidths = new int[] { 115, 115, 115, 115, 0 };
		gbl_infoPanel.rowHeights = new int[] { 73, 73, 73, 73, 0 };
		gbl_infoPanel.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_infoPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		infoPanel.setLayout(gbl_infoPanel);

		//영화 이름
		JLabel title = new JLabel("제목");
		title.setBackground(new Color(255, 250, 205));
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.fill = GridBagConstraints.VERTICAL;
		gbc_title.insets = new Insets(0, 0, 5, 5);
		gbc_title.gridx = 0;
		gbc_title.gridy = 0;
		infoPanel.add(title, gbc_title);

		JLabel titleLabel = new JLabel(movie.getTitle());
		titleLabel.setBackground(new Color(0, 139, 139));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.fill = GridBagConstraints.VERTICAL;
		gbc_titleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_titleLabel.gridx = 1;
		gbc_titleLabel.gridy = 0;
		infoPanel.add(titleLabel, gbc_titleLabel);

		//개봉일
		JLabel premier = new JLabel("개봉일");
		GridBagConstraints gbc_premier = new GridBagConstraints();
		gbc_premier.insets = new Insets(0, 0, 5, 5);
		gbc_premier.gridx = 2;
		gbc_premier.gridy = 0;
		infoPanel.add(premier, gbc_premier);

		JLabel premierLabel = new JLabel(movie.getPremier());
		GridBagConstraints gbc_premierLabel = new GridBagConstraints();
		gbc_premierLabel.fill = GridBagConstraints.VERTICAL;
		gbc_premierLabel.insets = new Insets(0, 0, 5, 0);
		gbc_premierLabel.gridx = 3;
		gbc_premierLabel.gridy = 0;
		infoPanel.add(premierLabel, gbc_premierLabel);

		//상영시간
		JLabel runTime = new JLabel("상영 시간");
		GridBagConstraints gbc_runTime = new GridBagConstraints();
		gbc_runTime.fill = GridBagConstraints.VERTICAL;
		gbc_runTime.insets = new Insets(0, 0, 5, 5);
		gbc_runTime.gridx = 0;
		gbc_runTime.gridy = 1;
		infoPanel.add(runTime, gbc_runTime);

		JLabel runTimeLabel = new JLabel(movie.getRunTime());
		GridBagConstraints gbc_runTimeLabel = new GridBagConstraints();
		gbc_runTimeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_runTimeLabel.gridx = 1;
		gbc_runTimeLabel.gridy = 1;
		infoPanel.add(runTimeLabel, gbc_runTimeLabel);

		//감독
		JLabel director = new JLabel("감독");
		GridBagConstraints gbc_director = new GridBagConstraints();
		gbc_director.insets = new Insets(0, 0, 5, 5);
		gbc_director.gridx = 2;
		gbc_director.gridy = 1;
		infoPanel.add(director, gbc_director);

		JLabel directorLabel = new JLabel(movie.getDirector());
		GridBagConstraints gbc_directorLabel = new GridBagConstraints();
		gbc_directorLabel.fill = GridBagConstraints.VERTICAL;
		gbc_directorLabel.insets = new Insets(0, 0, 5, 0);
		gbc_directorLabel.gridx = 3;
		gbc_directorLabel.gridy = 1;
		infoPanel.add(directorLabel, gbc_directorLabel);

		//출연진
		JLabel actors = new JLabel("출연진");
		GridBagConstraints gbc_actors = new GridBagConstraints();
		gbc_actors.insets = new Insets(0, 0, 5, 5);
		gbc_actors.gridx = 0;
		gbc_actors.gridy = 2;
		infoPanel.add(actors, gbc_actors);

		// JLabel 은 html 을 인식하기 때문에
		// JLabel 내에서의 개행을 위하여 html로 작성함.
		String names = "<html><p>";
		for (int i = 0; i < movie.getActors().length; i++) {
			names += movie.getActors()[i];
			if (i < movie.getActors().length - 1) {
				names += ", ";
			}
			if ((i + 1) % 5 == 0) {
				names += "<br>";
			}
		}
		names += "</p></html>";

		JLabel actorsLabel = new JLabel(names);
		GridBagConstraints gbc_actorsLabel = new GridBagConstraints();
		gbc_actorsLabel.gridwidth = 3;
		gbc_actorsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_actorsLabel.gridx = 1;
		gbc_actorsLabel.gridy = 2;
		infoPanel.add(actorsLabel, gbc_actorsLabel);

		//누적관객
		JLabel cnt = new JLabel("누적관객");
		GridBagConstraints gbc_cnt = new GridBagConstraints();
		gbc_cnt.insets = new Insets(0, 0, 0, 5);
		gbc_cnt.gridx = 0;
		gbc_cnt.gridy = 3;
		infoPanel.add(cnt, gbc_cnt);

		// 예매한 파일을 열어서 예매한 사람 수를 계산
		ArrayList m = new ArrayList<>();
				
		m =	new PaymentController().getMoveReserve();
		int count = 0;
		if (m.size() > 0) {
			for (int i=0;i<m.size();i++) {
				if (((MovieReserve) m.get(i)).getMoviTitle().equals(movie.getTitle())) {
					count += ((MovieReserve) m.get(i)).getPersonNum();
				}
			}
		}

		JLabel cntLabel = new JLabel(String.valueOf(count));
		GridBagConstraints gbc_cntLabel = new GridBagConstraints();
		gbc_cntLabel.insets = new Insets(0, 0, 0, 5);
		gbc_cntLabel.fill = GridBagConstraints.VERTICAL;
		gbc_cntLabel.gridx = 1;
		gbc_cntLabel.gridy = 3;
		infoPanel.add(cntLabel, gbc_cntLabel);

		//평점
		JLabel score = new JLabel("평점");
		GridBagConstraints gbc_score = new GridBagConstraints();
		gbc_score.insets = new Insets(0, 0, 0, 5);
		gbc_score.gridx = 2;
		gbc_score.gridy = 3;
		infoPanel.add(score, gbc_score);

		String filename = movie.getTitle() + "리뷰" + ".txt";
		// 리뷰 파일 열어서 정보 가져오기
		ArrayList<Review> reviews = new ReviewController().getComment(filename);
		double avg;

		if (reviews.size() > 0) {
			double sum = 0;
			for (Review r : reviews) {
				sum += r.getScore();
			}

			avg = sum / reviews.size();
		} else {
			avg = 0.0;
		}

		JLabel scoreLabel = new JLabel(String.format("%.1f", avg));
		GridBagConstraints gbc_scoreLabel = new GridBagConstraints();
		gbc_scoreLabel.gridx = 3;
		gbc_scoreLabel.gridy = 3;
		infoPanel.add(scoreLabel, gbc_scoreLabel);

		//줄거리
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(228, 228, 228));
		textPane.setText(movie.getSummary());
		textPane.setEditable(false);
		add(textPane, BorderLayout.SOUTH);
	}

}
