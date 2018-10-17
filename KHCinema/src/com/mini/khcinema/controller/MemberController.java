package com.mini.khcinema.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.mini.khcinema.model.Member;

public class MemberController {
	String filename = "memberList.txt";
	static String loginID;

	// 회원 정보를 가져와서 ArrayList에 저장한 후 반환하는 메소드
	public ArrayList<Member> GetMembers() {
		ArrayList<Member> members = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {

			members = (ArrayList) ois.readObject();

		} catch (IOException e) {
			e.getStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return members;
	}

	public void SaveMembers(ArrayList<Member> members) {
		File memberFile = new File(filename);

		// 파일 없을 경우 만들기
		if (!memberFile.exists()) {
			try {
				memberFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(members);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void InputMember(String id, String password, String name, String birth, String email, String phone,
			String gender, String address) {
		ArrayList<Member> members = new ArrayList<>();

		// 파일이 없거나 파일에 아무것도 안 써있을 경우는 가져오지 않음
		File f = new File(filename);
		if (!f.exists() || f.length() == 0) {

		} else {
			members = GetMembers();// 반환값이 있을때 >>void 자리(항상 반환값자리)에 ArrayList <Member> 제네릭 되어 들어왔기 때문에.
		}

		Member m = new Member();
		m.setId(id);
		m.setPassword(password);
		m.setName(name);
		m.setBirth(birth);
		m.setPhone(phone);
		m.setEmail(email);
		m.setAddress(address);

		members.add(m);

		SaveMembers(members);// 반환값이 없을때.
	}

	public boolean memberCheck(String idck) {
		ArrayList<Member> memIdCheck = new ArrayList();
		// GetMembers() 호출하여 "memberList.txt" 파일을 불러와 현재 예매상태를 불러오고 그걸 mIdList에 넣는다.
		memIdCheck = GetMembers();// 객체를 불러와서 리스트로 바꿔 memIdCheck에 넣는다.
		// String checkId=new SignUpPanel().getText();

		if (memIdCheck != null) {
			for (int i = 0; i < memIdCheck.size(); i++) {

				Member m = (Member) memIdCheck.get(i);
				if (m.getId().equals(idck)) {
					return false;
				}

			}
		}
		return true;
	}

	public boolean loginCheck(String id, String password) {
		ArrayList<Member> login = new ArrayList();
		login = GetMembers();
		for (int i = 0; i < login.size(); i++) {
			Member m = (Member) login.get(i);

			if (m.getId().equals(id) && m.getPassword().equals(password)) {
				loginID = m.getId();// 현재 로그인 접속자
				return true;

			}

		}
		return false;

	}

}
