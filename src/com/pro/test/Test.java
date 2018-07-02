package com.pro.test;

import java.util.List;

import com.pro.dao.UserDAO;
import com.pro.entity.User;

public class Test {
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		//String username="1",role="1";
		String username="",role="1";
		List<User> userlist = userDAO.queryUserList( username , role);
		for (User user : userlist) {
			System.out.println(user.toString());
		}
	}
}
